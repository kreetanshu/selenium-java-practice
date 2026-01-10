package webui.loginPage;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class JavasciptExecutorTests {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--incognito");

        ChromeDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://saucelabs.com/");
        
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement okButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='OK']")));
        okButton.click();
        
        JavascriptExecutor js = (JavascriptExecutor)driver;
        //

        WebElement el = driver.findElement(By.xpath("//button[text()='Book a demo']"));

        //Draw a border red color around element      
        js.executeScript("arguments[0].style.border='3px solid red';", el);
        
        //Utility to change the backgroud color of an element
        js.executeScript("arguments[0].style.backgroundColor = 'red';", el);
        
        //Utility to scroll
        js.executeScript("arguments[0].scrollIntoView(true);", el);
        
        //Utility to click using JS
        js.executeScript("arguments[0].click();", el);
        
        Thread.sleep(3000);
        driver.quit();
	}

}
