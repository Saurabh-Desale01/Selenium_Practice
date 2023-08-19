package demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WorkingWithIdName {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "lib/chromedriver.exe");
    	WebDriver driver=new ChromeDriver();
    	driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
    	
    	/*WebElement txt= driver.findElement(By.id("login1"));//for usename
    	txt.sendKeys("admin");*/
    	driver.findElement(By.id("login1")).sendKeys("admin");
   //login1= id name , admin is field/usename passed by user
    	
    	/*WebElement txt1=driver.findElement(By.id("password"));
    	txt1.sendKeys("admin@123");*/
    	driver.findElement(By.id("password")).sendKeys("admin@12");//for passsword
   //password= id name in html , admin@12= password passed by user
    	
    	driver.findElement(By.name("proceed")).click();//for login button
    	
    	WebElement lbe=driver.findElement(By.id("div_login_error"));
    	String str=lbe.getText();
    	
    	if(str.equals("Wrong username and password combination."))
    	{
    		System.out.println("pass");
    	}
    	else
    	{
    		System.out.println("fail");
    	}
 // 2. echotrack example
    	
    	/*driver.get("https://www.echotrak.com/Login.aspx?ReturnUrl=%2f");
    	driver.findElement(By.id("txtCustomerID")).sendKeys("admin12");
    	driver.findElement(By.id("txtPassword")).sendKeys("admin@456");
    	driver.findElement(By.name("Butsub")).click();*/
	}

}
