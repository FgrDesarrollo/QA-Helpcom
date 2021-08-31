package pages;

public class GooglePage extends BasePage{

    private String searchButton = "//body/div[1]/div[3]/form[1]/div[1]/div[1]/div[3]/center[1]/input[1]";
    private String searchTextField = "//input[@title='Buscar']";
    private String firstResult ="";

    public GooglePage(){
        super(driver);
    }
    public void navigateToGoogle(){
        navigateTo("https://www.google.com");
    }

    public void clickGoogleSearh(){
        clickElement(searchButton);
    }

    public void enterSearchCriteria(String criteria){
        write(searchTextField,criteria);

    }

    public String firstResult(){
        return textFromElement(firstResult);
    }


}
