package webui.loginPage;
import com.example.automation.base.BaseFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
        

// import groovy.time.Duration; // Removed incorrect import

public class PracticeTest extends BaseFactory {

    @Test(groups = {"web"})
    public static void sampleMethod() {
        driver.get("https://www.facebook.com/r.php?entry_point=login");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = driver.findElement(By.xpath("//label[text()='Male']//input[@type='radio']"));
        wait.until(ExpectedConditions.elementToBeClickable(element));
     
        if(!element.isSelected()){
            element.click();
        }
        else{
            System.out.println("Element is already selected");
        }

        System.out.println("This is a sample test method.");
        driver.close(); // Close the browser after the test
    }
}
