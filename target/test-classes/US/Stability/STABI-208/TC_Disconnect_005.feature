#@Stabi208
Feature: Check ability to show footer on page when user tap on other tabs on screen incase no internet connection

  Background:
    Given Login page is open

  Scenario Outline: <TCID> : <screen>: Check ability to show footer on page when user tap on other tabs on screen incase no internet connection
    And Login with account "<HolderUser>"
    And Go to screen "<screen>"
    And Turn off Wifi mode
    And Tap on another tab on the "<screen>"
    Then Verify value footer is "<message>"
    Examples:
      |TCID|HolderUser|screen|message|
      |TC_Disconnect_005|validAccountForRobo|WatchlistSetting|Footer_DisConnectInternet|