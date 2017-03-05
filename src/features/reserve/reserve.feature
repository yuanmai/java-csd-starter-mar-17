Feature: reserve Test

Scenario: reserve site
    Given i input "linyh" and "2017030400" and "2017030401" and "1"
    When no others subcibed
    Then the out put should be "OK"