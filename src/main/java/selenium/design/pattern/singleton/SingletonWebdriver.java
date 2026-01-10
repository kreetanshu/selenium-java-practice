package selenium.design.pattern.singleton;

import java.io.Serializable;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SingletonWebdriver implements Serializable, Cloneable {

	// Volatile: Every thread reads the latest value of instance directly from main
	// memory, not from a local thread cache.
	private static volatile SingletonWebdriver instance = null;
	private static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();

	private SingletonWebdriver() {
		// Prevent creating another instance via reflection
		if (instance != null) {
			throw new IllegalStateException("Object already exists");
		}
	}

	private void initDriver(String browser) {

		switch (browser) {
		case "chrome":
			tlDriver.set(new ChromeDriver());
			break;
		case "firefox":
			tlDriver.set(new FirefoxDriver());
			break;
		case "edge":
			tlDriver.set(new EdgeDriver());
			break;
		default:
			throw new IllegalArgumentException("Unsupported Browser Name");
		}
	}

	public static SingletonWebdriver getInstance(String browser) {
		if (instance == null) {
			synchronized (SingletonWebdriver.class) {
				if (instance == null) {
					instance = new SingletonWebdriver();
				}
			}
		}

		if (tlDriver.get() == null) {
			instance.initDriver(browser);
		}
		return instance;
	}

	public WebDriver getDriver() {
		return tlDriver.get();
	}

	public static void quitBrowser() {
		if (tlDriver.get() != null) {
			tlDriver.get().quit();
			tlDriver.remove();
		}
	}

	public static void quitAndReset() {
		if (tlDriver.get() != null) {
			tlDriver.get().quit();
			tlDriver.remove();
		}
		// allow fresh singleton creation for subsequent test runs
		instance = null;
	}

	// Add readResolve() -- called during de-serialization to preserve singleton
	protected Object readResolve() {
		return instance;
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		throw new CloneNotSupportedException("singleton instance can not be cloned..");
	}

}
