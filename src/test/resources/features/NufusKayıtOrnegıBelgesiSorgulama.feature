Feature: Nufus kayit ornegi belgesi sorgulama

  Background: The service to be tested
    Given Navigate to the service "Certificate of birth registration copy."
  @smoke
  Scenario:  Testing the service "The query of certificate of birth registration copy".
    And Check the consent checkbox and verify it is enabled
    Then Click on the Button Devam Et
    And verify it redirects to the related page
    And scroll down the page
    Then Choose one of the options "Nufus Kayıt Nüfus Aile" from the dropdown "Nufus Kayıt Ornegi"
    And Choose the one of the option "Eski eş Evet" from the "Eski Es Listele"
    And  Choose the one of the option "Vukuatlı Belge Evet" from the "Vukuatlı Belge"
    And Choose one of the options "Verilme nedeni Kişi Talebi" from the dropdown "Belgenin Neden Verileceği"
    And Click on the Sorgula button
    Then verify that the related document has displayed
  @smoke1
  Scenario: Testing the buttons "Yeni Sorgulama" and "Kayıtlı Belgelerim"
    And Check the consent checkbox and verify it is enabled
    Then Click on the Button Devam Et
    And verify it redirects to the related page
    And scroll down the page
    Then Choose one of the options "Nufus Kayıt Nüfus Aile" from the dropdown "Nufus Kayıt Ornegi"
    And Choose the one of the option "Eski eş Evet" from the "Eski Es Listele"
    And  Choose the one of the option "Vukuatlı Belge Evet" from the "Vukuatlı Belge"
    And Choose one of the options "Verilme nedeni Kişi Talebi" from the dropdown "Belgenin Neden Verileceği"
    And Click on the Sorgula button
    Then verify the buttons Yeni Sorgulama and Kayitli Belgelerim function properly.

