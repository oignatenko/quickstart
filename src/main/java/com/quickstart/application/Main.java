package com.quickstart.application;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.*;

/** Common reader of args and properties. */
public class Main {
    /** */
    private static final Logger LOG = Logger.getLogger(Main.class.getName());

    /** */
    private final Class clazz;

    /** */
    private final String[] args;

    /** */
    public Main(Class clazz, String[] args) {
        this.clazz = clazz;

        this.args = args;
    }

    /** */
    public static void main(String[] args) throws IOException {
        final Properties props = new Main(Main.class, args).configure("message");

        if (props == null)
            return; // IMPL NOTE error found and reported

        new Application(props).launch();
    }

    /** */
    Properties configure(String... propsToVerify) throws IOException {
        LOG.info("checking command line arguments");

        if (clazz == null || args == null || args.length != 1) {
            usage();

            return null;
        }

        final String fileName = args[0];

        LOG.log(Level.INFO, "reading properties file: [{0}]", fileName);

        final Properties props = new Properties();

        try (final FileInputStream in = new FileInputStream(fileName)) {
            props.load(in);

            return verify(props, propsToVerify);
        }
    }

    /**
     * IMPL NOTE keysToVerify empty or null assume that client wants properties without verifying
     */
    private Properties verify(Properties props, String... keysToVerify) {
        if (props == null)  {
            LOG.severe("properties are null");

            return null;
        }

        if (keysToVerify == null || keysToVerify.length == 0)  {
            LOG.info("no property keys to verify");

            return props;
        }

        for (String propToVerify : keysToVerify)
            if (!verify(props, propToVerify))
                return null;

        return props;
    }

    /** */
    private boolean verify(Properties props, String key) {
        if (key == null)  { // IMPL NOTE non-null props are checked at caller
            LOG.log(Level.SEVERE, "property key is null");

            return false;
        }

        if (!props.containsKey(key))  {
            LOG.log(Level.SEVERE, "mandatory property is not defined: [{0}]", key);

            return false;
        }

        LOG.log(Level.INFO, "property key [{0}] value [{1}]", new String[] {key, props.getProperty(key)});

        return true;
    }

    /** */
    private void usage() {
        LOG.log(Level.WARNING, "usage java -cp <jar name> [{0}] <properties file name>",
                (clazz == null ? "<class name>" : clazz.getName()));
    }
}
