package selenium.design.pattern.strategy;

import org.openqa.selenium.WebDriver;

public class TestDriver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DriverContext dcLocal = new DriverContext(new LocalExecution());
		WebDriver driver = dcLocal.getDriver("firefox");
		driver.get("https://google.com");
		System.out.println("Local Execution Title "+driver.getTitle());
		
		
		dcLocal.setStrategy(new HeadlessExecution());
		WebDriver driverHeadless = dcLocal.getDriver("chrome");
		driverHeadless.get("https://google.com");
		System.out.println("Headless Execution Title "+ driverHeadless.getTitle());

	}

}
