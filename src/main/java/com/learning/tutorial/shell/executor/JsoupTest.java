package com.learning.tutorial.shell.executor;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

public class JsoupTest {

    public static void connectWithurl() throws IOException {
        Document doc = Jsoup.connect("https://www.apl.com/").userAgent("user-agent: Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/105.0.0.0 Safari/537.36")
                .referrer("https://www.apl.com/ebusiness/tracking")

                .get();
        String title = doc.title();
        System.out.println("title is: " + title);
    }

    public static void connectWithUrl1() throws IOException {
        Document doc=Jsoup.connect("http://www.facebook.com/").userAgent("Chrome").get();

        System.out.println(doc.getElementsByAttribute("user"));
    }
}
