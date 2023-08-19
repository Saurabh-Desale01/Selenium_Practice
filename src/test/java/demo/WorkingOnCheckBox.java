package demo;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import util.WebBrowser;

public class WorkingOnCheckBox {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
      /* WebDriver driver= WebBrowser.openBrowser("https://echoecho.com/htmlforms09.htm");
       List<WebElement> checkboxes=driver.findElements(By.cssSelector("td.table5>input"));
       for(WebElement wb:checkboxes)
       {
    	   if(wb.getAttribute("value").equals("milk"))
    	   {
    		   if(!wb.isSelected())
    		   {
    			   wb.click();
    			   break;
    		   }
    	   }
       }
       for(WebElement wb:checkboxes)
       {
    	   if(wb.getAttribute("value").equals("cheese"))
    	   {
    		   if(!wb.isSelected())
    		   {
    			   wb.click();
    			   break;
    		   }
    	   }
       }*/
       WebDriver driver= WebBrowser.openBrowser("http://demo.automationtesting.in/Register.html");
       List<WebElement> checkboxes=driver.findElements(By.cssSelector("form#basicBootstrapForm>div:nth-child(6)>div>div>input"));
       for(WebElement wb:checkboxes)
       {
    	   if(wb.getAttribute("value").equals("Cricket"))
    	   {
    		   if(!wb.isSelected())
    		   {
    			   wb.click();
    			   break;
    		   }
    	   }
       }
       for(WebElement wb:checkboxes)
       {
    	   if(wb.getAttribute("value").equals("Movies"))
    	   {
    		   if(!wb.isSelected())
    		   {
    			   wb.click();
    			   break;
    		   }
    	   }
       }
	}

}
