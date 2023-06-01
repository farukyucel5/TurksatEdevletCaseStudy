package Pages;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class PopulationRegisterPage {
    public PopulationRegisterPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "//embed[@type='application/x-google-chrome-pdf']")
    public WebElement document;
    @FindBy(xpath = "//*[text()='Aynı gün içinde birden fazla belge üretilemez.']")
    public WebElement oneMoreThanDocumentQueryWarningText;
    public void verifyTheDocument(){
        try{
            boolean b = !oneMoreThanDocumentQueryWarningText.isDisplayed();
            Assert.assertTrue(document.isDisplayed());
        } catch (Exception e) {
            Assert.assertTrue(oneMoreThanDocumentQueryWarningText.isDisplayed());
        }


    }
}
