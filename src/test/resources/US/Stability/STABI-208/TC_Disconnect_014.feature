#@Stabi208
Feature: Check ability to refresh the screen after internet connection is back to available
  Background:
    Given Login page is open

#    sao không thấy có action refresh TCID
  Scenario Outline: <TCID> : Check ability to refresh the screen after internet connection is back to available
    And Login with account "<HolderUser>"
    And Go to screen "<screen>"
    And Turn off Wifi mode
    Then Verify value footer is "<message>"
    And Turn on Wifi mode
    And Touch the snapshort of app
    Then Verify value footer is "<message2>"

    Examples:
      ||HolderUser|screen|message|message2|
      |TC_Disconnect_014|validAccountForRobo|Login|Footer_DisConnectInternet|BackOnlineMsg|


