package com.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader1 {

	public String path = null;
	public FileInputStream fis = null;
	public FileOutputStream fos = null;
	public XSSFWorkbook workbook = null;
	public XSSFSheet sheet = null;
	public XSSFRow row = null;
	public XSSFCell cell = null;
	public CellStyle style;

	public ExcelReader1(String path) {
		this.path = path;
	}

	public XSSFSheet getsheetName(String sheetName) throws IOException {
		try {
			fis = new FileInputStream(path);
			workbook = new XSSFWorkbook(fis);
			sheet = workbook.getSheet(sheetName);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return sheet;

	}

	public int getTotalRows(String sheetName) throws IOException {
		int totalRows = 0;
		try {
			sheet = getsheetName(sheetName);
			totalRows = sheet.getLastRowNum();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return totalRows;

	}

	public int getNumOfColumns(String sheetName) throws IOException {
		int totalCells = 0;
		try {
			sheet = getsheetName(sheetName);
			totalCells = sheet.getRow(0).getLastCellNum();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return totalCells;
	}

	public String getCellData(String sheetName, int rowNum, int colNum) throws IOException {
		String data = null;
		try {
			sheet = getsheetName(sheetName);
			row = sheet.getRow(rowNum);
			cell = row.getCell(colNum);
			DataFormatter dataformater = new DataFormatter();
			data = "";
			try {
				data = dataformater.formatCellValue(cell);
			} catch (Exception e) {
				data = "";
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return data;

	}

	public List<Map<String, String>> getExcelAsMap(String sheetName) throws IOException {
		List<Map<String, String>> a = null;
		try {
			a = new ArrayList<Map<String, String>>();
			List<String> columnHeaders = new ArrayList<String>();
			sheet = getsheetName(sheetName);
			row = sheet.getRow(0);
			Iterator<Cell> cellIterator = row.cellIterator();
			while (cellIterator.hasNext()) {
				columnHeaders.add(cellIterator.next().getStringCellValue());
			}
			int rowCount = sheet.getLastRowNum();
			int columnCount = row.getLastCellNum();
			for (int i = 1; i <= rowCount; i++) {
				Map<String, String> singleRowData = new HashMap();
				XSSFRow row1 = sheet.getRow(i);
				for (int j = 0; j < columnCount; j++) {
					cell = row1.getCell(j);
					singleRowData.put(columnHeaders.get(j), getCellValueAsString(cell));
				}
				a.add(singleRowData);
			}
			System.out.println(a);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return a;
	}

	public String getCellValueAsString(Cell cell) {
		String cellValue = null;
		try {
			switch (cell.getCellType()) {
			case NUMERIC:
				cellValue = String.valueOf(cell.getNumericCellValue());
				break;
			case STRING:
				cellValue = String.valueOf(cell.getStringCellValue());
				break;
			case BOOLEAN:
				cellValue = String.valueOf(cell.getBooleanCellValue());
				break;
			case FORMULA:
				cellValue = cell.getCellFormula();
				break;
			case BLANK:
				cellValue = "BLANK";
			default:
				cellValue = "DEFAULT";

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cellValue;
	}

	public int getSheetCount() throws IOException {
		int totalSheets = 0;
		try {
			fis = new FileInputStream(path);
			workbook = new XSSFWorkbook(fis);
			totalSheets = workbook.getNumberOfSheets();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(totalSheets);
		return totalSheets;

	}

	public String getSheetNameWithIndex(int index) throws IOException {
		fis = new FileInputStream(path);
		workbook = new XSSFWorkbook(fis);
		String sheetName = workbook.getSheetName(index);
		return sheetName;
	}

	public List<String> headers(String sheetName) throws IOException {
		List<String> headers = null;
		try {
			headers = new ArrayList<String>();
			sheet = getsheetName(sheetName);
			row = sheet.getRow(0);
			Iterator<Cell> cellIterator = row.cellIterator();
			while (cellIterator.hasNext()) {
				String eachHeader = cellIterator.next().getStringCellValue();
				headers.add(eachHeader);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return headers;
	}

	public void setCelldata(String sheetName, int rowNum, int cellNum, String data) throws IOException {
		try {
			fis = new FileInputStream(path);
			workbook = new XSSFWorkbook(fis);
			sheet = workbook.getSheet(sheetName);
			row = sheet.getRow(rowNum);
			cell = row.createCell(cellNum);
			cell.setCellValue(data);
			fos = new FileOutputStream(path);
			workbook.close();
			fis.close();
			fos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void fillGreenColor(String sheetName, int rowNum, int cellNum, String data) throws IOException {
		try {
			fis = new FileInputStream(path);
			workbook = new XSSFWorkbook(fis);
			sheet = workbook.getSheet(sheetName);
			row = sheet.getRow(rowNum);
			cell = row.getCell(cellNum);
			style = workbook.createCellStyle();
			style.setFillForegroundColor(IndexedColors.GREEN.getIndex());
			style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
			cell.setCellStyle(style);
			workbook.write(fos);
			workbook.close();
			fis.close();
			fos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void fillRedColor(String sheetName, int rowNum, int cellNum, String data) throws IOException {
		try {
			fis = new FileInputStream(path);
			workbook = new XSSFWorkbook(fis);
			sheet = workbook.getSheet(sheetName);
			row = sheet.getRow(rowNum);
			cell = row.getCell(cellNum);
			style = workbook.createCellStyle();
			style.setFillForegroundColor(IndexedColors.RED.getIndex());
			style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
			cell.setCellStyle(style);
			workbook.write(fos);
			workbook.close();
			fis.close();
			fos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void setCellData(String sheetName, int rowNum, int cellNum, String data)
			throws InterruptedException, IOException {
		try {
			File xLFile = new File(path);
			if (!xLFile.exists()) {
				workbook = new XSSFWorkbook();

				fos = new FileOutputStream(path);
				workbook.write(fos);
			}
			fis = new FileInputStream(path);
			workbook = new XSSFWorkbook(fis);

			if (workbook.getSheetIndex(sheetName) == -1)
				workbook.createSheet(sheetName);
			sheet = workbook.getSheet(sheetName);

			if (sheet.getRow(rowNum) == null) {
				sheet.createRow(rowNum);
			}
			row = sheet.getRow(rowNum);
			cell = row.createCell(cellNum);
			cell.setCellValue(data);
			fos = new FileOutputStream(path);
			workbook.write(fos);
			workbook.close();
			fis.close();
			fos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
