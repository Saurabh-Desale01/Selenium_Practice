package testng;

import org.testng.annotations.Test;

import pageextension.EmailPasswordPage;
import pageextension.EmailRegistration;
import pageextension.EmailSignin;
import util.WebBrowser;

import org.testng.annotations.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;

public class GmailTest {
	WebDriver driver;
	EmailRegistration er;
	EmailSignin es;
	EmailPasswordPage ep;
  
  @BeforeClass
  public void beforeClass() { 
	  driver= WebBrowser.openBrowser("https://accounts.google.com/signup/v2/webcreateaccount?flowName=GlifWebSignIn&flowEntry=SignUp");
      er=new EmailRegistration(driver);
      es=new EmailSignin(driver);
      ep=new EmailPasswordPage(driver);
  }
  @Test(priority=0)
  public void Registration() {
	  er.createAccount("abc", "xyz", "abc.xyz", "abc@123", "abc@123");
  }
  @Test(priority=1)
  public void navigateTo() {
	  er.navigateTOSignIn();
  }
  @Test(priority=2)
  public void email()
  {
	  es.signInEmail("sapudesale@gmail.com");
  }
  @Test(priority=3)
  public void psaaword() {
	  ep.signInPassword("abc@123");
  }

  @AfterClass
  public void afterClass() {
	  driver.close();
  }

}
