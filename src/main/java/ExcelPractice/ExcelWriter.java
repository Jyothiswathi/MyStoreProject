package ExcelPractice;

import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelWriter {

	public static void main(String[] args) throws IOException {
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet("write data");
		Object[][] data = { { "s.no", "s.Name" }, { 1, "Hello" }, { 2, "hai" } };

		// using the loop
		int totalRoews = data.length;// 3
		int totalColumns = data[0].length;// 2

		for (int i = 0; i < totalRoews; i++) {
			XSSFRow row = sheet.createRow(i);
			for (int j = 0; j < totalColumns; j++) {
				XSSFCell cell = row.createCell(j);
				Object value = data[i][j];
				if (value instanceof String)
					cell.setCellValue((String) value);
				if (value instanceof Integer)
					cell.setCellValue((Integer) value);
				if (value instanceof Boolean)
					cell.setCellValue((Boolean) value);

			}

		}
		String filePath="D:\\seleniumjenkins\\ExcelData\\a.xlsx";
		FileOutputStream fos=new FileOutputStream(filePath);
		workbook.write(fos);
		workbook.close();

	}

}
