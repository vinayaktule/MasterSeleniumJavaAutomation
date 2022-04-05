package pages;

import base.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v85.page.Page;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    private WebDriver driver;
    WebDriverWait wait;
    public LoginPage(){
        ///driver = DriverFactory.getDriver(); //without singleton
        driver = DriverFactory.getCurrentDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        PageFactory.initElements(driver, this);
    }
/*  OLD APPROACH
    private WebElement username = driver.findElement(By.id("user-name"));
    private WebElement password = driver.findElement(By.id("password"));
    private WebElement submitBtn = driver.findElement(By.id("login-button")); */
    @CacheLookup
    @FindBy(how = How.ID, using =  "user-name")
    private WebElement usernameField;

    @CacheLookup
    @FindBy(id="password")
    private WebElement passwordField;

    @CacheLookup
    @FindBy(how = How.ID, using =  "login-button")
    private WebElement submitBtn;

    /*
    FindBy : Shows single or list<WebElement> & no. of FindBy locators
    FindBys : Shows list<WebElement> & AND operation for specified no. of FindBy locators
    FindAll : Shows list<WebElement> & OR operation for specified no. of FindBy locators
     */

    public InventoryPage login(String username, String password){
        usernameField.sendKeys(username);
        passwordField.sendKeys(password);
        submitBtn.click();
        return new InventoryPage();
    }
}
