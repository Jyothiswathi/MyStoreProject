package TestNg;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Practice {

	public static void main(String[] args) throws IOException {
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet("data");
		Map<String, String> info = new HashMap();
		info.put("1", "Hello");
		info.put("2", "Hai");
		int Totalrows = 0;
		for (Entry<String, String> eachSet : info.entrySet()) {
			XSSFRow row = sheet.createRow(Totalrows++);
			int column = 0;
			row.createCell(column++).setCellValue(eachSet.getKey());
			row.createCell(column++).setCellValue(eachSet.getValue());

		}
		FileOutputStream fos = new FileOutputStream("D:\\MyStoreProject\\ExcelData\\student.xlsx");
		workbook.write(fos);
		workbook.close();
		fos.close();

	}

}
