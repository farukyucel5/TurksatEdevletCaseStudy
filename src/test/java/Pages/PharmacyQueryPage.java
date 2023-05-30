package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import utilities.Driver;
import utilities.ReuseableMethods;

public class PharmacyQueryPage {
    public PharmacyQueryPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    ReuseableMethods reuseableMethods=new ReuseableMethods();
    @FindBy(xpath = "//select[@id='col_1_inp']")
    public WebElement countyDropbox;

    public void setCounty(){
        Select select=new Select(countyDropbox);
        for (int i = 0; i <11 ; i++) {
            select.selectByVisibleText(reuseableMethods.dataFetching(i,0).toString()
                    .replaceAll("\\s",""));
        }

    }
}
