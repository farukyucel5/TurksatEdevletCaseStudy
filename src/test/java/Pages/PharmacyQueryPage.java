package Pages;

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
            Assert.assertTrue(countyTable.isDisplayed());
        }
    }

    public void ClickOnTheButtonHaritadaGosterAndVerifyTheResult(){
        for (int i = 0; i < 20; i++) {
            reuseableMethods.jsClick(showingInTheMap.get(i));
            Assert.assertTrue(map.isDisplayed());
            Driver.driver.navigate().back();

        }
    }

}

