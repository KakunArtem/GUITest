package runner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import utils.BrowserDriver;

@RunWith(Cucumber.class)

@CucumberOptions(
        plugin = {"pretty"},
        features = {"src/test/resources"})

public class RunEndToEndTest extends BrowserDriver {

    @BeforeClass
    public static void setUp() {
        BrowserDriver.browserSetUp();
    }

    @AfterClass
    public static void tearDown() {
        BrowserDriver.close();
    }
}
