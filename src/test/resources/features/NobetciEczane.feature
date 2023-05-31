Feature: On-duty pharmacies

  Background: The service to be tested
    Given Navigate to the service "On-Duty Pharmacy"

  Scenario: Find the pharmacies on duty based on the location.
    Given Select the location
    And Enter the date
    Then Click on the Button Sorgula
    And Select the county and verify the pharmacy table has been displayed

  Scenario: Showing on the map
    Given Select the location
    And Enter the date
    Then Click on the Button Sorgula
    And Click on the Button Haritada Göster and verify it redirects to the related page
    