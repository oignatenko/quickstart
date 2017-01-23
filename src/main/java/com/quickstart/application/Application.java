package com.quickstart.application;

import java.util.Properties;
import java.util.logging.*;

class Application {
    private static final Logger LOG = Logger.getLogger(Application.class.getName());
    private final Properties properties;

    Application(Properties properties) {
        this.properties = properties;
    }
    
    void launch() {
        final String key = "message";
        LOG.log(Level.INFO, "start application");
        if (properties == null) {
            LOG.severe("properties are null");
            return;
        }
        if (!properties.containsKey(key)) {
            LOG.severe("no properties for key [" + key + "]");
            return;
        }
        LOG.log(Level.INFO, key + ": [{0}]", properties.getProperty(key));
        LOG.info("application completed");
    }
}
