package com.quickstart.testsuites;

import com.quickstart.application.ApplicationTest;
import com.quickstart.application.MainTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;

/**
 * IMPL NOTE add wildcard to suite class name when running under surefire: {@code mvn -Dtest=SuiteExample* test}.
 * If needed, see <a href="https://github.com/junit-team/junit5/issues/1343#issuecomment-384359219">here</a>
 * for more details.
 */
class SuiteExample {
    /** */
    @Nested
    @DisplayName("ApplicationTest")
    class ApplicationTest1 extends ApplicationTest {}

    /** */
    @Nested
    @DisplayName("MainTest")
    class MainTest1 extends MainTest {}
}
