package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.ConfigReader;
import utilities.Driver;

public class MainPage {

    public MainPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "//*[text()=' Giriş Yap ']")
    public WebElement loginBtn;
    @FindBy(xpath = "//*[@*='Kimlik numaranız 11 adet rakamdan oluşmalıdır']")
    public WebElement tcTextBox;
    @FindBy(xpath = "//input[@id='egpField']")
    public WebElement password;
    @FindBy(xpath = "//input[@value='Giriş Yap']")
    public WebElement submitBtn;
    public void sendText(String text){
        switch (text){
            case "IdTextBox"->tcTextBox.sendKeys(ConfigReader.getProperty("personel_Id_number"));
            case "Password"->password.sendKeys(ConfigReader.getProperty("password"));
        }
    }
    public void clickOntheElement(String text){

        switch (text){
            case "Giriş Yap"->loginBtn.click();
            case "giriş yap"->submitBtn.click();
        }
    }
}
