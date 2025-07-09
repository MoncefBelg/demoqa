Feature: Nested Iframes

  Background:
    When user browse to the website
    And user clicks on Widget Icon

    @regression @nestedIframes
    Scenario: User should be able to highlight the child iframe

      When User clicks on the Alerts,Frame & Windows
      And User clicks on the Nested Iframe
      Then User should be able to highlight the child iframe
