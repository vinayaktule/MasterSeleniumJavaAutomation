package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.time.Duration;

public class BaseTest {
    @BeforeClass
    public void setUp() {
        WebDriver driver = null;
        WebDriverWait wait;

        ///option to take browser value from command line
        String browser = System.getProperty("browser", "chrome");
        if (browser.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("chrome")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://saucedemo.com/");
        DriverFactory.getInstance().setDriver(driver);
        System.out.println("Setup is initiated");
    }

    @AfterClass
    public void tearDown(){
        ///DriverFactory.getDriver().quit();                //Before singleton approach
        ///DriverFactory.getInstance().getDriver().quit();  //After singleton approach
        DriverFactory.getCurrentDriver();                   // Profound way after singleton approach
        System.out.println("Teardown complete");
    }

}
