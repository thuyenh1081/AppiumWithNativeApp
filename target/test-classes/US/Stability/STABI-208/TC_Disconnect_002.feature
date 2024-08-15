#@Stabi208
Feature: Check ability to show footer on page when user from the top page pull down to refresh incase no internet connection
  Background:
    Given Login page is open

  Scenario Outline: <TCID> : <screen>: Check ability to show footer on page when user from the top page pull down to refresh incase no internet connection
    And Login with account "<HolderUser>"
    And Go to screen "<screen>"
    And Turn off Wifi mode
    And Pull down the page "<screen>"
    Then Verify value footer is "<message>"
    Examples:
      |TCID|HolderUser|screen|message|
      |TC_Disconnect_002|validAccountForRobo|Market|Footer_DisConnectInternet|

