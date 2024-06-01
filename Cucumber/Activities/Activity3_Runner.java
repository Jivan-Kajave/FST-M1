package testRunner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/Features",
        glue = {"stepDefinitions"},
        //tags = "@SmokeTest",
        //tags = "@ConfirmAlert",
        //tags = "@PromptAlert",
        tags = "@activity3",
        publish = true
)

public class Activity3_Runner {

}

