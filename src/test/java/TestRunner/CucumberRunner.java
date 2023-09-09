package TestRunner;


import org.junit.runner.RunWith;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/feature/UIAutomate.feature",glue={"StepDef"},tags="@UIAutomation"
)

public class CucumberRunner {
}
