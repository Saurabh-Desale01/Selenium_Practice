package demo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Options;
import org.openqa.selenium.WebDriver.Window;
import org.openqa.selenium.chrome.ChromeDriver;

public class LaunchinBrowser {
    public static void main(String args[])
    {
    	System.setProperty("webdriver.chrome.driver", "lib/chromedriver.exe");
    	WebDriver driver=new ChromeDriver();
    	
    	Options op=driver.manage();
    	Window win= op.window();
    	win.maximize();
    	//driver.manage().window().maximize();
    	driver.get("https://www.google.com");
    	String title= driver.getTitle();
    	System.out.println("Title of the page : "+title);
    	System.out.println("Url : "+driver.getCurrentUrl());
    	driver.close();
    }
}
