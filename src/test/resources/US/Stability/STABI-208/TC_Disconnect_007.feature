#@Stabi208
Feature: Check ability to show footer when user foreground app incase no internet connection after background app for awhile

  Background:
    Given Login page is open

  Scenario Outline: <TCID> : Check ability to show footer when user foreground app incase no internet connection after
  background app for awhile
    And Login with account "<HolderUser>"
    And Go to screen "<screen>"
    And Background the app
    And Turn off Wifi mode
    And Touch the snapshort of app
    Then Verify value footer is "<message>"
    Examples:
      |TCID|HolderUser|screen|message|
      |TC_Disconnect_007|validAccountForRobo|Watchlist|Footer_DisConnectInternet|