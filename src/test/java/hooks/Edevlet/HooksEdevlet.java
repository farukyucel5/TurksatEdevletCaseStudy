package hooks.Edevlet;

import Pages.MainPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import utilities.Driver;

public class HooksEdevlet {

   private WebDriver driver;
   MainPage mainPage=new MainPage();
    @Before
    public void setup()  {
        driver=Driver.getDriver();
        driver.get("https://www.turkiye.gov.tr/");
        Actions actions=new Actions(driver);
        actions.sendKeys(Keys.ESCAPE).perform();
        mainPage.clickOntheElement("Giriş Yap");
        mainPage.sendText("IdTextBox");
        mainPage.sendText("Password");
        mainPage.clickOntheElement("giriş yap");
    }
    @After
    public void teardown() {
        driver.quit();
    }
}
