Feature: On-duty pharmacies

  Background: Navigating to the service to be tested
    Given Navigate to the service "On-Duty Pharmacy"
  @smoke1
  Scenario: Find the pharmacies on duty based on the location.
    Given Select the location
    And Enter the date
    Then Click on the Button Sorgula
    And Select the county and verify the pharmacy table has been displayed
  @smoke1
  Scenario: Verify that Showing on the map feature should function properly
    Given Select the location
    And Enter the date
    Then Click on the Button Sorgula
    And Click on the Button Haritada Göster and verify it redirects to the related page
  @smoke
  Scenario: if mandatory fields are not filled on the pharmacy query page,the warning texts should appear
    Given Click on the Button Sorgula without filling the mandatory fields
    And verify whether the warning texts have appeared.
  @smoke
  Scenario: if the date is passed in a wrong format,the warning message "Lütfen uygun formatta tarih giriniz."
    should appear.
    Given Select the location
    And Enter the date in a wrong format
    Then Click on the Button Sorgula
    Then Verify whether the date field error message has appeared
 @smoke
  Scenario: The feature "Favorilerime Ekle" is to function accurately.
    Given Click on the button favorilerime ekle
    And Navigate to the  Favori Hizmetlerim
    And verify that the service has been added to favorite services.
    And navigate back and hit the button Favorilerimden cıkar
    And Navigate to the  Favori Hizmetlerim
    Then verify that the service has been removed
  @smoke
  Scenario: The evaluation panel should appear when the user hits the 'Puanla' (Rate) or 'Bildir' (Report)
  button and disappear when the user hits the 'Kapat' (Close) button.
    Given Click on the button PuanlaBildir
    And Verify that the evaluation panel has opened
    And click on the button Kapat
    Then Verify that the panel has disappeared
  @smoke
  Scenario Template: User should be able to evaluate the service giving stars and
  if less than 5 stars are given, a dropdown should appear asking the reason for the choice.
    Given Click on the button PuanlaBildir
    And Rate the service by giving less than "<star>" stars and close the panel
    Then Verify that the panel has disappeared
    Examples:
      | star |
      |5     |
      |4     |
      |1     |








