package runner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/feature",
        glue = "steps",
        dryRun = false,
        tags = "@login",
        plugin= {"pretty"}
)
public class TestRunner {

}
