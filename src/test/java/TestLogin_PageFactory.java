import base.BaseTest;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.InventoryPage;
import pages.LoginPage;

public class TestLogin_PageFactory extends BaseTest {
        WebDriverWait wait;

        @Test
        public void mavenParameterTest() throws InterruptedException {
                LoginPage loginPage = new LoginPage();
                InventoryPage inventoryPage = new InventoryPage();
                loginPage.login("standard_user", "secret_sauce");
                Thread.sleep(2000);
                Assert.assertEquals(inventoryPage.getProductTitleText(),"products");
        }
}
