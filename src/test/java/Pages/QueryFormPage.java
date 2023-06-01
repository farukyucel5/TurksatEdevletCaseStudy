package Pages;

import org.apache.poi.ss.formula.atp.Switch;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import utilities.Driver;
import utilities.ReuseableMethods;

public class QueryFormPage {
    ReuseableMethods reuseableMethods=new ReuseableMethods();
    public QueryFormPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id = "nkoTip")
    public WebElement nufusKayitTipiDropdown;
    @FindBy(id = "kullanilisAmac")
    public WebElement belgeninNedenVerilecegiDropdown;
    public void setDropdown(String option,String name){
        Select select=new Select(nufusKayitTipiDropdown);
        Select select1=new Select(belgeninNedenVerilecegiDropdown);
       switch (option){
           case "Nufus Kayıt Kişi"-> select.selectByVisibleText("Kişi");
           case "Nufus Kayıt Aile"->select.selectByVisibleText("Aile");
           case "Nufus Kayıt Nüfus Aile"->select.selectByVisibleText("Nüfus Aile");
           case "Verilme nedeni Kişi Talebi"->select1.selectByVisibleText("Kişi Talebi");
           case "Verilme nedeni Kurum Talebi"->select1.selectByVisibleText("Kurum Talebi");
           case "Verilme nedeni Kuruma İbraz"->select1.selectByVisibleText("Kuruma İbraz");
       }
    }

    @FindBy(xpath = "(//input[@value='H'])[1]")
    public WebElement eskiEsListeleHayir;
    @FindBy(xpath = "(//input[@value='E'])[1]")
    public WebElement eskiEsListeleEvet;

    @FindBy(xpath = "(//input[@value='E'])[2]")
    public WebElement vukuatliBelgeEvet;

    @FindBy(xpath = "(//input[@value='H'])[2]")
    public WebElement vukuatliBelgeHayir;
    public void setCheckbox(String option,String name){
        switch(option){
            case "Eski eş Hayır"->reuseableMethods.jsClick(eskiEsListeleHayir);
            case "Eski eş Evet"->reuseableMethods.jsClick(eskiEsListeleEvet);
            case "Vukuatlı Belge Evet"-> reuseableMethods.jsClick(vukuatliBelgeEvet);
            case "Vukuatlı Belge Hayır"->reuseableMethods.jsClick(vukuatliBelgeHayir);

        }

    }

    @FindBy(className = "submitButton")
    public WebElement sorgulaButton;
    public void clickOntheSorgulaButton(){
        reuseableMethods.jsClick(sorgulaButton);
    }


    public void verification(){
        String expectedPage="https://www.turkiye.gov.tr/nvi-nufus-kayit-ornegi-belgesi-sorgulama?kullanici=Bilgileri";
        String actualPage=Driver.driver.getCurrentUrl();
        Assert.assertEquals(expectedPage,actualPage);
    }
}
