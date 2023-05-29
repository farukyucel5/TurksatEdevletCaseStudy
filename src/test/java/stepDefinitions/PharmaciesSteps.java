package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import utilities.Driver;

public class PharmaciesSteps {

    @Given("Select the location")
    public void selectTheLocation() {
    }

    @And("Enter the date")
    public void enterTheDate() {
    }

    @Then("Click on the Button {string}")
    public void clickOnTheButton(String arg0) {
    }

    @Given("Navigate to the service {string}")
    public void navigateToTheService(String text) {
        Driver.driver.get("https://www.turkiye.gov.tr/saglik-titck-nobetci-eczane-sorgulama");

    }
}
