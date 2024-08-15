#@Stabi208
Feature: Check ability to show footer when user unlock device incase no internet connection after lock it for awhile

  Background:
    Given Login page is open

  Scenario Outline: <TCID> : Has not login yet. Check ability to show footer when user unlock device incase no internet connection after lock it for awhile
    And Enter Login textBox Account as "0000000"
    And Enter Login textBox Pass as "Phillip1"
    And Lock device
    And Turn off Wifi mode
    And Touch the snapshort of app
    Then Verify value footer is "<message>"
    Examples:
      |TCID|HolderUser|screen|message|
      |TC_Disconnect_009|validAccountForRobo|Login|Footer_DisConnectInternet|

#  Scenario Outline: <TCID> : Check ability to show footer when user unlock device incase no internet connection after lock it for awhile
#    And Login with account "<HolderUser>"
#    And Go to screen "<screen>"
#    And Lock device
#    And Turn off Wifi mode
#    And Touch the snapshort of app
#    Then Verify value footer is "<message>"
#    Examples:
#      |TCID|HolderUser|screen|message|
#      |TC_Disconnect_009|validAccountForRobo|Watchlist|Footer_DisConnectInternet|