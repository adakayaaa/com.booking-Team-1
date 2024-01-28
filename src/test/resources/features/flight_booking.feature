#Author: Team-1
#Date: 2024-01-27
#Description: This is a test case for smoke test

#Test Case: flight_booking
#Test Title: Validate the Flight Tab Includes Search Bar for Flight

#Test Steps:
  #1. Navigate to the URL: "test.inar-academy.com"
  #2.
  #3.

@example
Feature: Flight Tab

  Background:
    Given the user is on the Inar Academy homepage
    And the user clicks on the Booking link

  Scenario:

    When the user clicks on the Flights tab

    Then the user should see that "Find your next flight" message.

  Scenario:
    Given The user is on the flights page

    When The user clicks on the round way radio
    And The user selects departure as a "<departure country>"
    And The user selects return as a "<return country>"
    And The user selects departure date as "<departure date>" and return date as "<return date>"
    And The user determines adult number as "<adult number>" and children number as  "<children number>"
    And The user clicks on the search flights button

    Then The user should see that only list of departure countries and return countries are displayed
    And The user should see that only list of departure date
    And The user should see that only round way on the tickets

  Scenario:
    Given The user is on the flights page
    And The user clicks on the round way radio
    And The user selects departure as a "<departure country>"
    And The user selects return as a "<return country>"
    And The user selects departure date as "<departure date>" and return date as "<return date>"
    And The user determines adult number as "<adult number>" and children number as  "<children number>"
    And The user clicks on the search flights button

    When The user selects from checkbox "<type of cabin class>" in the cabin class

    Then The user should see only "<type of cabin class>" on the tickets

  Scenario:
    Given The user is on the flights page
    And The user clicks on the round way radio
    And The user selects departure as a "<departure country>"
    And The user selects return as a "<return country>"
    And The user selects departure date as "<departure date>" and return date as "<return date>"
    And The user determines adult number as "<adult number>" and children number as  "<children number>"
    And The user clicks on the search flights button
    And The user selects from checkbox "<type of cabin class>" in the cabin class

    When The user clicks on the cheapest tab

    Then The user should see that fees of tickets are arranged from cheapest to highest


  Scenario:
    Given The user is on the flights page
    And The user clicks on the round way radio
    And The user selects departure as a "<departure country>"
    And The user selects return as a "<return country>"
    And The user selects departure date as "<departure date>" and return date as "<return date>"
    And The user determines adult number as "<adult number>" and children number as  "<children number>"
    And The user clicks on the search flights button
    And The user selects from checkbox "<type of cabin class>" in the cabin class
    And The user clicks on the cheapest tab

    When The user click on cheapest ticket

    Then The user should see that select return ticket button


  Scenario:
    Given The user is on the flights page
    And The user clicks on the round way radio
    And The user selects departure as a "<departure country>"
    And The user selects return as a "<return country>"
    And The user selects departure date as "<departure date>" and return date as "<return date>"
    And The user determines adult number as "<adult number>" and children number as  "<children number>"
    And The user clicks on the search flights button
    And The user selects from checkbox "<type of cabin class>" in the cabin class
    And TThe user click on cheapest tab
    And The user click on cheapest ticket

    When The user click on fastest tab

    Then The user should see that times of flights are arranged from fastest to slowest

  Scenario:
    Given The user is on the flights page
    And The user clicks on the round way radio
    And The user selects departure as a "<departure country>"
    And The user selects return as a "<return country>"
    And The user selects departure date as "<departure date>" and return date as "<return date>"
    And The user determines adult number as "<adult number>" and children number as  "<children number>"
    And The user clicks on the search flights button
    And The user selects from checkbox "<type of cabin class>" in the cabin class
    And TThe user click on cheapest tab
    And The user click on cheapest ticket

    When The user click on fastest tab
    And The user selects return ticket on the fastest flight

    Then The user should see "Choose your fare"


  Scenario:
    Given The user is on the flights page
    And The user clicks on the round way radio
    And The user selects departure as a "<departure country>"
    And The user selects return as a "<return country>"
    And The user selects departure date as "<departure date>" and return date as "<return date>"
    And The user determines adult number as "<adult number>" and children number as  "<children number>"
    And The user clicks on the search flights button
    And The user selects from checkbox "<type of cabin class>" in the cabin class
    And TThe user click on cheapest tab
    And The user click on cheapest ticket

    And The user click on fastest tab
    And The user selects return ticket on the fastest flight

    When The user click on "Select Who's flying" button

    Then The user should see that " Who's flying" text
    And The user should see that only departure country and return country are displayed
    And The user should see that departure date return date
    And The user should see that only round way on the tickets
    And The user should see that number of passengers is displayed as expected

  Scenario:
    Given The user is on the flights page
    And The user clicks on the round way radio
    And The user selects departure as a "<departure country>"
    And The user selects return as a "<return country>"
    And The user selects departure date as "<departure date>" and return date as "<return date>"
    And The user determines adult number as "<adult number>" and children number as  "<children number>"
    And The user clicks on the search flights button
    And The user selects from checkbox "<type of cabin class>" in the cabin class
    And TThe user click on cheapest tab
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

  Scenario:
    Given The user is on the flights page
    And The user clicks on the round way radio
    And The user selects departure as a "<departure country>"
    And The user selects return as a "<return country>"
    And The user selects departure date as "<departure date>" and return date as "<return date>"
    And The user determines adult number as "<adult number>" and children number as  "<children number>"
    And The user clicks on the search flights button
    And The user selects from checkbox "<type of cabin class>" in the cabin class
    And TThe user click on cheapest tab
    And The user click on cheapest ticket
    And The user click on fastest tab
    And The user selects return ticket on the fastest flight
    And The user click on "Select Who's flying" button
    And The user enters  as "<contact mail>" email and  as "<phone number>" phone number
    And The user enters as "<first name>" and as "<last name>"
    And The user select gender
    And The user select birth of date
    And The user clicks on select extras button

    When The user selects as "<meal>"
    Then The user should see price of meal should have been added to total price


  Scenario:
    Given The user is on the flights page
    And The user clicks on the round way radio
    And The user selects departure as a "<departure country>"
    And The user selects return as a "<return country>"
    And The user selects departure date as "<departure date>" and return date as "<return date>"
    And The user determines adult number as "<adult number>" and children number as  "<children number>"
    And The user clicks on the search flights button
    And The user selects from checkbox "<type of cabin class>" in the cabin class
    And TThe user click on cheapest tab
    And The user click on cheapest ticket
    And The user click on fastest tab
    And The user selects return ticket on the fastest flight
    And The user click on "Select Who's flying" button
    And The user enters  as "<contact mail>" email and  as "<phone number>" phone number
    And The user enters as "<first name>" and as "<last name>"
    And The user select gender
    And The user select birth of date
    And The user clicks on select extras button
    And The user selects as "<meal>"

    When The user click on "Go To Checkout" button

    Then The user should see "Cardholder's Name"

  Scenario:
    Given The user on the check and pay page
    When The user enter as "<Cardholder's Name>"
    And The user enter as "<Card Number>"
    And The user enter as "<Expiration Date>"
    And The user enter as "<CVV Code>"
    And The user clicks on "Complete Booking" button

    Then The user should see"Thank you for your booking"
    And The user should see price of ticket as expected

  Scenario:
    Given The user on the check and pay page
    And The user enter as "<Cardholder's Name>"
    And The user enter as "<Card Number>"
    And The user enter as "<Expiration Date>"
    And The user enter as "<CVV Code>"
    And The user clicks on "Complete Booking" button

    When The user clicks on "Close" button
    Then The user should see "Find your next stay"text







