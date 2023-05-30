
package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import utilities.Driver;
import utilities.ReuseableMethods;

public class OnDutyPharmacyPage {
    ReuseableMethods reuseableMethods=new ReuseableMethods();
    public OnDutyPharmacyPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id = "plakaKodu")
    private WebElement cityDropdown;

    @FindBy(xpath = "//input[@id='nobetTarihi']")
    private WebElement dateBox;
    @FindBy(xpath = "//input[@value='Sorgula']")
    private WebElement sorgulaBtn;
    public  void selectCity(){
        Select select=new Select(cityDropdown);
        select.selectByVisibleText("ANKARA");
    }
    public  void sendTheDate(){
        dateBox.sendKeys("03/06/2023");
    }
    public void clickOntheElement(String element){
        switch (element){
            case "Sorgula"->reuseableMethods.jsClick(sorgulaBtn);
        }
    }


}
