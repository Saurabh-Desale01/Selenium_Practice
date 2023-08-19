package assignments;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import util.WebBrowser;

public class WorkingForDropDown {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean flag=true;
	      WebDriver driver= WebBrowser.openBrowser("http://register.rediff.com/register/register.php?FormName=user_details");
	      WebElement wb=driver.findElement(By.id("country"));
	      Select dd=new Select(wb);
	      List<WebElement> options=dd.getOptions();
	      for(WebElement op:options)
	      {
	    	  if(op.getAttribute("value").equals("3"))
	    	  {
	    		  flag=true;
	    		  dd.selectByValue("3");
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
	}

}
