package selenium.design.pattern.strategy;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

public class RemoteExecution implements TestExecutionStrategy {

	@Override
	public WebDriver setupDriver(String browserName) {
		// TODO Auto-generated method stub
		switch (browserName.toLowerCase().trim()) {
		case "chrome":
			ChromeOptions chromeOptions = new ChromeOptions();
			chromeOptions.setCapability(browserName, "chrome");
			try {
				return new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),chromeOptions);
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		case "edge":
			EdgeOptions edgeOptions = new EdgeOptions();
			edgeOptions.setCapability(browserName, "edge");
			try {
				return new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),edgeOptions);
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		case "firefox":
			FirefoxOptions firefoxOptions = new FirefoxOptions();
			firefoxOptions.setCapability(browserName, "edge");
			try {
				return new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),firefoxOptions);
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		default:
			return null;
	 }
	}

}
