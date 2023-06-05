
package Pages;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import utilities.Driver;
import utilities.ReuseableMethods;

import java.util.List;

public class OnDutyPharmacyPage {
    ReuseableMethods reuseableMethods=new ReuseableMethods();
    public OnDutyPharmacyPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id = "plakaKodu")
    public WebElement cityDropdown;

    @FindBy(xpath = "//input[@id='nobetTarihi']")
    public WebElement dateBox;
    @FindBy(xpath = "//input[@value='Sorgula']")
    public WebElement sorgulaBtn;

    @FindBy(id="plakaKodu-error")
    public WebElement cityDropdownWarningText;
    @FindBy(id = "nobetTarihi-error")
    public WebElement theShiftDateWarningText;

    @FindBy(xpath="//div[text()='Lütfen uygun formatta tarih giriniz.']")
    public WebElement theWrongFormattedDateWarningMessage;
    public  void selectCity(){
        Select select=new Select(cityDropdown);
        select.selectByVisibleText("ANKARA");
    }
    public  void sendTheDate(){
        dateBox.sendKeys("03/06/2023");
    }
    public void sendTheWrongFormattedDate(){
        dateBox.sendKeys("aa.aa.ee");
    }
    public void clickOntheSorgulaButton(){
       reuseableMethods.jsClick(sorgulaBtn);
    }

    public void verifyTheWarningTexts(){
        Assert.assertTrue(cityDropdownWarningText.isDisplayed());
        Assert.assertTrue(theShiftDateWarningText.isDisplayed());
    }
    public void verifyTheDateFieldErrorMessage(){
        Assert.assertTrue(theWrongFormattedDateWarningMessage.isDisplayed());
    }




}
