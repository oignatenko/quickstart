package com.quickstart.application;

import org.junit.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

/** */
public class MainTest {
    /** */
    private static final String[] ARGS = {"src/test/resources/app.properties"};

    /** */
    @Test
    public void testBasic() throws IOException {
        final String testKey = "message";

        assertNull(new Main(null, null).configure());

        assertNull(new Main(null, null).configure(testKey));

        assertNull(new Main(MainTest.class, null).configure(testKey));

        assertNull(new Main(null, new String[] {}).configure(testKey));

        assertNull(new Main(null, new String[] {"src/test/resources/app.test.properties"})
                .configure(testKey));

        assertNull(new Main(MainTest.class, new String[] {"src/test/resources/app.test.properties"})
                .configure((String)null));

        assertNotNull(new Main(MainTest.class, new String[] {"src/test/resources/app.test.properties"})
                .configure((String[])null));

        assertNotNull(new Main(MainTest.class, new String[] {"src/test/resources/app.test.properties"}).configure());

        assertNull(new Main(MainTest.class, new String[] {"src/test/resources/app.test.properties"})
                .configure("broken." + testKey));

        assertEquals("Test Hello World",
                new Main(MainTest.class, new String[] {"src/test/resources/app.test.properties"})
                        .configure(testKey).getProperty(testKey),"test property by key [" + testKey + "]");
    }

    /** IMPL NOTE this allows conveniently launch {@link Application} without messing with IDE settings. */
    @Test
    public void testMain() throws IOException {
        Main.main(ARGS);
    }
}
