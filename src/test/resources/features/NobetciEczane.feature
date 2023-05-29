Feature: On-duty pharmacies

  Background: The service to be tested
    Given Navigate to the service "On-Duty Pharmacy"
  @smoke
  Scenario: Find the pharmacies on duty based on the location.
    Given Select the location
    And Enter the date
    Then Click on the Button "Sorgula"