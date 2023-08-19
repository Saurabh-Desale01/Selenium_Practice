package demo;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import util.WebBrowser;

public class WorkingOnRadio {
	public static void main(String args[]) {
 /* WebDriver driver=WebBrowser.openBrowser("https://echoecho.com/htmlforms10.htm");
  
	//Locate the radios
	List<WebElement> radios=driver.findElements(By.name("group1"));
	for(WebElement rb:radios)
	{
		if(rb.getAttribute("value").equals("Cheese"))
		{
			rb.click();
			break;
		}
	}*/
		WebDriver driver=WebBrowser.openBrowser("https://register.rediff.com/register/register.php?FormName=user_details");
		//Locate the radios
		List<WebElement> radios= driver.findElements(By.cssSelector("input[name^='gender']"));
		for(WebElement rb:radios)
		{
			if(rb.getAttribute("value").equals("f"))
			{
				rb.click();
				break;
			}
		}
  }

}
