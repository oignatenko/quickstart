package com.quickstart.application;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.logging.*;

public class Main {
    private static final Logger LOG = Logger.getLogger(Application.class.getName());    

    public static void main(String[] args) throws Exception {
        LOG.info("checking command line arguments");
        if (args.length != 1) {
            usage(args);
            return;
        }
        final String fileName = args[0];
        LOG.log(Level.INFO, "opening properties file: [{0}]", fileName);
        final Properties properties = new Properties();
        final FileInputStream in = new FileInputStream(fileName);
        properties.load(in);
        in.close();
        new Application(properties).launch();
    }
    
    private static void usage(String[] args) {
        System.out.println("java -cp <jar name> com.quickstart.application.Main <input file name>");
    }
}
