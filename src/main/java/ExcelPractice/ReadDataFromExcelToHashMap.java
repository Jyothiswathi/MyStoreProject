package ExcelPractice;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadDataFromExcelToHashMap {

	public static void main(String[] args) throws IOException {
		FileInputStream fis = new FileInputStream("D:\\seleniumjenkins\\ExcelData\\student.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheet("data");
		int totalRows = sheet.getLastRowNum();
		//int totalColumns = sheet.getRow(0).getLastCellNum();
		Map<Integer, String> data = new HashMap();
		for (int i = 0; i < totalRows; i++) {
			int columns=0;
			int key = (int) sheet.getRow(i).getCell(columns++).getNumericCellValue();
			String value = sheet.getRow(i).getCell(columns++).getStringCellValue();
			data.put(key, value);
		}
		for (Entry<Integer, String> entry : data.entrySet()) {
			System.out.println(entry.getKey() + " " + entry.getValue());
		}

	}

}
