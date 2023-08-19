package testngassignment;

import org.testng.annotations.Test;

import util.WebBrowser;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;

public class RediffLoginParametersTest {
	WebDriver driver;
  @Parameters ({"username" , "password"})
  @Test
  public void validLogin(String username, String password) {
	  driver.findElement(By.id("login1")).sendKeys(username);
	  driver.findElement(By.id("password")).sendKeys(password);
	  driver.findElement(By.name("proceed")).click();
	  String acterror = driver.findElement(By.id("div_login_error")).getText();
	  assertEquals(acterror,"Wrong username and password combination.");
  }
  @BeforeClass
  public void beforeClass() {
	  driver=WebBrowser.openBrowser("https://mail.rediff.com/cgi-bin/login.cgi");
  }

  @AfterClass
  public void afterClass() {
	  driver.close();
  }

}
