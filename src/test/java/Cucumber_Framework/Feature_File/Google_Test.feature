Feature: Google Test Scenarios

  Scenario: TC01 - Capture Search Result
    Given I navigate to Google homepage
    When I enter a keyword on search field
    When I click on Search button
    Then I capture my search result
    And I print my search number



