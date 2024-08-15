#@Stabi208
Feature: Check ability to show footer on page when user interact with elements on page that call API but not init a new screen incase no internet connection

  Background:
    Given Login page is open

  Scenario Outline: <TCID> : <screen>: Check ability to show footer on page when user interact with elements on page that call API but not init a new screen incase no internet connection
    And Login with account "<HolderUser>"
    And Go to screen "<screen>"
    And Turn off Wifi mode
    And Tap on an element of "<screen>" that require call API but not init a new screen
    Then Verify value footer is "<message>"
    Examples:
    |TCID|HolderUser|screen|message|
    |TC_Disconnect_006|validAccountForRobo|Watchlist|Footer_DisConnectInternet|