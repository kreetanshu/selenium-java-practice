package webui.loginPage;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.testng.Assert.assertTrue;

public class ListMenus {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://demoqa.com/select-menu");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();

		JavascriptExecutor js = (JavascriptExecutor)driver;
		WebElement element = driver.findElement(By.xpath("//b[text()='Multiselect drop down']"));
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		wait.until(ExpectedConditions.visibilityOf(element));
		
		js.executeScript("arguments[0].scrollIntoView(true)", element);
		
		//action.moveToElement(driver.findElement(By.xpath("//b[text()='Multiselect drop down']"))).perform();
		
		//React dropdown menu, inspect works after workaround of Event Listener, blur
		List<WebElement> dropdownClicks = driver.findElements(By.xpath("//div[contains(@class,' css-tlfecz-indicatorContainer')]"));
		System.out.println("Number of Dropdown clicks are "+ dropdownClicks.size());
		dropdownClicks.get(2).click();
		
		List<WebElement> values = driver.findElements(By.xpath("//div[starts-with(@id,'react-select-4-option')]"));
		
		System.out.println("Number of values from dropdown "+values.size());
		
		//Selecting values from multi-select list
		for(WebElement value:values) {
			System.out.println("Dropdown value "+value.getText());
			if(value.getText().equalsIgnoreCase("Blue") || value.getText().equalsIgnoreCase("Red")) {
				value.click();
			}
		}
		
		List<WebElement> selectedValues = driver.findElements(By.xpath("//div[@class='css-1rhbuit-multiValue']//div[@class='css-12jo7m5']"));
		System.out.println("Number of selected values from dropdown "+selectedValues.size());
		
		
		//Checking the selected values match to Red or Blue
		for(WebElement value: selectedValues) {
			System.out.println("Selected Value "+value.getText());
			assertTrue (value.getText().equalsIgnoreCase("Blue") || value.getText().equalsIgnoreCase("Red"));
		}
       
		driver.quit();
	}

}
