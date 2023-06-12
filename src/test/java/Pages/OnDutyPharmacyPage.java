
package Pages;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import utilities.Driver;
import utilities.ReuseableMethods;

public class OnDutyPharmacyPage {
    private static final Logger logger = Logger.getLogger(OnDutyPharmacyPage.class);
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

    @FindBy(id = "aFavorite")
    public WebElement addToFavoritesBtn;

    public void addingToFavorites(){
        addToFavoritesBtn.click();
    }
    @FindBy(xpath = "//span[@class='ico-star']")
    public WebElement favoriteServices;
    public void navigateToTheFavorites(){
        favoriteServices.click();
    }
    public void removingFromTheFavorites(){
        Driver.driver.navigate().back();
        addToFavoritesBtn.click();
    }
    @FindBy(xpath = "//*[text()='Herhangi bir favori hizmetiniz bulunmamaktadır.']")
    public WebElement emptyFavoriteMessage;
    public void verifyingTheServiceHasBeenRemoved(){
        Assert.assertTrue(emptyFavoriteMessage.isDisplayed());
    }
    @FindBy(xpath = "//*[text()='TİTCK - Nöbetçi Eczane Sorgulama']")
    public WebElement onDutyPharmacyFavorite;
    public void verifyOnDutyPharmacyHasBeenAddedToFavorites(){
        Assert.assertTrue(onDutyPharmacyFavorite.isDisplayed());
    }
    @FindBy(xpath = "//a[@class='modalLink']")
    public WebElement puanlaBildirBtn;
    public void clickOnThePuanlaBildir(){
        puanlaBildirBtn.click();
    }
    @FindBy(xpath = "//div[@class='formRow']")
    public WebElement assertionPanel;

    public void verifingTheAssertionPanel (){
        Assert.assertTrue(assertionPanel.isDisplayed());
    }
    @FindBy(xpath = "//*[@*='richText']")
    public WebElement richText;
    public void verifyingThatTheEvaluationPanelHasClosed(){
        Assert.assertTrue(richText.isDisplayed());

    }
    @FindBy(xpath = "//*[text()='Kapat']")
    public WebElement closeBtn;
    public void closeThePanel(){
        closeBtn.click();
    }

    public  void selectCity(){
        Select select=new Select(cityDropdown);
        select.selectByVisibleText("ANKARA");
        logger.info("The city selected");
    }
    public  void sendTheDate(){
        dateBox.sendKeys("03/06/2023");
        logger.info("The date has been passed");
    }
    public void sendTheWrongFormattedDate(){
        dateBox.sendKeys("aa.aa.ee");
    }
    public void clickOntheSorgulaButton(){
       reuseableMethods.jsClick(sorgulaBtn);
       logger.info("The sorgula button has been clicked");
    }

    public void verifyTheWarningTexts(){
        Assert.assertTrue(cityDropdownWarningText.isDisplayed());
        Assert.assertTrue(theShiftDateWarningText.isDisplayed());
    }
    public void verifyTheDateFieldErrorMessage(){
        Assert.assertTrue(theWrongFormattedDateWarningMessage.isDisplayed());
    }

    @FindBy(xpath = "//*[@*='modal-btn next']")
    public WebElement degerlendirmeGonderBtn;
    @FindBy(id = "hizmet_puan_secim_nedeni")
    public WebElement secimNedeniDropdown;
    public void setThePoint(int star){
        WebElement element= Driver.driver.findElement(By.xpath(
                "(//div[@class='jq-ry-rated-group jq-ry-group']//*[name()='svg'])["+star+"]"));

        if (star<5){
            element.click();
           Assert.assertTrue(secimNedeniDropdown.isDisplayed());
           Select select=new Select(secimNedeniDropdown);
           select.selectByVisibleText("Sürekli \"Teknik Aksaklık\" uyarısı alıyorum.");
           degerlendirmeGonderBtn.click();
       }else{
           element.click();
           degerlendirmeGonderBtn.click();
       }

    }




}
