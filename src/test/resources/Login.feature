Feature: Web Login
  @login
  Scenario Outline: User should be able to login with valid credentials
    Given I invoke chrome browser using webDriverManager
#    Given I login into "applicationA" application
    And click on the "<linkName>" link

    Examples:
      | linkName            |
      | Add/Remove Elements |
      | Basic Auth          |



