package com.learning.tutorial.shell.executor;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringJoiner;

public class BashNew {





    public static String runCommand(String... params)
    {
        ProcessBuilder pb = new ProcessBuilder(params);
        Process p;
        StringJoiner joiner = new StringJoiner(System.getProperty("line.separator"));
        try
        {
            p = pb.start();

            final BufferedReader reader = new BufferedReader(
                    new InputStreamReader(p.getInputStream()));

            reader.lines().iterator().forEachRemaining(joiner::add);

//            p.waitFor();
            p.destroy();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        return joiner.toString();
    }
}
