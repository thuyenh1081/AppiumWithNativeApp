#@Stabi208
Feature: Check ability to show footer when user foreground app incase no internet connection after switch to another app

  Background:
    Given Login page is open

  Scenario Outline:<TCID> : Has not login yet. Check ability to show footer when user foreground app incase no internet connection after switch
  to another app
    And Enter Login textBox Account as "0000000"
    And Enter Login textBox Pass as "Phillip1"
    And Open Setting of Device
    And Turn off Wifi mode
    And Touch the snapshort of app
    Then Verify value footer is "<message>"
    Examples:
      |TCID|HolderUser|screen|message|
      |TC_Disconnect_008|validAccountForRobo|Login|Footer_DisConnectInternet|

#  Scenario Outline:<TCID> : Check ability to show footer when user foreground app incase no internet connection after switch
#  to another app
#    And Login with account "<HolderUser>"
#    And Go to screen "<screen>"
#    And Open Setting of Device
#    And Turn off Wifi mode
#    And Touch the snapshort of app
#    Then Verify value footer is "<message>"
#    Examples:
#      |TCID|HolderUser|screen|message|
#      |TC_Disconnect_008|validAccountForRobo|Watchlist|Footer_DisConnectInternet|