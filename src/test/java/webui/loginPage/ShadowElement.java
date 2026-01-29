package webui.loginPage;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ShadowElement {

    public static void main(String[] args) throws InterruptedException {

        ChromeDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		
		driver.get("chrome://settings/appearance");

        WebElement dropDownElement = driver.findElement(By.xpath("//settings-ui")).getShadowRoot()
        .findElement(By.cssSelector("settings-main#main")).getShadowRoot()
        .findElement(By.cssSelector("cr-view-manager#switcher"))
        .findElement(By.tagName("settings-appearance-page-index")).getShadowRoot()
        .findElement(By.cssSelector("cr-view-manager#viewManager"))
        .findElement(By.tagName("settings-appearance-page")).getShadowRoot()
        .findElement(By.cssSelector("select#colorSchemeModeSelect"));
        
        

        dropDownElement.click();

        Thread.sleep(5000);

        driver.quit();
        
    }
    
}
