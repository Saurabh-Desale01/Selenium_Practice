package testngassignment;

import org.testng.annotations.Test;


import util.WebBrowser;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;

public class AmazonSearchTest {
     WebDriver driver;
    @Parameters ("product")
	@Test
  public void validSearch(@Optional("mobile")String product) {
	  driver.findElement(By.id("twotabsearchtextbox")).sendKeys(product);
	  driver.findElement(By.id("nav-search-submit-button")).click();
	  String title=driver.getTitle();
	  assertEquals(title.contains(product), "title did not match");
	  //assertTrue(title.contains("laptops"), "title did not match");
	 // assertTrue(title.contains("laptops"),"title did not match");
  }
  
	@Parameters ("criteria")
    @Test//(dependsOnMethods="search")
    public void sortResult(@Optional("Avg. Customer Review")String criteria) {
    	driver.findElement(By.xpath("//span[@class=\"a-dropdown-label\"]")).click();
    	List<WebElement> option = driver.findElements(By.xpath("//a[@id=\"s-result-sort-select_2\"]"));
    	for(WebElement op:option)
    	{
    		if(op.getText().equals(criteria))
    		{
    			op.click();
    			break;
    		}
    	}
    }
  /*@Test
  public void invalidSearch(){
	  driver.findElement(By.id("twotabsearchtextbox")).sendKeys("lap");
	  driver.findElement(By.id("nav-search-submit-button")).click();
  }*/
  @BeforeClass
  public void setUp() {
	  driver = WebBrowser.openBrowser("https://www.amazon.in/");
  }

  @AfterClass
  public void tearDemo() {
	  driver.close();
  }
  @BeforeTest       //test is collection of multiple classes/packages
  public void setUpForTest1() {
	  System.out.println("Executing regression test1 ");
  }
  @AfterTest
  public void tearDownForTest1() {
	  System.out.println("End of regression test1 ");
  }
  @BeforeSuite   //suit is collection of multiple test
  public void setUpForSuit1() {
	  System.out.println("Executing new Suite1 ");
  }
  @AfterSuite   //suit is collection of multiple test
  public void tearDownForSuit1() {
	  System.out.println("End of the Suite1 ");
  }
}
