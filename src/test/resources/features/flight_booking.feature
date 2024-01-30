#Author: Team-1
#Date: 2024-01-27
#Description: This is a test case for smoke test

#Test Case: flight_booking
#Test Title: Validate the Flight Tab Includes Search Bar for Flight

#Test Steps:
  #1. Navigate to the URL: "test.inar-academy.com"
  #2.
  #3.


Feature: Flight Tab

  Background:
    Given the user is on the Inar Academy homepage
    And the user clicks on the Booking link

#  Scenario:
#
#    When the user clicks on the Flights tab
#    Then the user should see that "Find your next flight" message.
#
#  Scenario Outline: Verification of Flights Home Page tabs
#    Given The user is on the flights page
#
#    When The user clicks on the round way radio
#    And The user selects departure as a "<departure country>"
#    And The user selects return as a "<return country>"
#    And The user selects departure date as "<departure date>" and return date as "<return date>"
#    And The user determines adult number as "<adult number>" and children number as  "<children number>"
#    And The user clicks on the search flights button
#
#    Then The user should see that "Find your next flight" header text message is displayed
#    And The user should see that only list of "<departure country>" and "<return country>" are displayed
#    And The user should see that only list of "<departure date>" is displayed
#    And The user should see that only round way on the tickets
#    Examples:
#      | departure country | return country | departure date | return date | adult number | children number |
#      | USA               | Italy          | 5              | 12          | 20           | 15              |
#      | Italy             | USA            | 2              | 5           | 4            | 1               |
#
#
#  Scenario:
#    Given The user is on the flights page
#
#    When The user clicks on the round way radio
#    And The user selects departure as a "USA"
#    And The user selects return as a "Italy"
#    And The user selects departure date as "5" and return date as "12"
#    And The user determines adult number as "2" and children number as  "3"
#    And The user clicks on the search flights button
#    And The user clicks on the cheapest tab
#    Then The user should see that fees of tickets are arranged from cheapest to highest
#
#    When The user click on fastest tab
#    Then The user should see that times of flights are arranged from fastest to slowest
#
#    When The user selects from checkbox "Economy" in the cabin class
#    Then The user should see only "Economy" on the tickets


#  Scenario Outline:
#    Given The user is on the flights page
#
#    When The user clicks on the round way radio
#    And The user selects departure as a "<departure country>"
#    And The user selects return as a "<arrival country>"
#    And The user selects departure date as "12" and return date as "15"
#    And The user determines adult number as "<adult number>" and children number as  "<children number>"
#    And The user clicks on the search flights button
#    And The user selects from checkbox "Business" in the cabin class
#    And The user click on cheapest tab
#    And The user click on cheapest ticket
#    Then The user should see return ticket button"Select Return Ticket"
#    When The user click on fastest tab
#    Then The user should see that times of flights are arranged from fastest to slowest
#
#    When The user selects return ticket on the fastest flight
#    Then The user should see title of the result page "Choose your fare"
#    And The user should see that adult number as "<adult number>" and children number as  "<children number>" on the result page
#    And The user should see that only  "<departure country>" and  "<arrival country>" are displayed
#    Examples:
#      | departure country | arrival country | adult number | children number |
#      | USA               | Italy           | 3            | 2               |


#    And The user should see that the ticket prices as expected on the mains

#  Scenario:
#    Given The user is on the flights page
#
#    When The user clicks on the round way radio
#    And The user selects departure as a "USA"
#    And The user selects return as a "Italy"
#    And The user selects departure date as "12" and return date as "15"
#    And The user determines adult number as "3" and children number as  "2"
#    And The user clicks on the search flights button
#    And The user selects from checkbox "Business" in the cabin class
#    And The user click on cheapest tab
#    And The user click on cheapest ticket
#    And The user click on fastest tab
#    And The user selects return ticket on the fastest flight
#
#    When The user click on Select Who's flying button
#
#    Then The user should see that "Who's flying?" text
#    And The user should see that only "USA to Italy" and "Italy to USA" are displayed
#    And The user should see that only "Round Trip" on the tickets


  Scenario:
    Given The user is on the flights page
    And The user clicks on the round way radio
    And The user selects departure as a "<departure country>"
    And The user selects return as a "<return country>"
    And The user selects departure date as "<departure date>" and return date as "<return date>"
    And The user determines adult number as "<adult number>" and children number as  "<children number>"
    And The user clicks on the search flights button
    And The user selects from checkbox "<type of cabin class>" in the cabin class
    And The user click on cheapest tab
    And The user click on cheapest ticket
    And The user click on fastest tab
    And The user selects return ticket on the fastest flight
    And The user click on "Select Who's flying" button

    When The user enters  as "<contact mail>" email and  as "<phone number>" phone number
    And The user enters as "<first name>" and as "<last name>"
    And The user select gender
    And The user select birth of date
    And The user clicks on select extras button

    Then The user should see "Extras For Your Flight" text

#  Scenario:
#    Given The user is on the flights page
#    And The user clicks on the round way radio
#    And The user selects departure as a "<departure country>"
#    And The user selects return as a "<return country>"
#    And The user selects departure date as "<departure date>" and return date as "<return date>"
#    And The user determines adult number as "<adult number>" and children number as  "<children number>"
#    And The user clicks on the search flights button
#    And The user selects from checkbox "<type of cabin class>" in the cabin class
#    And TThe user click on cheapest tab
#    And The user click on cheapest ticket
#    And The user click on fastest tab
#    And The user selects return ticket on the fastest flight
#    And The user click on "Select Who's flying" button
#    And The user enters  as "<contact mail>" email and  as "<phone number>" phone number
#    And The user enters as "<first name>" and as "<last name>"
#    And The user select gender
#    And The user select birth of date
#    And The user clicks on select extras button
#
#    When The user selects as "<meal>"
#    Then The user should see price of meal should have been added to total price
#
#
#  Scenario:
#    Given The user is on the flights page
#    And The user clicks on the round way radio
#    And The user selects departure as a "<departure country>"
#    And The user selects return as a "<return country>"
#    And The user selects departure date as "<departure date>" and return date as "<return date>"
#    And The user determines adult number as "<adult number>" and children number as  "<children number>"
#    And The user clicks on the search flights button
#    And The user selects from checkbox "<type of cabin class>" in the cabin class
#    And TThe user click on cheapest tab
#    And The user click on cheapest ticket
#    And The user click on fastest tab
#    And The user selects return ticket on the fastest flight
#    And The user click on "Select Who's flying" button
#    And The user enters  as "<contact mail>" email and  as "<phone number>" phone number
#    And The user enters as "<first name>" and as "<last name>"
#    And The user select gender
#    And The user select birth of date
#    And The user clicks on select extras button
#    And The user selects as "<meal>"
#
#    When The user click on "Go To Checkout" button
#
#    Then The user should see "Cardholder's Name"
#
#  Scenario:
#    Given The user on the check and pay page
#    When The user enter as "<Cardholder's Name>"
#    And The user enter as "<Card Number>"
#    And The user enter as "<Expiration Date>"
#    And The user enter as "<CVV Code>"
#    And The user clicks on "Complete Booking" button
#
#    Then The user should see"Thank you for your booking"
#    And The user should see price of ticket as expected
#
#  Scenario:
#    Given The user on the check and pay page
#    And The user enter as "<Cardholder's Name>"
#    And The user enter as "<Card Number>"
#    And The user enter as "<Expiration Date>"
#    And The user enter as "<CVV Code>"
#    And The user clicks on "Complete Booking" button
#
#    When The user clicks on "Close" button
#    Then The user should see "Find your next stay"text







