package Pages;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.Driver;
import utilities.ReuseableMethods;

import java.time.Duration;
import java.util.List;

public class PharmacyQueryPage {
    private static final Logger logger = Logger.getLogger(PharmacyQueryPage.class);
    public PharmacyQueryPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    WebDriverWait wait=new WebDriverWait(Driver.driver, Duration.ofSeconds(10));
    ReuseableMethods reuseableMethods=new ReuseableMethods();
    @FindBy(xpath = "//select[@id='col_1_inp']")
    public WebElement countyDropbox;
    @FindBy(xpath = "//tbody/tr/td[2]")
    public List<WebElement> countyColumn;

    @FindBy(id="searchTable")
    public WebElement countyTable;
    @FindBy(xpath = "//tbody/tr/td[5]/a")
    public List<WebElement> showingInTheMap;
    @FindBy(id = "mapid")
    public WebElement map;

    public void setCountyAndVerifyThePharmacyTable(){
        Select select=new Select(countyDropbox);
        for (int i = 0; i <2 ; i++) {
            String county=reuseableMethods.dataFetching(i,0).toString()
                    .replaceAll("\\s","");
            select.selectByVisibleText(county);
            logger.info(county+" is selected");
            Assert.assertTrue(countyTable.isDisplayed());
            logger.info("it is verified that "+county+" is selected");
        }
    }

    public void ClickOnTheButtonHaritadaGosterAndVerifyTheResult(){
        for (int i = 0; i < 20; i++) {
            reuseableMethods.jsClick(showingInTheMap.get(i));
            logger.info("Haritada göster has been clicked");
            Assert.assertTrue(map.isDisplayed());
            logger.info("it has been verified the map has been displayed properly");
            Driver.driver.navigate().back();

        }
    }

}

