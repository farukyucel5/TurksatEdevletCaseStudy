package stepDefinitions;

import Pages.OnDutyPharmacyPage;
import Pages.PharmacyQueryPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import utilities.Driver;

public class PharmaciesSteps {
   OnDutyPharmacyPage onDutyPharmacyPage=new OnDutyPharmacyPage();
   PharmacyQueryPage pharmacyQueryPage =new PharmacyQueryPage();
    @Given("Select the location")
    public void selectTheLocation() {
        onDutyPharmacyPage.selectCity();
    }

    @And("Enter the date")
    public void enterTheDate() {
        onDutyPharmacyPage.sendTheDate();
    }

    @Then("Click on the Button {string}")
    public void clickOnTheButton(String element) {
        onDutyPharmacyPage.clickOntheElement(element);
    }

    @Given("Navigate to the service {string}")
    public void navigateToTheService(String text) {
        Driver.driver.get("https://www.turkiye.gov.tr/saglik-titck-nobetci-eczane-sorgulama");

    }

    @And("Select the county")
    public void selectTheCounty() {
     pharmacyQueryPage.setCounty();
    }
}