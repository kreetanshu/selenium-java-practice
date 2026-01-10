package webui.loginPage;

import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;

public class TestNGTests {
  
  @BeforeClass
  public void beforeClass() {
	  System.out.println("Before Class Methods");
  }
	
  @Test(dataProvider = "dp")
  public void firstPrintPosition(Integer n, String s) {
	  System.out.println("The position of letter "+s+" is "+n);
	  System.out.println("Thread ID Is : " + Thread.currentThread().getId());
  }
  
  @Test(dataProvider = "dp")
  public void secondJoinThem(Integer n, String s) {
	  System.out.println("Joined Aplha is "+s+n);
	  System.out.println("Thread ID Is : " + Thread.currentThread().getId());
  }
  
  @Test(dataProvider = "dp")
  public void thirdUpperCase(Integer n, String s) {
	  System.out.println("UpperCase letter "+s.toUpperCase()+" is "+n);
	  System.out.println("Thread ID Is : " + Thread.currentThread().getId());
  }
  
  

  @DataProvider
  public Object[][] dp() {
    return new Object[][] {
      new Object[] { 1, "a" },
      new Object[] { 2, "b" },
      new Object[] { 3, "c" },
      new Object[] { 4, "d" }
    };
  }
 

  @AfterClass
  public void afterClass() {
	  System.out.println("After class methods");
  }

}
