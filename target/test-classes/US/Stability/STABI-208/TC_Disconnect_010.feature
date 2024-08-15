#@Stabi208
Feature: Check ability to show footer when session expired and user try to access app incase no internet connection

  Background:
    Given Login page is open

  Scenario Outline: <TCID> : Check ability to show footer when session expired and user try to access app incase no internet connection
    And Login with account "<HolderUser>"
    And Turn off Wifi mode
    And Wait for session timeout
    And Go to screen "<screen>"
    Then Verify value footer is "<message>"
    Examples:
      |TCID|HolderUser|screen|message|
      |TC_Disconnect_010|validAccountForRobo|WatchlistSetting|Footer_DisConnectInternet|