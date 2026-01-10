package allure.report;

import java.awt.desktop.SystemSleepEvent;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.qameta.allure.Allure;

public class Alluretest2 {
	@Test
	public void secondMethod() throws IOException {
		Allure.step("Executing second method");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();

		driver.get("https://www.google.com/");
		
//		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//		String outputPath = System.getProperty("user.dir")+File.separator+"Screenshots"+File.separator+"Allure.png";
//		File dest = new File(outputPath);
//		FileUtils.copyFile(src, dest);
//		Allure.attachment("Step Screenshot", outputPath);
		
		byte[] screenshotBytes = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
		
		Allure.attachment("Screenshot on Failure", new ByteArrayInputStream(screenshotBytes));
		Assert.assertTrue(true);
	}
}
