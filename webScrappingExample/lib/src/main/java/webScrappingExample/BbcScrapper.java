package webScrappingExample;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class BbcScrapper {
    final String url="https://www.bbc.com";
    Document document;

     

      public BbcScrapper() throws IOException{
        document=Jsoup.connect(url).get();
      
       
      }

      public List<String> scrapData(){

        List<String> list=new ArrayList<String>();
        Elements elements=document.getElementsByClass("media");
			
			Elements mediaLinkElement=elements.toggleClass("media__link");
			
			for(Element elementList:mediaLinkElement) {
                list.add(elementList.text());
					//System.out.println(elementList.text());
			}
            return list;
      }
     
}
