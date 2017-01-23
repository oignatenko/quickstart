package com.quickstart.application;

import java.util.Properties;
import java.util.logging.*;

/** */
class Application {
    /** */
    private static final Logger LOG = Logger.getLogger(Application.class.getName());

    /** */
    private final Properties props;

    /** Getting config into properties is expected to be done outside, for example as in {@link Main#main(String[])} */
    Application(Properties props) {
        this.props = props;
    }

    /** */
    void launch() {
        final String key = "message";

        LOG.log(Level.INFO, "start application");

        if (props == null) {
            LOG.severe("properties are null");

            return;
        }

        if (!props.containsKey(key)) {
            LOG.severe("no properties for key [" + key + "]");

            return;
        }

        LOG.log(Level.INFO, key + ": [{0}]", props.getProperty(key));

        LOG.info("application completed");
    }
}
