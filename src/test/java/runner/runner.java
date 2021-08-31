package runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/test/resources/features", // se usa para decirle a cucmber dodne estan los features
    glue = "steps",// glue se usa para decirle a cucumbre donde tenemos los steps
    tags= "@Test"
)

public class runner {

}
