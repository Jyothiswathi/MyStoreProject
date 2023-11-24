package ExcelPractice;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelWriterUsingForEach {

	public static void main(String[] args) throws IOException {
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet("data");
		// Object[][] info = { { "e.id", "e.Name" }, { 1, "jyo" }, { 2, "swathi" } };

		List<Object[]> info = new ArrayList<Object[]>();
		info.add(new Object[] { "o.id", "o.Name" });
		info.add(new Object[] { 1, "Jyo" });
		info.add(new Object[] { 2, "joy" });
		int totalRows = 0;
		for (Object emp[] : info) {
			XSSFRow row = sheet.createRow(totalRows++);
			int totalColumns = 0;
			for (Object value : emp) {
				XSSFCell cell = row.createCell(totalColumns++);
				if (value instanceof String)
					cell.setCellValue((String) value);
				if (value instanceof Integer)
					cell.setCellValue((Integer) value);
				if (value instanceof Boolean)
					cell.setCellValue((Boolean) value);
			}
		}
		String filepath = "D:\\seleniumjenkins\\ExcelData\\a.xlsx";
		FileOutputStream fos = new FileOutputStream(filepath);
		workbook.write(fos);
		workbook.close();

	}

}
