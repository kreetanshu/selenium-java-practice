package webui.loginPage;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class Windows {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.leafground.com/window.xhtml");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//span[text()='Open Multiple']")).click();
		
		Thread.sleep(3000);
		
		Set<String> windows = driver.getWindowHandles();
        String defaultHandle= driver.getWindowHandle();	
     	System.out.println("Windows "+windows);
     	System.out.println("Parent Window Title "+driver.getTitle());
     	
     	for(String window: windows) {
			if(!window.equalsIgnoreCase(defaultHandle)) {
				driver.switchTo().window(window);		
			    System.out.println("Child window tiltle "+driver.getTitle());		
			}
		}
	    
	    driver.switchTo().window(defaultHandle);
	    driver.quit();

	}

}
