package testng;

import org.testng.annotations.Test;

import util.WebBrowser;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;

public class RediffLoginTest {
	WebDriver driver;
  @Test (groups="top")
  public void validLogin() {
	  driver.findElement(By.id("login1")).sendKeys("testuser");
	  driver.findElement(By.id("password")).sendKeys("test@user");
	  driver.findElement(By.name("proceed")).click();
	  String acterror = driver.findElement(By.id("div_login_error")).getText();
	  assertEquals(acterror,"Wrong username and password combination.");//Temporary Issue. Please try again later. [#5002]
  }
  
  @Test (groups="bottom")
  public void invalidLogin(){
	  driver.findElement(By.id("login1")).sendKeys("admin");
	  driver.findElement(By.id("password")).sendKeys("admin@12");
	  driver.findElement(By.name("proceed")).click();
  }
  @BeforeMethod
  public void beforeMethod() {
	    System.out.println("In method");
  }
  @AfterMethod
  public void afterMethod() {
	  driver.findElement(By.id("login1")).clear();
  }
  @BeforeClass (alwaysRun=true)
  public void beforeClass() {
	  driver = WebBrowser.openBrowser("https://mail.rediff.com/cgi-bin/login.cgi");
  }

  @AfterClass (alwaysRun=true)
  public void afterClass() {
	  driver.close();
  }
  @BeforeTest
  public void setUpForTest2() {
	  System.out.println("Executing regression test2");
  }
  @AfterTest
  public void tearDownForTest2() {
	  System.out.println("End of regression test2 ");
  }
  @BeforeSuite   //suit is collection of multiple test
  public void setUpForSuit2() {
	  System.out.println("Executing new Suite2");
  }
  @AfterSuite   //suit is collection of multiple test
  public void tearDownForSuit2() {
	  System.out.println("End of the Suite2");
  }

}
