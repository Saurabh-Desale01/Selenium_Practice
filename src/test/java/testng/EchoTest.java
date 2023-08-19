package testng;

import org.testng.annotations.Test;

import util.WebBrowser;

import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeClass;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;

public class EchoTest {
	WebDriver driver;
	File f;
	FileInputStream fin;
	FileOutputStream fout;
	XSSFWorkbook wkbk;
	XSSFSheet sheet;
	XSSFRow row;
	XSSFCell cell;
	int numrows;
	int numcols;
	int rescol;
	int currow=1;
  @Test(dataProvider = "getLoginDetail")
  public void f(String username, String password) throws IOException {
	  
	  rescol=numcols-1;
	  driver.findElement(By.id("txtCustomerID")).sendKeys(username);
	  driver.findElement(By.id("txtPassword")).sendKeys(password);
	  driver.findElement(By.id("Butsub")).click();
	  if(driver.findElement(By.id("lblMsg")).getText().equals("Invalid Username/Password"))
	  {
		  //Insert result as pass
		  fout=new FileOutputStream(f);
		  row=sheet.getRow(currow);
		  cell=row.getCell(rescol);
		  cell.setCellValue("pass");
		  wkbk.write(fout);
		  currow++;
	  }
   else
	  {
		//insert result as fail  
		  fout=new FileOutputStream(f);
		  row=sheet.getRow(currow);
		  cell=row.getCell(rescol);
		  cell.setCellValue("Fail");
		  wkbk.write(fout);
		  currow++;
	  }
	  assertEquals(driver.findElement(By.id("lblMsg")).getText(), "Invalid Username/Password");
  }

  @DataProvider
  public String [][] getLoginDetail() throws IOException{
	  //data provider method must return double dimensional array
	  //1st dimension=no of times the test is run
	  //2nd dimension=no of parameters the method expect
	  fin=new FileInputStream(f);
	  wkbk=new XSSFWorkbook(fin);
	  sheet=wkbk.getSheet("LoginDetail");
	  numrows=sheet.getPhysicalNumberOfRows();
	  numcols=sheet.getRow(0).getPhysicalNumberOfCells();
	  String [][] data= new String[numrows-1][numcols-1];
	//read data from row 2
	  for(int i=1; i<numrows; i++)
	  {
		  row=sheet.getRow(i);
		  //read data from col 1 and 2
		  for(int j=0; j<numcols-1; j++)
		  {
			  cell=row.getCell(j);
			  data[i-1][j]=cell.getStringCellValue();
		  }
	  }
      return data;
    }
  @AfterMethod 
  public void clearData(){
	  driver.findElement(By.id("txtCustomerID")).clear();;
	  driver.findElement(By.id("txtPassword")).clear();; 
  }
  
  @BeforeClass
  public void beforeClass() { 
	  driver= WebBrowser.openBrowser("https://www.echotrak.com/Login.aspx?ReturnUrl=%2f");
	  f=new File("src/test/resources/EchoLoginData.xlsx");
  }

  @AfterClass
  public void afterClass() {
	  driver.close();
  }

}
