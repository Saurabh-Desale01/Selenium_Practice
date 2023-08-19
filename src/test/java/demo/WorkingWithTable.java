package demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import util.WebBrowser;

public class WorkingWithTable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int cno=2;
		int rno=3;
		  WebDriver driver= WebBrowser.openBrowser("https://www.techlistic.com/p/demo-selenium-practice.html");
         String data="Meta, Francisco Chang, Mexico";
         String[] adata=data.split(",");
         List<String> expdata=Arrays.asList(adata);
         List<String> actdata=new ArrayList<>();
  //data for row 3
        List<WebElement> rowdata=driver.findElements(By.xpath("//table[@id='customers']/tbody/tr["+rno+"]/td["+cno+"]"));
        for(WebElement rdata:rowdata)
        {
        	actdata.add(rdata.getText());
        }
        if(actdata.equals(expdata))
        {
        	System.out.println("row data matched");
        }
        else
        {
        	System.out.println("row data not matched");
        }
  //find data for cell[3,2]
        String expval="Francisco Chang";
        WebElement celldata=driver.findElement(By.xpath("//table[@id='customers']/tbody/tr["+rno+"]/td["+cno+"]"));
        if(celldata.getText().equals(expval))
        {
        	System.out.println("cell data matched");
        }
        else
        {
        	System.out.println("cell data mismatched");
        }
  //to get data from col[2]
        List<WebElement> coldata=driver.findElements(By.xpath("//table[@id='customers']/tbody/tr/td["+cno+"]"));
        for(WebElement cdata:coldata)
        {
        	System.out.println(cdata.getText());
        }
        driver.close();
	}
}
