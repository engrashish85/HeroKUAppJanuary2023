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

  @basicAuth
  Scenario: User should be able to login with valid credentials
    Given I invoke Basic Auth URL using webDriverManager
    And click on the "Basic Auth " link
    Then I implement Basic Auth

  @basicAuthCDT
  Scenario: User should be able to login with valid credentials
    Given I implement Basic Auth using ChromeDevTools



