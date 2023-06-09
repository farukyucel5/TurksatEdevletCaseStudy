package stepDefinitions;

import Pages.*;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.qameta.allure.Step;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.junit.BeforeClass;
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
        onDutyPharmacyPage.clickOntheSorgulaButton();
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

    @Then("verify the buttons Yeni Sorgulama and Kayitli Belgelerim function properly.")
    public void verifyTheButtonsYeniSorgulamaAndKayitliBelgelerimFunctionProperly() {
     populationRegisterPage.verifyTheButtons();
    }

    @Given("Click on the Button Sorgula without filling the mandatory fields")
    public void clickOnTheButtonSorgulaWithoutFillingTheMandatoryFields() {
     onDutyPharmacyPage.clickOntheSorgulaButton();

    }

    @And("verify whether the warning texts have appeared.")
    public void verifyWhetherTheWarningTextsHaveAppeared() {
        onDutyPharmacyPage.verifyTheWarningTexts();
    }

    @And("Enter the date in a wrong format")
    public void enterTheDateInAWrongFormat() {
      onDutyPharmacyPage.sendTheWrongFormattedDate();
    }

    @Then("Verify whether the date field error message has appeared")
    public void verifyWhetherTheDateFieldErrorMessageHasAppeared() {
        onDutyPharmacyPage.verifyTheDateFieldErrorMessage();
    }

    @Given("Click on the button favorilerime ekle")
    public void clickOnTheButtonFavorilerimeEkle() {
        onDutyPharmacyPage.addingToFavorites();
    }

    @And("verify that the service has been added to favorite services.")
    public void verifyThatTheServiceHasBeenAddedToFavoriteServices() {
       onDutyPharmacyPage.verifyOnDutyPharmacyHasBeenAddedToFavorites();
    }

    @And("Navigate to the  Favori Hizmetlerim")
    public void navigateToTheFavoriHizmetlerim() {
        onDutyPharmacyPage.navigateToTheFavorites();
    }

    @And("navigate back and hit the button Favorilerimden cıkar")
    public void navigateBackAndHitTheButtonFavorilerimdenCıkar() {
        onDutyPharmacyPage.removingFromTheFavorites();
    }

    @Then("verify that the service has been removed")
    public void verifyThatTheServiceHasBeenRemoved() {
        onDutyPharmacyPage.verifyingTheServiceHasBeenRemoved();
    }

    @Given("Click on the button PuanlaBildir")
    public void clickOnTheButtonPuanlaBildir() {
        onDutyPharmacyPage.clickOnThePuanlaBildir();
    }

    @And("Verify that the evaluation panel has opened")
    public void verifyThatTheEvaluationPanelHasOpened() {
        onDutyPharmacyPage.verifingTheAssertionPanel();
    }

    @And("click on the button Kapat")
    public void clickOnTheButtonKapat() {
        onDutyPharmacyPage.closeThePanel();

    }

    @Then("Verify that the panel has disappeared")
    public void verifyThatThePanelHasDisappeared() {
        onDutyPharmacyPage.verifyingThatTheEvaluationPanelHasClosed();
    }

    @And("Rate the service by giving less than {string} stars and close the panel")
    public void rateTheServiceByGivingLessThanStarsAndCloseThePanel(String number) {
        int star=Integer.parseInt(number);
        onDutyPharmacyPage.setThePoint(star);
    }
}
