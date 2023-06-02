package Pages;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;
import utilities.ReuseableMethods;

import java.time.Duration;

public class PopulationRegisterPage {
    ReuseableMethods reuseableMethods=new ReuseableMethods();
    public PopulationRegisterPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "//embed[@type='application/x-google-chrome-pdf']")
    public WebElement document;
    @FindBy(xpath = "//*[text()='Aynı gün içinde birden fazla belge üretilemez.']")
    public WebElement oneMoreThanDocumentQueryWarningText;
    public void verifyTheDocument(){
        try{
            Assert.assertTrue(oneMoreThanDocumentQueryWarningText.isDisplayed());

        } catch (Exception e) {
            reuseableMethods.scrollToElementByActions(1);
            Assert.assertTrue(document.isDisplayed());
        }


    }

    @FindBy(xpath = "//*[text()='Yeni Sorgulama']")
    public WebElement yeniSorguButton;
    @FindBy(xpath = "//*[text()='Geri']")
    public WebElement geriButton;
    @FindBy(xpath = "//*[text()='Kayıtlı Belgelerim']")
    public WebElement kayitliBelgelerimButton;

    @FindBy(xpath = "//table[@summary='Nüfus Kayıt Belgeleri Listesi']")
    public WebElement nufusKayitBelgeleriListesi;
    public void verifyTheButtons(){
        try{
            Assert.assertTrue(oneMoreThanDocumentQueryWarningText.isDisplayed());
            Assert.assertTrue(yeniSorguButton.isEnabled());
            yeniSorguButton.click();
            String expectedUrlYeniSorgu="https://www.turkiye.gov.tr/nvi-nufus-kayit-ornegi-belgesi-sorgulama?kullanici=bilgileri";
            String actualUrlYeniSorgu=Driver.driver.getCurrentUrl();
            Assert.assertEquals(expectedUrlYeniSorgu,actualUrlYeniSorgu);
            Driver.driver.navigate().back();
            kayitliBelgelerimButton.click();
            Assert.assertTrue(nufusKayitBelgeleriListesi.isDisplayed());
        } catch (Exception e) {
            Assert.assertTrue(document.isDisplayed());
        }


    }
}
