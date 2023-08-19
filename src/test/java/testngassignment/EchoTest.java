package testngassignment;

import org.testng.annotations.Test;

import util.WebBrowser;

import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;

public class EchoTest {
	WebDriver driver;
  @Test(dataProvider = "searchFlight")
  public void searchs(String flyingfrom , String flyingto) {
	  driver.findElement(By.id("autocomplete")).sendKeys(flyingfrom);
	  driver.findElement(By.id("autocomplete2")).sendKeys(flyingto);
	  driver.findElement(By.id("flights-search")).click();
	  
  }

  @DataProvider
  public String[][] searchFlight() {
	  String [][]search= new String [3][2];
	  search[0][0]="PNQ - Pune - Pune";
	  search[0][1]="BOM - Chhatrapati Shivaji Intl - Mumbai";
	  search[1][0]="BOM - Chhatrapati Shivaji Intl - Mumbai";
	  search[1][1]="DEL - Indira Gandhi Intl - Delhi";
	  search[2][0]="DEL - Indira Gandhi Intl - Delhi";
	  search[2][1]="BLR - Bangalore - Bangalore";
	  return search;
   
  }
  @AfterMethod
  public void clearData() {
	  driver.findElement(By.id("autocomplete")).clear();
	  driver.findElement(By.id("autocomplete2")).clear();
  }
  @BeforeClass
  public void beforeClass() {
	  driver=WebBrowser.openBrowser("https://www.phptravels.net/flights");
  }

  @AfterClass
  public void afterClass() {
	  driver.close();
  }

}
