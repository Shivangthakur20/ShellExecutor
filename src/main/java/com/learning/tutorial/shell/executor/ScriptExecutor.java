package com.learning.tutorial.shell.executor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ScriptExecutor {

    public static final Logger LOGGER = LoggerFactory.getLogger(ScriptExecutor.class);

    public void executeScript() {
        try {
//            Process process = Runtime.getRuntime().exec("script.bat");
            Process process = Runtime.getRuntime().exec("E:\\shellscripting\\shell-executor-master\\shell-executor-master\\src\\main\\resources\\apl");
            int exitStatus = process.waitFor();

            String line;
            LOGGER.info("***** Script execution Starts *****");
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            while ((line = bufferedReader.readLine()) != null) {
                LOGGER.info(line);
            }
            if (exitStatus != 0) {
                bufferedReader = new BufferedReader(new InputStreamReader(process.getErrorStream()));
                while ((line = bufferedReader.readLine()) != null) {
                    LOGGER.error(line);
                }
                throw new IllegalStateException("Script exited abnormally");
            }
            LOGGER.info("***** Script executed successfully *****");

        } catch (InterruptedException | IOException e) {
            LOGGER.error("Error during script.bat execution", e);
        }
    }

}
