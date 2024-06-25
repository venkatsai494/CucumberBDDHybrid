Feature: My Account Page feature

  Background:
    Given user has clicked on "My Account" link


  Scenario: My Account Page Title
    Given User is on My Account page
    When user gets the title of the page
    Then page title should be "Automation Practice Site"


