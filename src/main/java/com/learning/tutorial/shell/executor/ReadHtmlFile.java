package com.learning.tutorial.shell.executor;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadHtmlFile {
    public String readHtmlFile() throws FileNotFoundException {
         /* Constructing String Builder to
        append the string into the html */
        StringBuilder html = new StringBuilder();

        // Reading html file on local directory
        FileReader fr = new FileReader(
                "./aplTest.out.html");

        // Try block to check exceptions
        try {

            // Initialization of the buffered Reader to get
            // the String append to the String Builder
            BufferedReader br = new BufferedReader(fr);

            String val;

            // Reading the String till we get the null
            // string and appending to the string
            while ((val = br.readLine()) != null) {
                html.append(val);
            }

            // AtLast converting into the string
            String result = html.toString();
//            System.out.println(result);

            // Closing the file after all the completion of
            // Extracting
            br.close();
            return result;
        }

        // Catch block to handle exceptions
        catch (Exception ex) {

            /* Exception of not finding the location and
            string reading termination the function
            br.close(); */
            System.out.println(ex.getMessage());
        }

        return null;
    }

    public void deleteHtmlfile() {
        String htmlFilePath="./aplTest.out.html";

        File file=new File(htmlFilePath);
        file.delete();
    }

    public void readHtmlData(String htmlData){
        List<String> htmldataList=new ArrayList<>();

        Document doc= Jsoup.parse(htmlData);
        String tag= String.valueOf(doc.getElementsByTag("span"));
//        System.out.println(tag);

        //get total lists
        Elements lists=doc.getElementsByTag("li");
        System.out.println("toal list tags== "+lists.size());

        Elements elements= doc.select("span");
        for (Element s:elements) {

            s.text();

//            System.out.println(s.select("span").first());
//            System.out.println(">>>>>"+s.text());

        }
        //list iterating
        for (Element s:lists) {

//          System.out.println("Child node size =="+s.text());
//          System.out.println("Child node size =="+s.text());
            Elements listNodes=s.children();
            for (Element p:listNodes) {
//                System.out.println("Child node size =="+p.text());
                htmldataList.add(p.text());

            }

        }
        for(int i=0;i< htmldataList.size();i++){
            System.out.println("List data Is>>"+htmldataList.get(i) );

        }
    }

}
