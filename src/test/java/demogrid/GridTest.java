package demogrid;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class GridTest {
  @Test
  public void chrome() throws MalformedURLException {
	  String appr1="https://www.google.com";
	  
	  String host="http://localhost:4444";
	  ChromeOptions option=new ChromeOptions();
	  option.setPlatformName("windows 11");
	  
	  URL url=new URL(host);
	  
	  WebDriver driver=new RemoteWebDriver(url, option);
	  driver.get(appr1);
	  driver.findElement(By.name("q")).sendKeys("grid");
  }
}
