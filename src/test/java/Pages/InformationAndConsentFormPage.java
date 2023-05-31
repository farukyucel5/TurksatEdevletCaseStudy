package Pages;

import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;
import utilities.ReuseableMethods;

public class InformationAndConsentFormPage {
    ReuseableMethods reuseableMethods=new ReuseableMethods();
    public InformationAndConsentFormPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "//*[@*='radioButton']")
    public WebElement informationAndConsentCheckbox;

    public void informationAndConsent(){
        Assert.assertTrue(informationAndConsentCheckbox.isEnabled());
       reuseableMethods.jsClick(informationAndConsentCheckbox);
    }

    @FindBy(xpath = "//*[@*='submitButton']")
    public static WebElement submitBtn;

    public void clickOnTheSubmitButton(){
        Assert.assertTrue(submitBtn.isEnabled());
        reuseableMethods.jsClick(submitBtn);
    }
}
