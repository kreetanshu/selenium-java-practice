package selenium.design.pattern.strategy;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class HeadlessExecution implements TestExecutionStrategy {

	@Override
	public WebDriver setupDriver(String browserName) {
		switch (browserName.toLowerCase().trim()) {
		case "chrome":
			ChromeOptions chromeOptions = new ChromeOptions();
			chromeOptions.addArguments("--headless");
			chromeOptions.addArguments("--disable-gpu");
			return new ChromeDriver(chromeOptions);
		case "edge":
			 EdgeOptions edgeOptions = new EdgeOptions();
			 edgeOptions.addArguments("--headless=new");
			 edgeOptions.addArguments("--disable-gpu");  
			return new EdgeDriver(edgeOptions);
		case "firefox":
			FirefoxOptions firefoxOptions = new FirefoxOptions();
			firefoxOptions.addArguments("--headless=new");
			firefoxOptions.addArguments("--disable-gpu");
			return new FirefoxDriver(firefoxOptions);
		default:
			return null;
	}
	}

}
