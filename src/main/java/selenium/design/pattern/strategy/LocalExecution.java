package selenium.design.pattern.strategy;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LocalExecution implements TestExecutionStrategy {

	@Override
	public WebDriver setupDriver(String browserName) {
		// TODO Auto-generated method stub
		switch (browserName.toLowerCase().trim()) {
			case "chrome":
				return new ChromeDriver();
			case "edge":
				return new EdgeDriver();
			case "firefox":
				return new FirefoxDriver();
			default:
				return null;
		}
				
		
	}

}
