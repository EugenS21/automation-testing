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
    When user click on alarm details
    Then expecting a modal with title 'netdata alarms'
    When switch to tab 'Log'
    Then expecting only alarms with clear status
    When close alarm details modal


