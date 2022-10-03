package com.learning.tutorial.shell.executor;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class ExecutionPoint {

    public static final Logger LOGGER = LoggerFactory.getLogger(ExecutionPoint.class);

    public static final String BASH_PATH = "C:/Program Files/Git/bin/bash.exe";
    public static final String SCRIPT_NAME = "E:/shellscripting/shell-executor-master/shell-executor-master/get_apl";
    public static void main(String[] args) throws IOException {
        LOGGER.info("Execution point started");
        ReadHtmlFile readHtmlFile=new ReadHtmlFile();
        CookieFileMethods cookieFileMethods;
        cookieFileMethods = new CookieFileMethods();
        String containerNumber1="TCNU8808583";
        String containerNumber2="APZU4243564";
        String containerNumber3="TLLU7901413";

//        ScriptExecutor scriptExecutor = new ScriptExecutor();
//        scriptExecutor.executeScript();
//        BashMethods bashMethods=new BashMethods();
//        bashMethods.useGitBash();
//        for(int i=1;i<=2;i++) {
//            System.out.println(i);

        int count=0;

        //Check cookie.testFilePresent or not
      boolean cookieFilePresent=  cookieFileMethods.checkCookieFile();

      if(!cookieFilePresent){
          System.out.println("Cookie File Not Present Creating New One");
          String output = BashNew.runCommand(BASH_PATH, SCRIPT_NAME, "TCNU8808583","APZU4243564","TLLU7901413");

      }
      if (cookieFileMethods.isCookieFileOld()){
          System.out.println("Cookie File is Old");
          //Delete Cookie File
          cookieFileMethods.deleteCookieFile();
          //Create new Cookie file
          String output = BashNew.runCommand(BASH_PATH, SCRIPT_NAME, "TCNU8808583","APZU4243564","TLLU7901413");
          System.out.println("Cookie File Created Successfully");
      }


      //Run Bash File to get Html File
            String output = BashNew.runCommand(BASH_PATH, SCRIPT_NAME, "TCNU8808583","APZU4243564","TLLU7901413");
            System.out.println(output);
//        }

//        JsoupTest.connectWithurl();
//        JsoupTest.connectWithUrl1();

        //Read HTML Data
        String html=readHtmlFile.readHtmlFile();
        readHtmlFile.readHtmlData(html);


        //Delete test.out.html file
//        readHtmlFile.deleteHtmlfile();

    }

}
