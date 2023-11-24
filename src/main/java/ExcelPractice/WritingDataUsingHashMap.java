package ExcelPractice;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WritingDataUsingHashMap {

	public static void main(String[] args) throws IOException {
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet("data");
		Map<Integer, String> data = new HashMap();
		data.put(101, "joy");
		data.put(102, "swathi");
		data.put(103, "trivani");
		data.put(104, "pavani");
		int totalRows = 0;
		for (Entry<Integer, String> entry : data.entrySet()) {
			XSSFRow row = sheet.createRow(totalRows++);
			int totalColumns=0;	
			row.createCell(totalColumns++).setCellValue((Integer) entry.getKey());
			row.createCell(totalColumns++).setCellValue((String) entry.getValue());
		}
		FileOutputStream fos = new FileOutputStream(".\\ExcelData\\student.xlsx");
		workbook.write(fos);
		workbook.close();
	}
}
