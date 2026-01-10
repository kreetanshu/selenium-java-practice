package webui.loginPage;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;

public class TestCode {
	
	static ChromeDriver driver = new ChromeDriver();
	
	public static void testCerts() {
	
	}

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		  // Launch Edge browser
        try {
            driver = new ChromeDriver();
            String filePath = System.getProperty("user.dir") + File.separator +"Sample.html";

            System.out.println(filePath);
            driver.get(filePath);

         // Navigate to the HTML file (assuming it's saved as "dom_practice.html")
           
            driver.manage().window().maximize();            
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            
            // Locate the input element
            WebElement inputElement = driver.findElement(By.id("myInput"));
            
            Actions action = new Actions(driver);
            
            action.scrollToElement(inputElement);
            
            Thread.sleep(3000);

            // 1. Get initial DOM attribute and property
            String initialAttributeValue = inputElement.getDomAttribute("value");
            String initialPropertyValue = inputElement.getDomProperty("value");

            System.out.println("--- Before Interaction ---");
            System.out.println("Initial 'value' attribute: " + initialAttributeValue);
            System.out.println("Initial 'value' property: " + initialPropertyValue);
            
//            // Change the input value dynamically using JavaScript
//            WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
//            wait.until(ExpectedConditions.visibilityOf(inputElement));
            
            Wait<ChromeDriver> fluentWait = new FluentWait<>(driver).
            		withTimeout(Duration.ofSeconds(10)).
            		pollingEvery(Duration.ofSeconds(1)).
            		ignoring(NoSuchElementException.class);
            
            fluentWait.until(ExpectedConditions.visibilityOf(inputElement));
            
            driver.executeScript("arguments[0].value = 'HelloWorld';",inputElement);
            
            Thread.sleep(5000);

            // 2. Interact with the element (e.g., click the update button)
            WebElement updateButton = driver.findElement(By.tagName("button"));
            updateButton.click();

            // 3. Get DOM attribute and property after interaction
            String updatedAttributeValue = inputElement.getDomAttribute("value");
            String updatedPropertyValue = inputElement.getDomProperty("value");

            System.out.println("\n--- After Interaction (JavaScript Update) ---");
            System.out.println("Updated 'value' attribute: " + updatedAttributeValue);
            System.out.println("Updated 'value' property: " + updatedPropertyValue);
            
            

            /**
        	ChromeOptions options = new ChromeOptions();
            options.setAcceptInsecureCerts(true);  // Accept insecure SSL certificates
            
            driver = new ChromeDriver(options);
            driver.get("https://self-signed.badssl.com/");  // Example site with self-signed SSL
            System.out.println("Page title is: " + driver.getTitle());
            
            **/
            
        	/**
            WebElement element = driver.findElement(By.id("sb_form_q"));
            element.sendKeys("WebDriver");
            Set<String> windows= driver.getWindowHandles();
            windows.add("apple");
            //List<String> list = new ArrayList<>(windows); converting set to list
            System.out.println(windows);
            ChromeOptions options = new ChromeOptions();
            options.setAcceptInsecureCerts(true);  // Accept insecure SSL certificates
            element.submit();

            
            **/
        	Thread.sleep(5000); // Pause to see results
        } finally {
            driver.quit();    // Close browser and end session
        }

	}

}
