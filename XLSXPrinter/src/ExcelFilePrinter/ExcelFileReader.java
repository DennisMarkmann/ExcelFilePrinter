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
import Exceptions.SearchKeyNotFoundExpception;
import Storage.Entry;
import Storage.Pojo;

public class ExcelFileReader {

    public final void readXLSXFile(final Pojo pojo) throws IOException {
        final InputStream ExcelFileToRead = new FileInputStream(pojo.getPath());
        XSSFWorkbook wb = null;
        try {
            wb = new XSSFWorkbook(ExcelFileToRead);
        } catch (final org.apache.poi.POIXMLException e) {
            new InputErrorExpception("Die Datei konnte nicht eingelesen werden. Bitte wählen Sie eine gültige XLSX-Datei").showDialog();
            new programmRestarter().reStartFull();
            return;
        } catch (final java.util.zip.ZipException e) {
            new SearchKeyNotFoundExpception("SearchKey oder Datum muss gefüllt sein.").showDialog();
            new programmRestarter().reStart(pojo);
            return;
        }

        final XSSFSheet sheet = wb.getSheetAt(0);
        XSSFRow row;
        XSSFCell cell;
        final Iterator<Row> rows = sheet.rowIterator();

        final List<Entry> entryList = new ArrayList<Entry>();
        int rowID = 0;
        Entry entry;
        while (rows.hasNext()) {
            row = (XSSFRow) rows.next();
            int cellID = 0;
            entry = new Entry();
            if (rowID > 0) {
                final Iterator<Cell> cells = row.cellIterator();
                while (cells.hasNext()) {
                    cell = (XSSFCell) cells.next();

                    if (cellID == 0) {
                        if (cell.getCellType() == XSSFCell.CELL_TYPE_STRING) {
                            entry.setId(cell.getStringCellValue());
                        } else if (cell.getCellType() == XSSFCell.CELL_TYPE_BLANK) {
                            entry.setId("");
                        }
                    } else if (cellID == 1) {
                        if (cell.getCellType() == XSSFCell.CELL_TYPE_NUMERIC) {
                            entry.setId(entry.getId()
                                    + (cell.getNumericCellValue() + "").substring(
                                            0,
                                            (cell.getNumericCellValue() + "").indexOf(".")));
                        } else if (cell.getCellType() == XSSFCell.CELL_TYPE_BLANK) {
                            entry.setId("");
                        }
                    } else if (cellID == 2) {
                        if (cell.getCellType() == XSSFCell.CELL_TYPE_NUMERIC) {
                            entry.setCaseNr((cell.getNumericCellValue() + "").substring(
                                    0,
                                    (cell.getNumericCellValue() + "").indexOf(".")));
                        } else if (cell.getCellType() == XSSFCell.CELL_TYPE_STRING) {
                            entry.setCaseNr(cell.getStringCellValue());
                        } else if (cell.getCellType() == XSSFCell.CELL_TYPE_BLANK) {
                            entry.setCaseNr("");
                        }
                    } else if (cellID == 3) {
                        if (cell.getCellType() == XSSFCell.CELL_TYPE_NUMERIC) {
                            entry.setEingelagert(new DateHelper().getDateString(cell.getDateCellValue()));
                        } else if (cell.getCellType() == XSSFCell.CELL_TYPE_STRING) {
                            entry.setEingelagert(cell.getStringCellValue());
                        } else if (cell.getCellType() == XSSFCell.CELL_TYPE_BLANK) {
                            entry.setEingelagert("");
                        }
                    } else if (cellID == 4) {
                        if (cell.getCellType() == XSSFCell.CELL_TYPE_STRING) {
                            entry.setLieferant(cell.getStringCellValue());
                        } else if (cell.getCellType() == XSSFCell.CELL_TYPE_BLANK) {
                            entry.setLieferant("");
                        }

                    } else if (cellID == 5) {
                        if (cell.getCellType() == XSSFCell.CELL_TYPE_NUMERIC) {
                            entry.setKorrespondenzDatum(new DateHelper().getDateString(cell.getDateCellValue()));
                        } else if (cell.getCellType() == XSSFCell.CELL_TYPE_STRING) {
                            entry.setKorrespondenzDatum(cell.getStringCellValue());
                        } else if (cell.getCellType() == XSSFCell.CELL_TYPE_BLANK) {
                            entry.setKorrespondenzDatum("");
                        }
                    } else if (cellID == 6) {
                        if (cell.getCellType() == XSSFCell.CELL_TYPE_STRING) {
                            entry.setArbeitsTitel(cell.getStringCellValue());
                        } else if (cell.getCellType() == XSSFCell.CELL_TYPE_BLANK) {
                            entry.setArbeitsTitel("");
                        }
                    } else if (cellID == 7) {
                        if (cell.getCellType() == XSSFCell.CELL_TYPE_STRING) {
                            entry.setBemerkung(cell.getStringCellValue());
                        } else if (cell.getCellType() == XSSFCell.CELL_TYPE_BLANK) {
                            entry.setBemerkung("");
                        }
                    } else if (cellID == 8) {
                        if (cell.getCellType() == XSSFCell.CELL_TYPE_STRING) {
                            entry.setBearbeiter(cell.getStringCellValue());
                        } else if (cell.getCellType() == XSSFCell.CELL_TYPE_BLANK) {
                            entry.setBearbeiter("");
                        }
                    }
                    cellID++;
                }
                entryList.add(entry);
            }
            rowID++;
        }
        pojo.setEntryList(entryList);
        new ContentFilter().filterContent(pojo);

    }
}
