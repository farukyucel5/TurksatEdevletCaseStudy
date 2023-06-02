package utilities;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

public class ReuseableMethods {

    public void waitAndClick(WebElement element){
        WebDriverWait wait=new WebDriverWait(Driver.driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOf(element));
        element.click();
    }

    public void jsClick(WebElement element){
        // Create a JavascriptExecutor instance
        JavascriptExecutor executor = (JavascriptExecutor) Driver.driver;

        // Simulate a click on the element using JavaScript
        executor.executeScript("arguments[0].click();", element);
    }

    public static String currentDir = System.getProperty("user.dir");

    public Cell dataFetching(int row, int column){
        String dosyaYolu=currentDir+"\\src\\test\\java\\Data\\PharmacyOnDuty.xlsx";
        Workbook workbook= null;
        try {
            FileInputStream fis = new FileInputStream(dosyaYolu);
            workbook = WorkbookFactory.create(fis);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return workbook.getSheet("Counties").getRow(row).getCell(column);
    }

    public void navigateToTheServiceToBeTested(String name){
        switch (name){
            case "On-Duty Pharmacy" ->Driver.
                    driver.get("https://www.turkiye.gov.tr/saglik-titck-nobetci-eczane-sorgulama");
            case "Certificate of birth registration copy."->Driver.
                    driver.get("https://www.turkiye.gov.tr/nvi-nufus-kayit-ornegi-belgesi-sorgulama");
        }
    }

    public void scrollToElementByActions(int count){
        for (int i = 0; i < count; i++) {
            Actions actions=new Actions(Driver.driver);
            actions.sendKeys(Keys.PAGE_DOWN).perform();
        }
    }

    public void explicitlyWait(WebElement element){
        WebDriverWait wait =new WebDriverWait(Driver.driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

}
