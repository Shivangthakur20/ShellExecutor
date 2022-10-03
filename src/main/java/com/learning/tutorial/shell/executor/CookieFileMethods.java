package com.learning.tutorial.shell.executor;

import java.io.File;

public class CookieFileMethods {

    public boolean checkCookieFile() {
        File file=new File("./aplCookie.test");

        if (file.exists()){
            return true;
        }else return false;
    }

    public boolean isCookieFileOld(){

        String filePath = "./aplCookie.test";
        DateFg dateFg=new DateFg();



        String fileDateHour=dateFg.getCookieFileDateTime(filePath);
        String utcDateHour=dateFg.getSystemCurrentUtcTime();


        if (dateFg.getDate(fileDateHour).equals(dateFg.getHour(fileDateHour)) && dateFg.getDate(utcDateHour).equals(dateFg.getHour(utcDateHour))){
            System.out.println("Date Matched");
            return false;
        }else {
            System.out.println("Date not Matched");
        }
        return true;
    }

    public void deleteCookieFile(){
        String cookieFilePath="./aplCookie.test";

        File file=new File(cookieFilePath);
        System.out.println("Cookie File Deleted");
        file.delete();
    }
}
