package webScrappingExample;

import java.util.List;
import java.io.IOException;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;


public class ExcelParser {
    HSSFWorkbook workbook;

    public ExcelParser(){      
    }

    public void writeExcel(List<String> list) throws FileNotFoundException, IOException{
        workbook = new HSSFWorkbook();
        HSSFSheet sheet= workbook.createSheet();

        int rowCount = 0;

        for(String element:list){
            Row row = sheet.createRow(++rowCount);
            int columnCount = 0;
            Cell cell =row.createCell(++columnCount);
            cell.setCellValue(element);
        }

        FileOutputStream fileOutputStream = new FileOutputStream("News.xlsx");
        workbook.write(fileOutputStream);
    }

    public void writeStockDataInExcel(List<StockData> list) throws FileNotFoundException, IOException{
        workbook = new HSSFWorkbook();
        HSSFSheet sheet= workbook.createSheet();

        int rowCount = 0;
        Row headingRow=sheet.createRow(++rowCount);
            int headerColumnCount = 0;
            Cell hcell =headingRow.createCell(headerColumnCount++);
            hcell.setCellValue("Company Name");
             Cell hcell1=headingRow.createCell(headerColumnCount++);
            hcell1.setCellValue("No of transaction");
            Cell hcell2=headingRow.createCell(headerColumnCount++);
            hcell2.setCellValue("Maximum Price");
            Cell hcell3=headingRow.createCell(headerColumnCount++);
            hcell3.setCellValue("Minimum Price");
            Cell hcell4=headingRow.createCell(headerColumnCount++);
            hcell4.setCellValue("Closing Price");

        for(StockData stock:list){
            Row row = sheet.createRow(++rowCount);
            int columnCount = 0;
            Cell cell =row.createCell(columnCount++);
            cell.setCellValue(stock.getCompanyName());
             Cell cell1=row.createCell(columnCount++);
            cell1.setCellValue(stock.getNumberOfTransaction());
            Cell cell2=row.createCell(columnCount++);
            cell2.setCellValue(stock.getMaximumPrice());
            Cell cell3=row.createCell(columnCount++);
            cell3.setCellValue(stock.getMinimumPrice());
            Cell cell4=row.createCell(columnCount++);
            cell4.setCellValue(stock.getClosingPrice());
        }

        FileOutputStream fileOutputStream = new FileOutputStream("Stock.xlsx");
        workbook.write(fileOutputStream);
    }
}
