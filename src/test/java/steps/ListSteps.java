package steps;

import java.util.List;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.ListPage;

public class ListSteps {
    ListPage list = new ListPage();

    @Given("^Navego a la lista de la pagina$")
    public void navigateToListPage(){
        list.navigateToListPage();
    }
    @When("^Busco algo de la lista$")
    public void searhTheList() throws InterruptedException{
        list.enterSearchCriteria();
    }

    @Then("^Encuentro el texto que busco en la lista$")
    public void theTableIsThere(){
        List<String> lista = list.getAllSearchResults();
        boolean textIsThere = lista.contains("seatle, washington");

        if(textIsThere){
            System.out.println("El texto hardcodeado esta en la lista");
        }else{
            throw new Error ("El texto no esta en la lista");
        }

    }

    
}
