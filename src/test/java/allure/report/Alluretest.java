package allure.report;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.qameta.allure.Allure;

public class Alluretest {
  @Test
  public void firstMethod() {
	  Allure.step("Executing first method");
	  Assert.assertTrue(false);
	  
  }
}
