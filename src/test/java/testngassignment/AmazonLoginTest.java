package testngassignment;

import org.testng.annotations.Test;

import util.WebBrowser;

import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;

public class AmazonLoginTest {
	WebDriver driver;
  @Test
  public void validAccount() {
	  driver.findElement(By.id("ap_customer_name")).sendKeys("Saurabh");
	  //driver.findElement(By.className("a-dropdown-prompt")).isSelected();
	  driver.findElement(By.id("ap_phone_number")).sendKeys("9822756746");
	  driver.findElement(By.id("ap_email")).sendKeys("sapudesale@gmail.com");
	  driver.findElement(By.id("ap_password")).sendKeys("des1234");
  }
  @BeforeClass
  public void beforeClass() {
	  driver=WebBrowser.openBrowser("https://www.amazon.in/ap/register?showRememberMe=true&openid.pape.max_auth_age=0&openid.return_to=https%3A%2F%2Fwww.amazon.in%2F%3F_encoding%3DUTF8%26ref_%3Dnav_ya_signin&prevRID=J5XC2Q3JMQR485MRG6R7&openid.identity=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.assoc_handle=inflex&openid.mode=checkid_setup&prepopulatedLoginId=&failedSignInCount=0&openid.claimed_id=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&pageId=inflex&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0");
  }

  @AfterClass
  public void afterClass() {
	  driver.close();
  }

}
