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

    When the user clicks on the Flights tab
  Scenario:
    Then the user should see that "Find your next flight" message.