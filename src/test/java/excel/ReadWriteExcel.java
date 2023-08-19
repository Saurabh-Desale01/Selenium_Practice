package excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadWriteExcel {

	public static void writeToExcel(File f, String name) throws IOException
	{
		FileOutputStream fout=new FileOutputStream(f);
		XSSFWorkbook wkbk= new XSSFWorkbook();
		XSSFSheet sheet=wkbk.createSheet(name);
		for(int i=0;i<3;i++)
		{
			XSSFRow rows=sheet.createRow(i);
			for(int j=0;j<2;j++)
			{
				XSSFCell cell=rows.createCell(j);
				cell.setCellValue("user" +i+j);
			}
		}
		wkbk.write(fout);
		wkbk.close();
		fout.close();
		
	}
	public static void readExcel(File f, String name) throws IOException
	{
		FileInputStream fin=new FileInputStream(f);
		XSSFWorkbook wkbk=new XSSFWorkbook(fin);
		XSSFSheet sheet=wkbk.getSheet(name);
		for(Row row:sheet)//each row in sheet
		{
			for(Cell cel:row)//each cell in the row
			{
				//System.out.println(cell.getStringCellValue());
				getCellTypeData(cel);
			}	
		}
		wkbk.close();
		fin.close();
		
	}
	public static void getCellTypeData (Cell cell)
	{
		  CellType type=cell.getCellType();
		  switch(type)
		  {
		  case NUMERIC:
			  System.out.println(cell.getNumericCellValue());
			  break;
		  case STRING:
			  System.out.println(cell.getStringCellValue());
			  break;
		  case BOOLEAN:
			  System.out.println(cell.getBooleanCellValue());
			  break;
		  case ERROR:
			  System.out.println(cell.getCellFormula());
			  break;
		  case FORMULA:
			  System.out.println(cell.getNumericCellValue());
			  break;
		  case BLANK:
			  System.out.println("cell is blank");
			  break;
		default:
			break;
		
		  }
	}
	
	
	public static void main(String[] args)throws IOException {
		// TODO Auto-generated method stub

		File f=new File("src/test/resources/demo.xlsx");
		//writeToExcel(f,"data");
		System.out.println("Done");
		readExcel(f,"data");

	}

}
