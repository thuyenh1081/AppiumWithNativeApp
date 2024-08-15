#@Stabi208
Feature: Check ability to show SSTO when session expired and user try to access app incase no internet connection

  Background:
    Given Login page is open

  Scenario Outline: <TCID> : Check ability to show SSTO when session expired and user try to access app incase no internet connection
    And Login with account "<HolderUser>"
    And Go to screen "<screen>"
    And Background the app
    And Turn off Wifi mode
    And Wait for session timeout
    And Turn on Wifi mode
    And Touch the snapshort of app
    Then Verify the display of Popup SessionTimout is "true"
    Examples:
    |TCID|HolderUser|screen|
    |TC_Disconnect_011|validAccountForRobo|Watchlist|