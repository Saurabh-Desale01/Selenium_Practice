package util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebBrowser {
   public static WebDriver openBrowser(String url)
   {
		System.setProperty("webdriver.chrome.driver", "lib/chromedriver.exe");
    	WebDriver driver=new ChromeDriver();
    	driver.manage().window().maximize();
    	driver.get(url);
    	return driver;
   }
   public static void verifyTitle(WebDriver driver, String expTitle)
   {
	   String actTitle= driver.getTitle();
	   if(actTitle.equals(expTitle))
	   {
		   System.out.println("Pass");
	   }
	   else
	   {
		   System.out.println("Fail");
	   }
   }
}
