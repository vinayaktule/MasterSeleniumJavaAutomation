import base.BaseTest;
import base.DriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class TestLogin extends BaseTest {
        WebDriverWait wait;

        @Test
        public void mavenParameterTest() throws InterruptedException {
                WebDriver driver = DriverFactory.getDriver();
                //wait = new WebDriverWait(driver, Duration.ofSeconds(30));
                driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
                driver.get("https://saucedemo.com/");
                driver.findElement(By.id("user-name")).sendKeys("standard_user");
                driver.findElement(By.id("password")).sendKeys("secret_sauce");
                driver.findElement(By.id("login-button")).click();
                Thread.sleep(5000);
                driver.manage().window().maximize();
                driver.quit();
        }
}
