@Stabi208
Feature: Check ability to show footer on page that requires live price update incase no internet connection

  Background:
    Given Login page is open

  Scenario Outline:<TCID> : <screen>: Check ability to show footer on page that requires live price update incase no internet connection
    And Login with account "<HolderUser>"
    And Go to screen "<screen>"
    And Turn off Wifi mode
    Then Verify value footer is "<message>"
    Examples:
      |TCID|HolderUser|screen|message|
      |TC_Disconnect_001|validAccountHolder|Watchlist|Footer_DisConnectInternet|
      |TC_Disconnect_001|validAccountForRobo|Trade|Footer_DisConnectInternet|
      |TC_Disconnect_001|validAccountForRobo|TradeStock|Footer_DisConnectInternet|
      |TC_Disconnect_001|validAccountForRobo|TradeCFD|Footer_DisConnectInternet|
      |TC_Disconnect_001|validAccountForRobo|TradeRobo|Footer_DisConnectInternet|