package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

    // clase para crear una instancia estatica del webdriver (el navegador)

    protected static WebDriver driver;
    private static WebDriverWait wait;
    private static Actions action;
    

    static{
        ChromeOptions chromeOptions = new ChromeOptions();
        driver = new ChromeDriver(chromeOptions);
        wait = new WebDriverWait(driver, 10);
    }
    public BasePage(WebDriver driver){
        BasePage.driver = driver;
        wait = new WebDriverWait(driver, 10);
    }

    public static void navigateTo(String url){
        driver.get(url);

    }

    public static void closeBrowser(){
        driver.quit();
    }

    private WebElement Find(String locator){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
    }

    public void clickElement(String locator){
        Find(locator).click();
    }

    public void write(String locator, String textToWrite){
        Find(locator).clear();
        Find(locator).sendKeys(textToWrite);
    }

    public void selectFromDropdownByValue(String locator, String valueToSelec){
        Select dropdown = new Select(Find(locator));
        dropdown.selectByValue(valueToSelec);

    }
    public void selectFromDropdownByIndex(String locator, int valueToSelec){
        Select dropdown = new Select(Find(locator));
        dropdown.selectByIndex(valueToSelec);

    }
    public void hoverOverElement(String locator){
        action.moveToElement(Find(locator));
    }

    public void doubleClick(String locator){
        action.doubleClick(Find(locator));
    }

    public void rightClik(String locator){
        action.contextClick(Find(locator));
    }

    //funciones para trabajar con pop up, con esta funcion las acciones se centran en la ventana emergente del pop up
    public void switchToiFrame(int iFrameIndex){
        driver.switchTo().frame(iFrameIndex);
    }
    // con esta funcion las acciones retornan a la pantalla principal
    public void switchToParentFrame(){
        driver.switchTo().parentFrame();
    }
    //esta funicon detecta una alerta y si la encuentra la ignora, para poder seguir con el test.
    public void dismissAlert(){
        try{
        driver.switchTo().alert().dismiss();
    }catch(NoAlertPresentException e){
        e.printStackTrace();
    }
    }
    // esta funcion me retorna un texto solo si lo encuentra
    public String textFromElement (String locator){
        return Find(locator).getText();
    }

    public void setValueOntable(String locator, int row, int column, String stringToSend){
        String cellTofill = locator+"/table/tbody/tr["+row+"]/td["+column+"]";
        Find(cellTofill).sendKeys(stringToSend);

    }

    public boolean elementEnabled(String locator){
        return Find(locator).isEnabled();
    }

    public boolean elementIsDisplayed(String locator){
        return Find(locator).isDisplayed();
    }

    public boolean elementIsSelected(String locator){
        return Find(locator).isSelected();
    }

    public List<WebElement> bringMeAllElements(String locator){
        return driver.findElements(By.className(locator));
    }


}
