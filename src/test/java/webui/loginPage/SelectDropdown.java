package webui.loginPage;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class SelectDropdown {
	
	static boolean isListSorted(List<String> list1, List<String> list2) {
		//Assert.assertEquals(list1, list2);
		return list1.equals(list2);
	}

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://demoqa.com/select-menu");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		
		WebElement selectClick = driver.findElement(By.id("oldSelectMenu"));
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true)", selectClick);
		
		Select select = new Select(selectClick);
		
		List<WebElement> webelements = select.getOptions();
		
		List<String> actualList = new ArrayList<>();
		
		for(WebElement element: webelements) {
			actualList.add(element.getText());
		}
		
		System.out.println(actualList);
		
		List<String> sortedList = new ArrayList<String>();
		
		sortedList.addAll(actualList);
		
		Collections.sort(sortedList);
		
		System.out.println(sortedList);
		
		System.out.println(isListSorted(actualList, sortedList));
		
		select.selectByIndex(1);
		
		Thread.sleep(2000);
		
		select.selectByVisibleText("Green");
		
		System.out.println(select.getFirstSelectedOption().getText());
		
		driver.quit();

	}

}
