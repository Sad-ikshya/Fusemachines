package webScrappingExample;

import java.util.List;
import java.io.IOException;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class NepalStockScrapper {
    final String url="http://www.nepalstock.com/todaysprice";
    Document document;

    public NepalStockScrapper() throws IOException{
        document=Jsoup.connect(url).get();		
    }

    public List<StockData> scrapData(){
        List<StockData> data=new ArrayList<StockData>();

        Elements table = document.getElementsByTag("table");
        Elements dataRow = table.select("tr");

        // Need to remove last four element and first element from table element as it doesn't contian data 
        int lastIndex = dataRow.size()-1;
        dataRow.remove(lastIndex--);
        dataRow.remove(lastIndex--);
        dataRow.remove(lastIndex--);
        dataRow.remove(lastIndex--);
        dataRow.remove(1);
        dataRow.remove(0);
        for(Element row:dataRow) {
            Elements columns=row.select("td");
            Element companyName=columns.get(1);
            String name=companyName.text();
            Element numberOfTransaction=columns.get(2);
            int noOfTransaction=Integer.parseInt(numberOfTransaction.text());
            Element maximumPrice=columns.get(3);
            double maxPrice=Double.parseDouble(maximumPrice.text());
            Element minimumPrice=columns.get(4);
            double minPrice=Double.parseDouble(minimumPrice.text());
            Element closingPrice=columns.get(5);
            double closePrice=Double.parseDouble(closingPrice.text());

            StockData entity=new StockData(name,noOfTransaction,maxPrice,minPrice,closePrice);
            data.add(entity);
        }	

        return data;
        
    }

    
}
