#Author: Team-1
#Date: 2024-01-27
#Description: This is a test case for smoke test

#Test Case: car_rental
#Test Title: Validate the Car Rental Tab Includes Search Bar for Car Rental

#Test Steps:
  #1. Navigate to the URL: "test.inar-academy.com"
  #2.
  #3.

@car_rental
Feature: Car Rental Tab

  Background:
    Given The user navigates to the Inar Academy Home page


  Scenario: Validate that user is on the Booking home page
    When The user clicks on the Booking link
    Then The user sees Booking Home page

  Scenario: Validate that Car Rentals head is visible
    When The user clicks on the Booking link
    And The user clicks on the Car rentals tab
    Then The user validates that "Rent a Car for Your Trip" message is visible

  Scenario Outline: Validate the information in the booking home page correctly matches with the information in the Car rental page
    When The user clicks on the Booking link
    And The user clicks on the Car rentals tab
    And The user enter "<pick up location>","<pickup_date>","<pickup_hour>","<drop-off_date>" and "<drop_hour>"
    And The user clicks on the search button
    Then The user face with "<pickup_date>","<drop-off_date>" and "<pick up location>" in Car Rental filtering page
    Examples:
      | pick up location | pickup_date | pickup_hour | drop-off_date | drop_hour |
      | Heathrow Airport | 2024-01-28  | 01:00       | 2024-01-31    | 09:00     |


  Scenario://TODO olumsuz senaryo date pickerı anladıktan sonra!!


  Scenario Outline: Validate the Price Range check-boxes are selectable
    When The user clicks on the Booking link
    And The user clicks on the Car rentals tab
    And The user clicks on the search button
    And The user clicks on the "<price_range>" button
    Then The user validates that "<price_range>" is selected

    When The user clicks on the "<car_specs>" button
    Then The user validates that "<car_specs>" is selected

    When The user clicks on the "<transmission>" button
    Then The user validates that "<transmission>" is selected

    When The user clicks on the "<car_category>" button
    Then The user validates that "<car_category>" is selected
    Examples:
      | price_range | car_category | car_specs        | transmission |
      | $0-50       | Small        | Air Conditioning | Automatic    |
      | $200-250    | Large        | GPS Navigation   | Manual       |


  Scenario Outline: Validate that the car in the filtering page matches with entered criteria
    When When The user clicks on the Booking link
    And The user clicks on the Car rentals tab
    And The user clicks on the search button
    And The user enters "<pick_up_location>","<price_rance>","<car_spec>","<transmission>" and "<car_category>"
    And The user clicks on search button
    Then The user validates that "<pick_up_location>" matches with displayed cars' information
    And The user validates that "<price_rance>" matches with displayed cars' information
    And The user validates that "<car_spec>" matches with displayed cars' information
    And The user validates that "<transmission>" matches with displayed cars' information
    And The user validates that "<car_category>" matches with displayed cars' information

    When The user clicks on price highest sort button
    Then The user validates that cars are sorted from highest to lowest

    When The user clicks on price lowest sort button
    Then The user validates that cars are sorted from lowest to highest

    Examples:
      | pick_up_location | price_rance | car_spec               | transmission | car_category |
      | Heathrow Airport | $0-50       | Bluetooth Connectivity | Manual       | Small        |
      | Central Park     | $50-100     | Leather Seats          | Manual       | Medium       |
      | Grand Bazaar     | $100-150    | Sunroof                | Automatic    | Large        |
      | Taj Mahal        | $50-100     | Keyless Entry          | Automatic    | Minivan      |
      | Machu Picchu     | $50-100     | Backup Camera          | Automatic    | SUV          |


    Scenario: Validate that the chosen car in the filtering page matches with displayed car in the detail page
      When When The user clicks on the Booking link
      And The user clicks on the Car rentals tab
      And The user clicks on the search button
      And The user clicks View Dial button of the first element
      Then The user validates that displayed car matches with the selected car

