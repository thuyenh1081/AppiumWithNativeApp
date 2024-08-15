#@Stabi208
Feature: Check ability to show footer on page when user scroll down to load more data incase no internet connection
  Background:
    Given Login page is open

  Scenario Outline: <TCID> : <screen>: Check ability to show footer on page when user scroll down to load more data incase no internet connection
    And Login with account "<HolderUser>"
    And Go to screen "<screen>"
    And Turn off Wifi mode
    And Scroll down to load more data screen "<screen>"
    Then Verify value footer is "<message>"
  Examples:
    |TCID|HolderUser|screen|message|
    |TC_Disconnect_003|validAccountForRobo|Watchlist|Footer_DisConnectInternet|
