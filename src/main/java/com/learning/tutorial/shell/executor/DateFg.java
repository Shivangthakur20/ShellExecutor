package com.learning.tutorial.shell.executor;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.time.Instant;

public class DateFg {

    public String getCookieFileDateTime(String filePath){
        try{
            Path file = Paths.get(filePath);

            BasicFileAttributes attr =
                    Files.readAttributes(file, BasicFileAttributes.class);

            return String.valueOf(attr.creationTime());
        }catch (IOException e){
            e.printStackTrace();
        }


        return filePath;
    }

    public String getSystemCurrentUtcTime(){
        Instant instant = Instant.now();
        return instant.toString();
    }

    public String getDate(String date){
        return date.substring(0,date.indexOf("T")).trim();
    }

    public  String getHour(String date){
        return date.substring(0,date.indexOf("T")).trim();
    }
}
