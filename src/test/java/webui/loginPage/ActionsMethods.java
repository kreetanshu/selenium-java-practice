package webui.loginPage;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionsMethods {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		ChromeDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		
		driver.get("https://www.google.com/");
		
		WebElement searchBox = driver.findElement(By.name("q"));
		
		searchBox.sendKeys("test");
		
		Thread.sleep(3000);
		
		Actions action = new Actions(driver);
		
		WebElement seachText = driver.findElement(By.xpath("//b[contains(text(),'ranking')]"));
		
		action.moveToElement(seachText).click().build().perform();
		
		Thread.sleep(3000);
		
//		driver.get("https://www.google.com/");
//		
//		
//		WebElement searchButton = driver.findElement(By.xpath("//input[@value='Google Search' and @role='button']"));
//		
//		action.contextClick(searchButton).build().perform();
		
     
		
		driver.quit();
		
		
	}

}
