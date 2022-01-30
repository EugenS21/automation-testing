Feature: Verify alarms count on rest side

  @Run
  Scenario: Rest alarms testing scenario
    When get active alarms
    Then expecting 0 alarms
