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
    Then The user face with correct "<pickup_date>","<drop-off_date>" and "<pick up location>" in Car Rental filtering page
    Examples:
      | pick up location | pickup_date | pickup_hour | drop-off_date | drop_hour |
      | Heathrow Airport | 2024-03-15  | 08:00       | 2024-03-25    | 20:00     |

  Scenario Outline: Validate that the user see error message when the user enter invalid inputs
    When The user clicks on the Booking link
    And The user clicks on the Car rentals tab
    And The user enter "<pick up location>","<pickup_date>","<pickup_hour>","<drop-off_date>" and "<drop_hour>"
    And The user clicks on the search button
    Then The user face with "Please select a valid drop-off date after the pickup date and today."
    Examples:
      | pick up location | pickup_date | pickup_hour | drop-off_date | drop_hour |
      | Heathrow Airport | 2023-02-02  | 08:00       | 2024-03-25    | 12:00     |
      | Heathrow Airport | 2024-03-15  | 09:00       | 2023-03-25    | 12:00     |
      | Heathrow Airport | 2024-03-15  | 12:00       | 2024-03-15    | 08:00     |

  Scenario Outline: Validate the Price Range check-boxes are selectable
    When The user clicks on the Booking link
    And The user clicks on the Car rentals tab
    And The user clicks on the search button
    And The user selects the "<price_range>"
    Then The user validates that "<price_range>" is selected
    When The user selects the "<car_specs>"
    Then The user validates that "<car_specs>" is selected
    When The user selects the "<transmission>"
    Then The user validates that "<transmission>" is selected
    When The user selects the "<car_category>"
    Then The user validates that "<car_category>" is selected
    Examples:
      | price_range | car_category | car_specs        | transmission |
      | 0-50        | Small        | Air Conditioning | Automatic    |
      | 200-250     | Large        | GPS Navigation   | Manual       |

  Scenario Outline: Validate that the car in the filtering page matches with entered criteria
    When The user clicks on the Booking link
    And The user clicks on the Car rentals tab
    And The user clicks on the search button
    And The user enters "<pick_up_location>","<price_range>","<car_spec>","<transmission>" and "<car_category>"
    And The user clicks on search button in filtering page
    Then The user validates that "<pick_up_location>","<price_range>","<transmission>" and "<car_category>" matches with displayed cars' information
    Examples:
      | pick_up_location | price_range | car_spec               | transmission | car_category |
      | Heathrow Airport | 0-50        | Bluetooth Connectivity | Manual       | Small        |
      | Central Park     | 50-100      | Leather Seats          | Manual       | Medium       |
      | Grand Bazaar     | 100-150     | Sunroof                | Automatic    | Large        |
      | Taj Mahal        | 50-100      | Keyless Entry          | Automatic    | Minivan      |
      | Machu Picchu     | 50-100      | Backup Camera          | Automatic    | SUV          |

  Scenario: Validate that sort buttons are functioning properly
    When The user clicks on the Booking link
    And The user clicks on the Car rentals tab
    And The user clicks on the search button
    And The user clicks on price highest sort button
    Then The user validates that cars are sorted from highest to lowest
    When The user clicks on price lowest sort button
    Then The user validates that cars are sorted from lowest to highest

  Scenario Outline: Validate that the chosen car in the filtering page can be booked successfully with valid credentials
    When The user clicks on the Booking link
    And The user clicks on the Car rentals tab
    And The user clicks on the search button
    And The user enters "<pick_up_location>","<price_range>","<car_spec>","<transmission>" and "<car_category>"
    And The user clicks on search button in filtering page
    And The user clicks View Dial button of the #1 element
    Then The user validates that the name of selected car is true
    And The user validates that "<pick_up_location>", price, "<transmission>" and "<car_category>" of displayed car in detail_page matches with the selected car in filtering_page
    And The user validates that total_price calculation is true
    When The user clicks on the What is covered button
    Then The user validates that total_price is increased by amount total_cover_price
    When The user clicks on go_to_book button
    Then The user validates that "<pick_up_location>","<transmission>" and "<car_category>" of displayed car in checkout_page matches with the selected car in detail_page
    When The user enters user information "<firstName>","<lastName>","<phoneNumber>","<country>","<address>","<city>", "<postalCode>","<cardholderName>","<cardNumber>","<expirationDate>","<cvv>"
    And The user clicks on the Book_now button
    Then The user validates that booking_successful "Thank you for your booking ! <firstName> <lastName>" is displayed
    And The user validates that "<pick_up_location>" is true
    When The user clicks on the close button
    Then The user sees Booking Home page
    Examples:
      | pick_up_location | price_range | car_spec      | transmission | car_category | firstName | lastName | cardholderName | phoneNumber | cardNumber       | country | address           | city   | postalCode | expirationDate | cvv |
      | Central Park     | 50-100      | Leather Seats | Manual       | Medium       | Gurol     | Gokyar   | Inar Academy   | 5674567839  | 1234123412341234 | Turkey  | Köroğlu mahallesi | Ankara | 06360      | 06/28          | 324 |

  Scenario Outline: Validate true error messages are displayed in checkout page
    When The user clicks on the Booking link
    And The user clicks on the Car rentals tab
    And The user clicks on the search button
    And The user enters "Heathrow Airport","0-50","Manual" and "Small"
    And The user clicks on search button in filtering page
    And The user clicks View Dial button of the #1 element
    And The user clicks on go_to_book button
    When The user enters user information "<firstName>","<lastName>","<phoneNumber>","<country>","<address>","<city>", "<postalCode>","<cardholderName>","<cardNumber>","<expirationDate>","<cvv>"
    Then The user validates that "<true_error_message>" of the "<element_name>" is displayed
    Examples:
      | firstName  | lastName | phoneNumber | country | address  | city   | postalCode | cardholderName | cardNumber       | expirationDate | cvv | element_name    | true_error_message                                            |
      |            | Akturk   | 1234567891  | Turkey  | A street | Ankara | 12345      | cello          | 1234123412341234 | 06/28          | 324 | first name      | First name is required                                        |
      | Celalettin |          | 1234567891  | Turkey  | A street | Ankara | 12345      | cello          | 1234123412341234 | 06/28          | 324 | last name       | Last name is required                                         |
      | Celalettin | Akturk   | 12          | Turkey  | A street | Ankara | 12345      | cello          | 1234123412341234 | 06/28          | 324 | phone number    | Invalid phone number                                          |
      | Celalettin | Akturk   | 1234567891  |         | A street | Ankara | 12345      | cello          | 1234123412341234 | 06/28          | 324 | country         | Country is required                                           |
      | Celalettin | Akturk   | 1234567891  | Turkey  |          | Ankara | 12345      | cello          | 1234123412341234 | 06/28          | 324 | address         | Address is required                                           |
      | Celalettin | Akturk   | 1234567891  | Turkey  | A street |        | 12345      | cello          | 1234123412341234 | 06/28          | 324 | city            | City is required                                              |
      | Celalettin | Akturk   | 1234567891  | Turkey  | A street | Ankara |            | cello          | 1234123412341234 | 06/28          | 324 | postal code     | Postal code is required                                       |
      | Celalettin | Akturk   | 1234567891  | Turkey  | A street | Ankara | 12345      | cello          | 123              | 06/28          | 324 | card number     | Invalid card number. Please enter a valid card number.        |
      | Celalettin | Akturk   | 1234567891  | Turkey  | A street | Ankara | 12345      | cello          | 1234123412341234 | ab/12          | 324 | expiration date | Invalid expiration date. Please use the MM/YY format.         |
      | Celalettin | Akturk   | 1234567891  | Turkey  | A street | Ankara | 12345      | cello          | 1234123412341234 | 06/28          | 1   | cvv/cvc         | Invalid CVV/CVC code. Please enter a valid 3 or 4 digit code. |


