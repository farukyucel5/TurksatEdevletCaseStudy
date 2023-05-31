Feature: Nufus kayit ornegi belgesi sorgulama

  Background: The service to be tested
    Given Navigate to the service "Certificate of birth registration copy."
  @smoke
  Scenario:  Testing the service "The query of certificate of birth registration copy".
    And Check the consent checkbox and verify it is enabled
    Then Click on the Button Devam Et
    And verify it redirects to the related page
    And scroll down the page
    Then Choose one of the options "Nufus Kayıt Kişi" from the dropdown "Nufus Kayıt Ornegi"
    And scroll down the page
    And Choose the one of the option "Eski eş Hayır" from the "Eski Es Listele"
    And scroll down the page
    And  Choose the one of the option "Vukuatlı Belge Evet" from the "Vukuatlı Belge"
    And Choose one of the options "Verilme nedeni Kişi Talebi" from the dropdown "Belgenin Neden Verileceği"
    And Click on the Sorgula button
    Then verify that the related document has displayed
