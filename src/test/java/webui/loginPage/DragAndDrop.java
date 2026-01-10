package webui.loginPage;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DragAndDrop {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		ChromeDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		
		driver.get("https://jqueryui.com/resources/demos/droppable/default.html");
		
//		JavascriptExecutor js = (JavascriptExecutor)driver;
//		js.executeScript("window.scrollBy(0,300)");
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		WebElement src = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("draggable")));
		
		//WebElement src = driver.findElement(By.xpath("//span[text()='Lawrence Block']"));
		
		WebElement dest = driver.findElement(By.id("droppable"));
		
		Actions actions = new Actions(driver);
		
		actions.dragAndDrop(src, dest).build().perform();
		
		Thread.sleep(3000);
		
		driver.quit();

	}

}
