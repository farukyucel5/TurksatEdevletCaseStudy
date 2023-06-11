package Pages;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;
import utilities.ReuseableMethods;

public class InformationAndConsentFormPage {
    private static final Logger logger = Logger.getLogger(InformationAndConsentFormPage.class);
    ReuseableMethods reuseableMethods=new ReuseableMethods();
    public InformationAndConsentFormPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "//*[@*='radioButton']")
    public WebElement informationAndConsentCheckbox;

    public void informationAndConsent(){
        Assert.assertTrue(informationAndConsentCheckbox.isEnabled());
        reuseableMethods.jsClick(informationAndConsentCheckbox);
        logger.info("The consent checkbox has been clicked");
    }

    @FindBy(xpath = "//*[@*='submitButton']")
    public static WebElement submitBtn;

    public void clickOnTheSubmitButton(){
        Assert.assertTrue(submitBtn.isEnabled());
        reuseableMethods.jsClick(submitBtn);
        logger.info("The submit button has been clicked");
    }
}
