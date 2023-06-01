package stepDefinitions;

import Pages.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import utilities.Driver;
import utilities.ReuseableMethods;

public class Steps {
   OnDutyPharmacyPage onDutyPharmacyPage=new OnDutyPharmacyPage();
   PharmacyQueryPage pharmacyQueryPage =new PharmacyQueryPage();
   ReuseableMethods reuseableMethods=new ReuseableMethods();
   InformationAndConsentFormPage informationAndConsentFormPage=new InformationAndConsentFormPage();
   QueryFormPage queryFormPage =new QueryFormPage();
   PopulationRegisterPage populationRegisterPage=new PopulationRegisterPage();
    @Given("Select the location")
    public void selectTheLocation() {
        onDutyPharmacyPage.selectCity();
    }

    @And("Enter the date")
    public void enterTheDate() {
        onDutyPharmacyPage.sendTheDate();
    }

    @Then("Click on the Button Sorgula")
    public void clickOnTheButtonSorgula() {
        onDutyPharmacyPage.clickOntheElement();
    }

    @Given("Navigate to the service {string}")
    public void navigateToTheService(String text) {
      reuseableMethods.navigateToTheServiceToBeTested(text);
    }

    @And("Select the county and verify the pharmacy table has been displayed")
    public void selectTheCountyAndVerifyThePharmacyTableHasBeenDisplayed() {
        pharmacyQueryPage.setCountyAndVerifyThePharmacyTable();
    }

    @And("Click on the Button Haritada Göster and verify it redirects to the related page")
    public void clickOnTheButtonHaritadaGösterAndVerifyItRedirectsToTheRelatedPage() {
        pharmacyQueryPage.ClickOnTheButtonHaritadaGosterAndVerifyTheResult();
    }


    @And("Check the consent checkbox and verify it is enabled")
    public void checkTheConsentCheckboxAndVerifyItIsEnabled() {
        informationAndConsentFormPage.informationAndConsent();
    }

    @Then("Click on the Button Devam Et")
    public void clickOnTheButtonDevamEt() {
        informationAndConsentFormPage.clickOnTheSubmitButton();
    }

    @And("verify it redirects to the related page")
    public void verifyItRedirectsToTheRelatedPage() {
        queryFormPage.verification();
    }

    @Then("Choose one of the options {string} from the dropdown {string}")
    public void chooseOneOfTheOptionsFromTheDropdown(String option, String name) {
      queryFormPage.setDropdown(option,name);
    }

    @And("Choose the one of the option {string} from the {string}")
    public void chooseTheOneOfTheOptionFromThe(String option, String name) {
        queryFormPage.setCheckbox(option,name);
    }

    @And("Click on the Sorgula button")
    public void clickOnTheSorgulaButton() {
        queryFormPage.clickOntheSorgulaButton();
    }


    @And("scroll down the page")
    public void scrollDownThePage() {
        reuseableMethods.scrollToElementByActions(1);
    }

    @Then("verify that the related document has displayed")
    public void verifyThatTheRelatedDocumentHasDisplayed() {
      populationRegisterPage.verifyTheDocument();
    }

}
