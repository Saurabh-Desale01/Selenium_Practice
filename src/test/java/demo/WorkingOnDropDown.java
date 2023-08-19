package demo;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import util.WebBrowser;

public class WorkingOnDropDown {

	public static void main(String[] args) {
		// TODO Auto-generated method stub  //drop selected by selectByIndex, selectByValue, selectByVisibleText
		boolean flag=true;
      WebDriver driver= WebBrowser.openBrowser("https://echoecho.com/htmlforms11.htm");
      WebElement wb=driver.findElement(By.name("mydropdown"));
      Select dd=new Select(wb);
      List<WebElement> options=dd.getOptions();
      for(WebElement op:options)
      {
    	  if(op.getAttribute("value").equals("Fresh Milk"))
    	  {
    		  flag=true;
    		  dd.selectByVisibleText("Fresh Milk");
    		  System.out.println(dd.getFirstSelectedOption().getText());
    		  break;
    	  }
    	  else
    	  {
    		  flag=false;
    	  }
      }
      if(flag==false)
      {
    	  System.out.println("option is wrong");
      }
	
	   /*for(WebElement op:options)
	      {
	    	  if(op.getText().equals("Hot Bread"))
	    	  {
	    		  flag=true;
	    		  dd.selectByVisibleText("Hot Bread");
	    		  System.out.println(dd.getFirstSelectedOption().getText());
	    		  break;
	    	  }
	    	  else
	    	  {
	    		  flag=false;
	    	  }
	      }
	      if(flag==false)
	      {
	    	  System.out.println("option is wrong");
	      }*/
		}
}

