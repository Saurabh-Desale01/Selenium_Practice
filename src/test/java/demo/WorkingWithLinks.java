package demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WorkingWithLinks {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "lib/chromedriver.exe");
    	WebDriver driver=new ChromeDriver();
    	driver.manage().window().maximize();
    	driver.get("https://www.google.com");
    	
   // Gmail
    	driver.findElement(By.linkText("Gmail")).click();
    	if(driver.getTitle().equals("Gmail"))
    	{
    		System.out.println("Title matched : Gmail");
    	}
    	driver.navigate().back();
   // Image
    	driver.findElement(By.linkText("Images")).click();
    	if(driver.getTitle().equals("Google Images"))
    	{
    	System.out.println("Image matched : Images");
    	}
    	driver.navigate().back();
   // partial link text should used for dynamic link
    	driver.findElement(By.partialLinkText("How Search")).click();
    	if(driver.getTitle().equals("Google Search – Discover how Google Search works"))
    	{
    		System.out.println("Title matched : Search");
    	}
    	 driver.close();
	}
	
}
