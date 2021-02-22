
Feature: Open and input data in Tricents page
  As an user
  I'd like to open the Tricents page for starting to
  input data 
  
  
  Scenario: Fill, send Tricents data form and receive success confirmation.
    Given I am in Tricents web page
    When I fulfill the entire tricents data form
    And send the fullfiled data form
    Then I should receive the success pop-up "Sending e-mail success!"
 

  