package ExcelPractice;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.poi.util.SystemOutLogger;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.utility.ExcelReader1;

public class Excel {

	public static void main(String[] args) throws IOException {

		String filepath = ".\\ExcelData\\a.xlsx";

		FileInputStream fileInput = new FileInputStream(filepath);
		XSSFWorkbook workbook = new XSSFWorkbook(fileInput);
		XSSFSheet sheet = workbook.getSheet("data");
		int totalRows = sheet.getLastRowNum();
		int totalColumns = sheet.getRow(0).getLastCellNum();
		for (int i = 0; i <= totalRows; i++) {
			XSSFRow eachRow = sheet.getRow(i);

			for (int j = 0; j < totalColumns; j++) {
				XSSFCell cell = eachRow.getCell(j);
				switch (cell.getCellType()) {
				case STRING:
					cell.getStringCellValue();
					break;
				case NUMERIC:
					cell.getNumericCellValue();
					break;
				case BOOLEAN:
					cell.getBooleanCellValue();
					break;
				}
				//System.out.print("|");

			}
//			System.out.println();
	//	ExcelReader1 ExcelReader1 = new ExcelReader1(filepath);
//			int totalRows1 = ExcelReader1.getTotalRows("data");
//			System.out.println(totalRows1);
//			String data1 = ExcelReader1.getCellData("data", 1, 1);
//			System.out.println(data1);
		//	ExcelReader1.getExcelAsMap("data");

		}
		ExcelReader1 ExcelReader1 = new ExcelReader1(filepath);
	List<Map<String, String>> ex = ExcelReader1.getExcelAsMap("data");
	List<String> a = ExcelReader1.headers("data");
	System.out.println(a);
	ExcelReader1.getSheetCount();
	



	}

}
