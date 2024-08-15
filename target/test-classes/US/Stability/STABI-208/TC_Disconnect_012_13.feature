#@Stabi208
Feature: Check ability to auto recheck internet connection every 15s

  Background:
    Given Login page is open

  Scenario Outline: <TCID> : Check ability to auto recheck internet connection every 15s
    And Login with account "<HolderUser>"
    And Go to screen "<screen>"
    And Turn off Wifi mode
    And Touch the snapshort of app
    Then Verify value footer is "<message>"
    And Wait for try connecting internet
    Then Verify value footer is "<message2>"
    And Wait for "5" second
    Then Verify value footer is "<message>"
    Examples:
    |TCID|HolderUser|screen|message|message2|
  |TC_Disconnect_012_13|validAccountForRobo|Watchlist|Footer_DisConnectInternet|ConnectingMsg|