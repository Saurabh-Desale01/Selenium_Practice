package assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class demo1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "lib/chromedriver.exe");
    	WebDriver driver=new ChromeDriver();
    	
    	driver.get("https://www.echotrak.com/Login.aspx?ReturnUrl=%2f");
    	driver.findElement(By.id("txtCustomerID")).sendKeys("admin12");
    	driver.findElement(By.id("txtPassword")).sendKeys("admin@456");
    	driver.findElement(By.name("Butsub")).click();
    	
    	WebElement we=driver.findElement(By.id("lblMsg"));
    	String str=we.getText();
    	
    	if(str.equals("Invalid Username/Password"))
    	{
    		System.out.println("pass");
    	}
    	else
    	{
    		System.out.println("Fail");
    	}
	}

}
