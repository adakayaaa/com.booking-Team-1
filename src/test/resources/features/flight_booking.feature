#Author: Team-1
#Date: 2024-01-27
#Description: This is a test case for smoke test

#Test Case: flight_booking
#Test Title: Validate the Flight Tab Includes Search Bar for Flight
@example
Feature: Flight Tab

  Background:
    Given the user is on the Inar Academy homepage
    And the user clicks on the Booking link

  Scenario:Verification of click flights tab

    When the user clicks on the Flights tab
    Then the user should see that "Find your next flight" message.

  Scenario Outline: Verification of Flights Home Page tabs
    Given The user is on the flights page

    When The user clicks on the round way radio
    And The user selects departure as a "<departure country>"
    And The user selects return as a "<return country>"
    And The user selects departure date as "<departure date>" and return date as "<return date>"
    And The user determines adult number as "<adult number>" and children number as  "<children number>"
    And The user clicks on the search flights button

    Then The user should see that "Find your next flight" header text message is displayed
    And The user should see that only list of "<departure country>" and "<return country>" are displayed
    And The user should see that only list of "<departure date>" is displayed
    And The user should see that only round way on the tickets
    Examples:
      | departure country | return country | departure date | return date | adult number | children number |
      | USA               | Italy          | 5              | 12          | 20           | 15              |
      | Italy             | USA            | 2              | 5           | 4            | 1               |


  Scenario:Verification of Flights Filtering  Page
    Given The user is on the flights page

    When The user clicks on the round way radio
    And The user selects departure as a "USA"
    And The user selects return as a "Italy"
    And The user selects departure date as "5" and return date as "12"
    And The user determines adult number as "2" and children number as  "3"
    And The user clicks on the search flights button
    And The user clicks on the cheapest tab
    Then The user should see that fees of tickets are arranged from cheapest to highest

    When The user click on fastest tab
    Then The user should see that times of flights are arranged from fastest to slowest

    When The user selects from checkbox "Business" in the cabin class
    Then The user should see only "Business" on the tickets


  Scenario Outline:Verification of Flights Details Page
    Given The user is on the flights page

    When The user clicks on the round way radio
    And The user selects departure as a "<departure country>"
    And The user selects return as a "<arrival country>"
    And The user selects departure date as "12" and return date as "15"
    And The user determines adult number as "<adult number>" and children number as  "<children number>"
    And The user clicks on the search flights button
    And The user selects from checkbox "Business" in the cabin class
    And The user click on cheapest tab
    And The user click on cheapest ticket
    Then The user should see return ticket button"Select Return Ticket"
    When The user click on fastest tab
    Then The user should see that times of flights are arranged from fastest to slowest

    When The user selects return ticket on the fastest flight
    Then The user should see title of the result page "Choose your fare"
    And The user should see that adult number as "<adult number>" and children number as  "<children number>" on the result page
    And The user should see that only  "<departure country>" and  "<arrival country>" are displayed
    Examples:
      | departure country | arrival country | adult number | children number |
      | USA               | Italy           | 3            | 2               |
      | USA               | Italy           | 1            | 1               |
      | Italy             | USA             | 4            | 5               |


#    And The user should see that the ticket prices as expected on the mains

  Scenario Outline:Verification of Flights Extra1 Page
    Given The user is on the flights page

    When The user clicks on the round way radio
    And The user selects departure as a "USA"
    And The user selects return as a "Italy"
    And The user selects departure date as "12" and return date as "15"
    And The user determines adult number as "1" and children number as  "0"
    And The user clicks on the search flights button
    And The user selects from checkbox "Business" in the cabin class
    And The user click on cheapest tab
    And The user click on cheapest ticket
    And The user click on fastest tab
    And The user selects return ticket on the fastest flight
    And The user click on Select Who's flying button

    Then The user should see that "Who's flying?" text
    And The user should see that only "USA to Italy" and "Italy to USA" are displayed
    And The user should see that only "Round Trip" on the tickets
    And The user should see that taxes are calculated truly

    When The user enters  as "<contact mail>" email and  as "<phone number>" phone number
    And The user enters as "<first name>" first name and as "<last name>" last name
    And The user select gender as "<gender>" and birthdate as "<year>" year and "<month>" month and "<day>" day
    And The user clicks on select extras button

    Then The user should see "Extras For Your Flight" text
    Examples:
      | contact mail    | phone number | first name  | last name | gender | year | month | day |
      | emir@gmail.com  | 5474567896   | Emir        | Uyanık    | Male   | 1987 | 7     | 4   |
      | kaya@gmail.com  | 5475469896   | Ada         | Kaya      | Female | 1996 | 8     | 24  |
      | yusuf@gmail.com | 5324529076   | Yusul Bilal | Cetin     | Male   | 2005 | 1     | 2   |


  Scenario Outline:Verification of Flights Extra2 Page
    Given The user is on the flights page

    When The user clicks on the round way radio
    And The user selects departure as a "USA"
    And The user selects return as a "Italy"
    And The user selects departure date as "12" and return date as "15"
    And The user determines adult number as "1" and children number as  "0"
    And The user clicks on the search flights button
    And The user selects from checkbox "Business" in the cabin class
    And The user click on cheapest tab
    And The user click on cheapest ticket
    And The user click on fastest tab
    And The user selects return ticket on the fastest flight
    And The user click on Select Who's flying button
    And The user enters  as "<contact mail>" email and  as "<phone number>" phone number
    And The user enters as "<first name>" first name and as "<last name>" last name
    And The user select gender as "<gender>" and birthdate as "<year>" year and "<month>" month and "<day>" day
    And The user clicks on select extras button

    When The user selects as "<meal>" meal
    Then The user should see price of "<meal>" meal should have been added to total price

    When The user click on go to checkout button
    Then The user should see that "Cardholder's Name" title of checkout page

    Examples:
      | contact mail   | phone number | first name | last name | gender | year | month | day | meal       |  |
      | emir@gmail.com | 5474567896   | Emir       | Uyanık    | Male   | 1987 | 7     | 4   | Halal Meal |  |
      | kaya@gmail.com | 5932543217   | Ada        | Kaya      | Female | 2000 | 12    | 8   | Halal Meal |  |


  Scenario Outline:Verification of Flights Check Out Page
    Given The user is on the flights page
    When The user clicks on the round way radio
    And The user selects departure as a "USA"
    And The user selects return as a "Italy"
    And The user selects departure date as "12" and return date as "15"
    And The user determines adult number as "1" and children number as  "0"
    And The user clicks on the search flights button
    And The user selects from checkbox "Business" in the cabin class
    And The user click on cheapest tab
    And The user click on cheapest ticket
    And The user click on fastest tab
    And The user selects return ticket on the fastest flight
    And The user click on Select Who's flying button
    And The user enters  as "emir@gmail.com" email and  as "5474567896" phone number
    And The user enters as "Emir" first name and as "Uyanık" last name
    And The user select gender as "Male" and birthdate as "1996" year and "7" month and "4" day
    And The user clicks on select extras button
    And The user click on go to checkout button
    And The user enter as "<Cardholder's Name>" cardholder's name
    And The user enter as "<Card Number>" card number
    And The user enter as "<Expiration Date>" expiration date
    And The user enter as "<CVV Code>" cvv code
    And The user clicks on Complete Booking button

    Then The user should see "Thank you for your booking" message and "<Cardholder's Name>" name

    When The user clicks on Close button
    Then The user should see "Find your next stay"text
    Examples:
      | Cardholder's Name | Card Number      | Expiration Date | CVV Code |
      | Emir Uyanık       | 1234567812345678 | 12/25           | 444      |
      | Yusuf Bilal Cetin | 5476983254675234 | 08/29           | 234      |
      | Ada Kaya          | 1234566543217654 | 10/30           | 432      |

  Scenario Outline:Verification of Flights Booking Page with Negative Scenarios
    Given The user is on the flights page

    When The user clicks on the round way radio
    And The user selects departure as a "USA"
    And The user selects return as a "Italy"
    And The user selects departure date as "12" and return date as "15"
    And The user determines adult number as "1" and children number as  "0"
    And The user clicks on the search flights button
    And The user selects from checkbox "Business" in the cabin class
    And The user click on cheapest tab
    And The user click on cheapest ticket
    And The user click on fastest tab
    And The user selects return ticket on the fastest flight
    And The user click on Select Who's flying button

    When The user enters  as invalid "<contact mail>" email and  as invalid "<phone number>" phone number
    And The user enters as "<first name>" first name and as "<last name>" last name
    And The user select gender as "<gender>" and birthdate as "<year>" year and "<month>" month and "<day>" day
    And The user clicks on select extras button

    Then The user should see  alert message
    Examples:
      | contact mail   | phone number | first name | last name | gender | year | month | day |
      | e              | 5474567896   | Emir       | Uyanık    | Male   | 1987 | 7     | 4   |
      | emir@gmail.com | 54           | Emir       | Uyanık    | Male   | 1987 | 7     | 4   |









