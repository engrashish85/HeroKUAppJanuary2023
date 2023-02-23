Feature: Add Book

  @addBook
  Scenario: User should be able to add book
    Given the user is able to add book successfully
    Then the user is able to convert json to maps
    Then the user is able to retrieve value from json