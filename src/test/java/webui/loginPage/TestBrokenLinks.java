package webui.loginPage;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.example.automation.utils.commonUtils.APIUtils;

import io.restassured.response.Response;

public class TestBrokenLinks {
	static APIUtils apiUtils = new APIUtils();

	public static void checkLinks(List<WebElement> links) {

		for (WebElement link : links) {

			String url = link.getDomAttribute("href");

			if (url == null || url.isEmpty()) {
				System.out.println("The link is empty " + link);
			}
			else {
				Response res;
				try {
					res = apiUtils.sendGetRequest(url);
					if (res.getStatusCode() >= 400) {
						System.out.println("Broken link " + url);
					} else {
						System.out.println("Valid link " + url);
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					System.out.println(url + " is broken. Exception: " + e.getMessage());
				}
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://www.google.co.in/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();

		List<WebElement> links = driver.findElements(By.tagName("a"));
		checkLinks(links);
		driver.quit();
	}

}
