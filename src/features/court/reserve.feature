Feature: reserving court

  Scenario: eserving court
    Given i input "2" and "2"
    When the calculator is run
    Then the out put should be "4"