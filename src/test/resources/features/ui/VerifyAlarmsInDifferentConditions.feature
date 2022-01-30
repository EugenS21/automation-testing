Feature: Verify alarms count on ui

  Background:
    Given user navigates to home page
    Then user is on home page

@Run
  Scenario: UI alarms testing scenario
    When user read warning alarms count
    Then expecting 0 warning alarms count
    When user read error alarms count
    Then expecting 0 error alarms count


