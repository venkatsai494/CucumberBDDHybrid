Feature: Home page feature


@Regression @Smoke
  Scenario: Home Page Title
    Given User is on home page
    When user gets the title of the page
    Then page title should be "Automation Practice Site"

  @Regression
  Scenario: Home Page Logo
    Given User is on home page
    When user gets the source link of logo image
    Then source link of image should be "https://practice.automationtesting.in/wp-content/uploads/2017/01/color-logo-original.png"

    @Smoke
  Scenario: Home Page Header Links
    Given User is on home page
    When user gets the list of header links
    Then header links should be present