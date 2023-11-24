package TestNg;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Practice1 {

	public static void main(String[] args) throws IOException {
		
String filePath="D:\\MyStoreProject\\ExcelData\\student.xlsx";
FileInputStream fis=new FileInputStream(filePath);
XSSFWorkbook workbook=new XSSFWorkbook(fis);
XSSFSheet sheet = workbook.getSheet("data");
int totalRows = sheet.getLastRowNum();
int totalColiumns=sheet.getRow(0).getLastCellNum();
for(int i=0;i<=totalRows;i++)
{
	XSSFRow row = sheet.getRow(i);
	for(int j=0;j<totalColiumns;j++)
	{
		XSSFCell cell = row.getCell(j);
	switch(cell.getCellType())
	{
	case STRING: System.out.println(cell.getStringCellValue()) ;break;
	case NUMERIC: System.out.println(cell.getNumericCellValue()) ;break;
	case BOOLEAN: System.out.println(cell.getBooleanCellValue()) ;break;


	}
	System.out.print("|");
	
		
		
	}
	System.out.println("");
	
	
}





	}

}
