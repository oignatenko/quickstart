package com.quickstart.application;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.logging.*;
import org.junit.Test;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/** */
public class ApplicationTest {
    /** */
    private static final Logger LOG = Logger.getLogger(ApplicationTest.class.getName());

    /** */
    private static final String PROPS_FILE_NAME = "app.test.properties";

    /** */
    @Test
    public void testNullProperties() throws Exception {
        LOG.info("test null properties");

        new Application(null).launch();
    }

    /** */
    @Test
    public void testLoadProperties() throws Exception {
        LOG.info("test small properties");

        final Properties props = properties(PROPS_FILE_NAME);

        LOG.log(Level.INFO, "properties: [{0}]", props);

        final String key = "message";

        assertTrue("properties should contain key [" + key + "]", props.containsKey(key));

        final String exp = "Test Hello World";

        assertEquals(exp, props.getProperty(key));
    }

    /** */
    @Test
    public void testBasicUsage() throws Exception {
        LOG.info("test basic usage");

        new Application(properties(PROPS_FILE_NAME)).launch();
    }

    /** */
    private Properties properties(String fileName) throws IOException {
        final InputStream in = inputStream(fileName);

        assertNotNull("can't open input file [" + fileName + "]", in);

        final Properties props = new Properties();

        props.load(in);

        in.close();

        return props;
    }

    /** */
    private InputStream inputStream(String fileName) {
        return ApplicationTest.class.getClassLoader().getResourceAsStream(fileName);
    }
}
