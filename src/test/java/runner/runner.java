package runner;

import org.junit.AfterClass;
import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import pages.BasePage;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/test/resources/features", // se usa para decirle a cucmber dodne estan los features
    glue = "steps",// glue se usa para decirle a cucumbre donde tenemos los steps
    monochrome = true, // funcion para que sirve para mejorar y esclarecer la salida de los mensajes por la terminal
    tags= "@Test"// el tag sirve para decirle a cucumber que esenarios ejecutar
)

public class runner {
    @AfterClass
    public static void cleanDriver(){
        BasePage.closeBrowser();
    }

}
