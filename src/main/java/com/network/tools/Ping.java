package com.network.tools;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;

public class Ping {

    // method for finding the ping statics of website
    static void commands(ArrayList<String> commandList)
            throws Exception
    {
        // creating the sub process, execute system command
        ProcessBuilder build = new ProcessBuilder(commandList);
        Process process = build.start();

        // to read the output
        BufferedReader input = new BufferedReader(new InputStreamReader
                (process.getInputStream()));
        BufferedReader Error = new BufferedReader(new InputStreamReader
                (process.getErrorStream()));
        String s = null;

        System.out.println("Standard output: ");
        int i=0;
        while((s = input.readLine()) != null)
        {
            System.out.println("a b c d "+s);

            if(i>=10) {
                //process.destroy();
                //System.exit(0);
            }
            i++;
        }
        System.out.println("error (if any): ");
        while((s = Error.readLine()) != null)
        {
            System.out.println(s);
        }

    }

    // Driver method
    public static void main(String args[]) throws Exception
    {
        // creating list for commands
        ArrayList<String> commandList = new ArrayList<String>();

        commandList.add("ping");
        // can be replaced by IP
        commandList.add("www.google.com");

        Ping.commands(commandList);
    }
}
