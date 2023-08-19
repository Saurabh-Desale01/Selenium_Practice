package demo;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import util.WebBrowser;

public class WorkingWithMultiSelect {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		  WebDriver driver= WebBrowser.openBrowser("https://demoqa.com/select-menu");
		  Select ddcars=new Select(driver.findElement(By.id("cars")));
		  
		  ddcars.selectByValue("opel");
		  ddcars.selectByVisibleText("Audi");
		  
		  List<WebElement> selected=ddcars.getAllSelectedOptions();
		  for(WebElement s1:selected)
		  {
			  System.out.println(s1.getText());
		  }
		  
		  ddcars.deselectByValue("opel");
		  ddcars.selectByValue("volvo");
		  
		  selected=ddcars.getAllSelectedOptions();
		  for(WebElement s1:selected)
		  {
			  System.out.println(s1.getText());
		  }
		  ddcars.deselectAll();
	}

}
