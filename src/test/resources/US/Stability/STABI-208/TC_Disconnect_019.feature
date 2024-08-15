#@Stabi208

Feature:Check  ability to show the disconnect screen when user not yet logged in opens app with no internet connection

  Background: Check light theme mode
    Given Login page is open

  Scenario Outline: Check  ability to show the disconnect screen when user not yet logged in opens app with no internet connection
    And Login with account "<HolderUser>"
    And Logout
    And Terminate the app
    And Turn off Wifi mode
    And Kill app
    Then Verify the display of Disconnect is "true"
    Examples:
      |HolderUser|
