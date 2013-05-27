package ExcelFilePrinter;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import Exceptions.InputErrorExpception;

public class ExcelFileReader {

    public void readXLSXFile(final Pojo pojo) throws IOException {
        final InputStream ExcelFileToRead = new FileInputStream(pojo.getPath());
        XSSFWorkbook wb = null;
        try {
            wb = new XSSFWorkbook(ExcelFileToRead);
        } catch (final org.apache.poi.POIXMLException e) {
            new InputErrorExpception("Die Datei konnte nicht eingelesen werden. Bitte wählen Sie eine gültige XLSX-Datei").showDialog();
            return;
        }

        final XSSFSheet sheet = wb.getSheetAt(0);
        XSSFRow row;
        XSSFCell cell;
        final Iterator<Row> rows = sheet.rowIterator();

        final List<String> contentList = new ArrayList<String>();
        StringBuilder content;
        while (rows.hasNext()) {
            content = new StringBuilder();
            row = (XSSFRow) rows.next();
            final Iterator<Cell> cells = row.cellIterator();
            while (cells.hasNext()) {
                cell = (XSSFCell) cells.next();
                if (cell.getCellType() == XSSFCell.CELL_TYPE_STRING) {
                    content.append(cell.getStringCellValue()).append(" ");
                } else if (cell.getCellType() == XSSFCell.CELL_TYPE_NUMERIC) {
                    content.append(cell.getNumericCellValue()).append(" ");
                } else {
                    // U Can Handel Boolean, Formula, Errors
                }
            }
            contentList.add(content.toString());
        }
        pojo.setContentList(contentList);
        new ContentFilter().filterContent(pojo);

    }
}
// public void readXLSFile(Pojo pojo) throws IOException {
// InputStream ExcelFileToRead = new FileInputStream(pojo.getPath());
// HSSFWorkbook wb = new HSSFWorkbook(ExcelFileToRead);
//
// HSSFSheet sheet = wb.getSheetAt(0);
// HSSFRow row;
// HSSFCell cell;
//
// Iterator rows = sheet.rowIterator();
//
// while (rows.hasNext()) {
// row = (HSSFRow) rows.next();
// Iterator cells = row.cellIterator();
// while (cells.hasNext()) {
// cell = (HSSFCell) cells.next();
// if (cell.getCellType() == HSSFCell.CELL_TYPE_STRING) {
// System.out.print(cell.getStringCellValue() + " ");
// } else if (cell.getCellType() == HSSFCell.CELL_TYPE_NUMERIC) {
// System.out.print(cell.getNumericCellValue() + " ");
// } else {
// // U Can Handel Boolean, Formula, Errors
// }
// }
// System.out.println();
// }
// }
//
// public void writeXLSFile(Pojo pojo) throws IOException {
// String excelFileName = pojo.getPath();// name of excel file
//
// String sheetName = "Sheet1";// name of sheet
//
// HSSFWorkbook wb = new HSSFWorkbook();
// HSSFSheet sheet = wb.createSheet(sheetName);
//
// // iterating r number of rows
// for (int r = 0; r < 5; r++) {
// HSSFRow row = sheet.createRow(r);
// // iterating c number of columns
// for (int c = 0; c < 5; c++) {
// HSSFCell cell = row.createCell(c);
// cell.setCellValue("Cell " + r + " " + c);
// }
// }
// FileOutputStream fileOut = new FileOutputStream(excelFileName);
// // write this workbook to an Outputstream.
// wb.write(fileOut);
// fileOut.flush();
// fileOut.close();
// }
// public void writeXLSXFile(Pojo pojo) throws IOException {
// String excelFileName = pojo.getPath()// name of excel file
//
// String sheetName = "Sheet1";// name of sheet
//
// XSSFWorkbook wb = new XSSFWorkbook();
// XSSFSheet sheet = wb.createSheet(sheetName);
//
// // iterating r number of rows
// for (int r = 0; r < 5; r++) {
// XSSFRow row = sheet.createRow(r);
//
// // iterating c number of columns
// for (int c = 0; c < 5; c++) {
// XSSFCell cell = row.createCell(c);
// cell.setCellValue("Cell " + r + " " + c);
// }
// }
//
// FileOutputStream fileOut = new FileOutputStream(excelFileName);
//
// // write this workbook to an Outputstream.
// wb.write(fileOut);
// fileOut.flush();
// fileOut.close();
// }
//
// }