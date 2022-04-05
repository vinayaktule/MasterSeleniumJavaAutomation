package pages;

import base.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class InventoryPage {
    private WebDriver driver;
    private WebDriverWait wait;
    public InventoryPage(){
        ///driver = DriverFactory.getDriver(); //Before singleton pattern
        driver = DriverFactory.getCurrentDriver();
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(3));
    }

    //By title= By.cssSelector(".title");
    @CacheLookup
    @FindBy(css = ".title")
    private WebElement ProductTitle;

    public String getProductTitleText(){
        //wait.until(ExpectedConditions.presenceOfElementLocated(title));

        return ProductTitle.getText().toLowerCase();
    }
}
