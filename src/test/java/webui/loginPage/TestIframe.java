package webui.loginPage;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestIframe {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.leafground.com/frame.xhtml");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10L));
		driver.manage().window().maximize();

		List<WebElement> iframes = driver.findElements(By.xpath("//iframe"));
		System.out.println("Count of frame is " + iframes.size());
		for (WebElement iframe : iframes) {
			driver.switchTo().frame(iframe);

			List<WebElement> elements = driver.findElements(By.xpath("//button[@id='Click']"));

			if (!(elements.size() == 0)) {
				String buttonText = elements.get(0).getText();
				System.out.println("button text"+buttonText);
			}
			//We need to switch to default content as for frame you need to be on base DOM unlike windows
			driver.switchTo().defaultContent();

		}
		driver.close();
	}
}
