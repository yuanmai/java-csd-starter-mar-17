Feature: Booking Test

  Scenario: Booking
    Given "shenzx" booking "a1" court between "2017-03-06 05:00" and "2017-03-06 07:00"
    When the Reservator is run, and return true
    Then the output "Booking Success"