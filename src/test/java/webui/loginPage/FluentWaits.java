package webui.loginPage;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import com.google.common.base.Function;

public class FluentWaits {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--incognito");
		ChromeDriver driver = new ChromeDriver(option);
		driver.get("http://seleniumpractise.blogspot.in/2016/08/how-to-use-explicit-wait-in-selenium.html");
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//button[text()='Click me to start timer']")).click();
		
		
		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver).
				withTimeout(Duration.ofSeconds(30)).
				pollingEvery(Duration.ofSeconds(1)).
				ignoring(NoSuchElementException.class);
		
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("demo"))); Expected Condition can't be uses as we need to write a function
        
		WebElement jsElement = wait.until(new Function<WebDriver,WebElement>(){
			@Override
			public WebElement apply(WebDriver driver) {
				WebElement element = driver.findElement(By.xpath("//p[@id='demo']"));
				
				String innerHTML = element.getDomProperty("innerHTML");
				
				//Dom property should be used as this is for Dynamic JS updates
				
				if(innerHTML!=null && innerHTML.equalsIgnoreCase("WebDriver")) {
					System.out.println("Inner HTLM attribute value"+element.getDomProperty("innerHTML"));
					return element;
				}
				else {
					System.out.println("Inner HTLM using DOM Attribute"+ element.getDomAttribute("innerHTML"));
					System.out.println("Inner HTML using get DOM property "+element.getDomProperty("innerHTML"));
					//System.out.println("Get text "+element.getText());
					return null;
				}
			}
		});
		
		System.out.println("Get text WEB Driver for the demo element "+jsElement.getText());
		
		driver.quit();
	}

}
