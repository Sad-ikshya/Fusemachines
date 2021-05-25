package webScrappingExample;

import java.io.IOException;

public class WebScrapping {
	public static void main(String[] args) {
		try{

			NepalStockScrapper stockScrapper = new NepalStockScrapper();
			ExcelParser excelParser =new ExcelParser();
			excelParser.writeStockDataInExcel(stockScrapper.scrapData());

			BbcScrapper bbcScrapper=new BbcScrapper();
			excelParser.writeExcel(bbcScrapper.scrapData());
			
		}catch(IOException error){
			System.out.println("Error:"+error.getMessage());
		}
	}

}
