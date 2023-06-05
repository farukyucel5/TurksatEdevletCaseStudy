Feature: On-duty pharmacies

  Background: Navigating to the service to be tested
    Given Navigate to the service "On-Duty Pharmacy"
  @smoke
  Scenario: Find the pharmacies on duty based on the location.
    Given Select the location
    And Enter the date
    Then Click on the Button Sorgula
    And Select the county and verify the pharmacy table has been displayed
  @smoke
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



