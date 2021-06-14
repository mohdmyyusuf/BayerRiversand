package com.bayer.qa.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XlsReader {

	public void excelFileReader(String filePath, String fileName) throws IOException {
		String fileExtensionName = fileName.substring(fileName.indexOf("."));
		System.out.println(fileExtensionName);
		if (fileExtensionName.equals(".xls")) {
			FileInputStream fis = new FileInputStream(new File(filePath + "\\" + fileName));
			HSSFWorkbook wb = new HSSFWorkbook(fis);
			HSSFSheet sheet = wb.getSheetAt(0);
			FormulaEvaluator formulaEvaluator = wb.getCreationHelper().createFormulaEvaluator();
			for (Row row : sheet) {
				for (Cell cell : row) {
					switch (formulaEvaluator.evaluateInCell(cell).getCellType()) {
					case NUMERIC:
						System.out.print(cell.getNumericCellValue() + "\t\t");
						break;
					case STRING:
						System.out.print(cell.getStringCellValue() + "\t\t");
						break;
					}

				}
				System.out.println();
			}
		}
		if (fileExtensionName.equals(".xlsx")) {
			try {
				File file = new File(filePath + "\\" + fileName);
				FileInputStream fis = new FileInputStream(file);

				XSSFWorkbook wb = new XSSFWorkbook(fis);
				XSSFSheet sheet = wb.getSheetAt(0);
				Iterator<Row> itr = sheet.iterator();
				while (itr.hasNext()) {
					Row row = itr.next();
					Iterator<Cell> cellIterator = row.cellIterator(); // iterating over each column
					while (cellIterator.hasNext()) {
						Cell cell = cellIterator.next();
						switch (cell.getCellType()) {
						case STRING:
							System.out.print(cell.getStringCellValue() + "\t\t\t");
							break;
						case NUMERIC:
							System.out.print(cell.getNumericCellValue() + "\t\t\t");
							break;
						default:

						}
					}
					System.out.println("--");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}
	
	public XSSFSheet returnExcel(String Path, String SheetName) throws IOException {
		 //Workbook wb = WorkbookFactory.create(new File(xlFileAddress));

		XSSFSheet ExcelWSheet;
		XSSFCell cell;
		XSSFWorkbook ExcelWBook;
		System.out.println(Path);
		// Open the Excel file
		FileInputStream ExcelFile = new FileInputStream(Path);
		// Access the required test data sheet
		ExcelWBook = new XSSFWorkbook(ExcelFile);
		ExcelWSheet = ExcelWBook.getSheet(SheetName);
		// } catch (Exception e) {
		// System.out.println(e);
		// }
		return ExcelWSheet;
	}

}
