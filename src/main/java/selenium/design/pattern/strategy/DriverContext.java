package selenium.design.pattern.strategy;

import org.openqa.selenium.WebDriver;

public class DriverContext {
	
	private TestExecutionStrategy testExecutionStrategy;
	
	DriverContext(TestExecutionStrategy testExecutionStrategy){
		this.testExecutionStrategy = testExecutionStrategy;
	}
	
	//Setter to update strategy after object creation
	public void setStrategy(TestExecutionStrategy testExecutionStrategy) {
		this.testExecutionStrategy = testExecutionStrategy;
	}
	
	public WebDriver getDriver(String browserName){
		return testExecutionStrategy.setupDriver(browserName);
	}

}
