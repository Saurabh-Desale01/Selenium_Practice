package demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import util.WebBrowser;

public class WorkingWithTable1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		  WebDriver driver= WebBrowser.openBrowser("https://www.techlistic.com/p/demo-selenium-practice.html");
		     String data="Meta,Francisco Chang,Mexico";
	         String[] adata=data.split(",");
	         List<String> expdata=Arrays.asList(adata);
	      WebElement table=driver.findElement(By.id("customers"));
	      
//find all rows of table
	      List<WebElement> rows= table.findElements(By.tagName("tr"));
	      System.out.println("no. of rows : "+rows.size());
	      for(WebElement row:rows)
	      {
	    	  List<WebElement> cells= row.findElements(By.tagName("td"));
	    	  for(WebElement cell:cells)
	    	  {
	    		  System.out.println(cell.getText());
	    	  }
	      }
	      driver.close();
	}

}
