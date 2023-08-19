package testng;

import org.testng.annotations.Test;

import pageextension.RediffLogin;
import pageextension.RediffRegistration;
import util.WebBrowser;

import org.testng.annotations.BeforeClass;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;

public class RediffPOMTest {
	WebDriver driver;
	RediffLogin rlogin;
	RediffRegistration rreg;
	
 @BeforeClass
 public void beforeClass() {
	 driver=WebBrowser.openBrowser("https://mail.rediff.com/cgi-bin/login.cgi");
	 rlogin=new RediffLogin(driver);
	 rreg=new RediffRegistration(driver);
	  }
  @Test(priority=0)
  public void validLogin() {
	  rlogin.login("admin01", "admin@1");
	  System.out.println("Login Succesfull");
	  rlogin.clearData();
	  }
  @Test(priority=1)
  public void invalidLogin() {
	  rlogin.login("txtuser", "txtpass@1");
	  assertEquals(rlogin.getError(), "Wrong username and password combination.");
  }
  @Test(priority=2)
  public void navigateToReg() {
	  rlogin.navigateToRegistration();
  }
  @Test(priority=3)
  public void register() {
	  rreg.createAccount("aaa", "aaa@123", "A@12", "m", "Argentina");
  }

  @AfterClass
  public void afterClass() {
	  driver.close();
  }

}
