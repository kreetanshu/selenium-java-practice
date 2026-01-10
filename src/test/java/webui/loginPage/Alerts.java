package webui.loginPage;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Alerts {
	


	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.leafground.com/alert.xhtml");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		
		List<WebElement> alertLinks = driver.findElements(By.xpath("//span[text()='Show']"));
		
		alertLinks.get(0).click();
		
		Thread.sleep(3000);
		
		Alert alert1 = driver.switchTo().alert();
		
		alert1.accept();
		
		alertLinks.get(1).click();
		
		Thread.sleep(3000);
		
		Alert alert2 = driver.switchTo().alert();
		
		System.out.println(alert2.getText());
		
		alert2.accept();
		
        alertLinks.get(3).click();
		
		Thread.sleep(3000);
		
//		Set<String> windows = driver.getWindowHandles();
//      String defaultHandle= driver.getWindowHandle();	
//   	System.out.println("Default Window Handle"+defaultHandle);
		
		
		//The modal alerts is a basic pop up no need to use alert for that and also this is not a new Window or tab
		
		WebElement windowText = driver.findElements(By.xpath("//p[@class='m-0']")).get(0);
	    
	    System.out.println("Window Popup text"+ windowText.getText());
	    
	    WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
	    
	    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Modal Dialog (Sweet Alert)']/following-sibling::a[@aria-label='Close']")));
	    
	    driver.findElement(By.xpath("//span[text()='Modal Dialog (Sweet Alert)']/following-sibling::a[@aria-label='Close']")).click();
	    
	    /*
		
		for(String window: windows) {
			if(!window.equalsIgnoreCase(defaultHandle)) {
				driver.switchTo().window(window);		
			    break;				
			}
		}
	    
	    driver.switchTo().window(defaultHandle);
	    */
		
	    driver.quit();	
	}

}
