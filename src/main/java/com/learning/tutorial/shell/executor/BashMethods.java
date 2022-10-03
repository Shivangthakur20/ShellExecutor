package com.learning.tutorial.shell.executor;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class BashMethods {


    public void useGitBash(){
        boolean isWindows=System.getProperty("os.name").toLowerCase().startsWith("windows");
       ProcessBuilder processBuilder=new ProcessBuilder();

        if (isWindows){
            processBuilder.command(System.getProperty("user.dir") + "src\\main\\resources\\script.bat");
        }
        ExecutorService pool= Executors.newSingleThreadExecutor();
        try{
            Process process= processBuilder.start();
            ProcessReader task=new ProcessReader(process.getInputStream());
            Future<List<String>> future =pool.submit(task);
            List<String> results=future.get();
            for (String res : results){
                System.out.println(res);
            }
            int exitCode= process.waitFor();
            System.out.println("Exit Code: "+exitCode);
        }catch (IOException e){
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }finally {
            pool.shutdown();
        }
    }
}
