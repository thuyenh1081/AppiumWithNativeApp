#@Stabi208
Feature: Check light theme mode

  Background: Check light theme mode
    Given Login page is open

  Scenario Outline: <TCID> : Check light theme mode
    And Login with account "<HolderUser>"
    And Change app to light theme mode
    And Go to screen "<screen>"
    And Switch to landscape mode for the "<screen>"
    And Turn off Wifi mode
    And Touch the snapshort of app
    Then Verify value footer is "<message>"
    Examples:
      |TCID|HolderUser|screen|message|
      |TC_Disconnect_017|validAccountForRobo|Watchlist|Footer_DisConnectInternet|