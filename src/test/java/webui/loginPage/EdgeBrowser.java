package webui.loginPage;

import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EdgeBrowser {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.edge.driver", ".\\drivers\\msedgedriver.exe");
		EdgeOptions edgeOptions = new EdgeOptions();
		edgeOptions.addArguments("--inprivate");
		EdgeDriver ed = new EdgeDriver(edgeOptions);
		
		ed.get("https://www.saucedemo.com/");
        ed.quit();
	}

}
