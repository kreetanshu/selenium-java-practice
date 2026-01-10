package selenium.design.pattern.singleton;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class SingletonTest {
	
	private WebDriver driver;
	
	@BeforeClass
	@Parameters("browser")
	public void setupDriver(String browser) {
		driver=SingletonWebdriver.getInstance(browser).getDriver();
	}
	
	@Test
	public void testApp() {
		driver.get("https://www.saucedemo.com/");
		Assert.assertEquals(driver.getTitle(), "Swag Labs");
		System.out.println("Thread ID "+Thread.currentThread().getId());
	}
	
	@AfterClass
	public void tearDown() {
		SingletonWebdriver.quitAndReset();
	}
	

}
