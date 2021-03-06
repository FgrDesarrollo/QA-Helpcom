package pages;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import org.openqa.selenium.WebElement;

public class ListPage extends BasePage{

    private String searchField = "//body/form[1]/input[1]";
    private String searchResults = "name";

    public ListPage(){
        super(driver);
    }

    public void navigateToListPage(){
        navigateTo("https://andreidbr.github.io/JS30/06AjaxTypeAhead/index.html");
    }
    // Se agrega un try cath para controlar si el elemento que estamos buscando esta o no
    public void enterSearchCriteria() throws InterruptedException{
        try{
        Thread.sleep(600);
        write(searchField, "Los Angeles");
        }catch(NoSuchElementException e){
            e.printStackTrace();
        }
    }
    //Funcion que crea una lista de string para traer los elementos de una lista de elementos que pertenecen a un dropdown
    public List<String> getAllSearchResults(){
        List<WebElement> list = bringMeAllElements(searchResults);
        List<String> stringFromList = new ArrayList<String>();
        for(WebElement e: list){
            stringFromList.add(e.getText());
        }
        return stringFromList;

    }
}
