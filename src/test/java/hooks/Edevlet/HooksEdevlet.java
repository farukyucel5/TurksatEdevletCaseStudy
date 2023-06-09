package hooks.Edevlet;

import Pages.MainPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import stepDefinitions.Steps;
import utilities.Driver;

public class HooksEdevlet {

   private WebDriver driver;
   MainPage mainPage=new MainPage();
    @Before(order = 2)
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

    private static final Logger LOGGER = Logger.getLogger(Steps.class);

    @Before(order = 1)
    public void setUp() {
        // Configure Log4j
        PropertyConfigurator.configure("src/test/resources/log4j.properties");
    }
    @After
    public void teardown() {
        Driver.quitDriver();
    }
}
