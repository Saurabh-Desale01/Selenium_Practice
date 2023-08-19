package testng;

import org.testng.annotations.Test;

import util.WebBrowser;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;

public class GoogleTest {
	WebDriver driver;
  @Test(groups="top",priority=1)
  public void gmail() {
	  driver.findElement(By.linkText("Gmail")).click();
	  assertTrue(driver.getTitle().contains("Gmail"));
  }
  @Test(groups="top",priority=2)
  public void images() {
	  driver.findElement(By.linkText("Images")).click();
	  assertEquals(driver.getTitle(), "Google Images");
  }
  @Test(groups="bottom",priority=3)
  public void advertising() {
	  driver.findElement(By.linkText("Advertising")).click();
	  assertTrue(driver.getTitle().contains("Advertising"));
  }
  @Test(groups="bottom",priority=4)
  public void search() {
	  driver.findElement(By.partialLinkText("How Search")).click();
	  assertTrue(driver.getTitle().contains("Google Search"));
  }
  @AfterMethod (alwaysRun=true)
  public void afterMethod() {
	  driver.navigate().back();
  }

  @BeforeClass (alwaysRun=true)
  public void beforeClass() {
	  driver = WebBrowser.openBrowser("https://www.google.co.in/");
  }

  @AfterClass  (alwaysRun=true)
  public void afterClass() {
	  driver.close();
  }

}
