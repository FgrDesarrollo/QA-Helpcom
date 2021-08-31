package steps;

import org.junit.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.GooglePage;

public class GoogleSteps {

    /*En el comentario del Given , se recomienda usar los simbolos ^ $ al principio y al final respectivamente para decirle a cucumber que esto es un test
    / tambien sirve para evitar que cucumber se pierda con definicion de clases que comiencen con nombres similares*/
    
    GooglePage google = new GooglePage();

    
    
    @Given("^navego en google$")
    public void navigateToGoogle(){
        google.navigateToGoogle();

    } 
    @When("^busco algo$")
    public void buscoAlgo(){
        google.enterSearchCriteria("Pronostico del tiempo en temuco");

    } 
    @And("^presiono el boton buscar$")
    public void presionoBoton(){
        google.clickGoogleSearh();

    } 
    @Then("^Obtengo algo$")
    public void obtengoResultado(){
        Assert.assertEquals("texto esperado", google.firstResult());;

    } 
}
