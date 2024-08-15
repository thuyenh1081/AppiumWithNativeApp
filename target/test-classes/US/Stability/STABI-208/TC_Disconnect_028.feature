#@Stabi208
Feature: Check ability to auto recheck internet connection is available or not every 15s

  Background:
    Given Login page is open

  Scenario Outline: Check ability to auto recheck internet connection is available or not every 15s
    And Login with account "<HolderUser>"
    And Go to screen "<screen>"
    And Turn off Wifi mode
    And Touch the snapshort of app
    Then Verify value footer is "<retryMsg>"
    And Wait for try connecting internet
    Then Verify value footer is "<retryMsg>"
    Examples:
      |HolderUser|screen|retryMsg|
      |validAccountForRobo|Login|ConnectingMsg|

  Scenario Outline: Check the display of reload icon when showing connecting message
    And Login with account "<HolderUser>"
    And Go to screen "<screen>"
    And Turn off Wifi mode
    And Touch the snapshort of app
    Then Verify value footer is "<retryMsg>"
    Then Verify the display of Disconnection icon Loading is "true"
    Then Verify the display of Disconnection button TryAgain is "false"
    Examples:
      |HolderUser|screen|retryMsg|
      |validAccountForRobo|Login|ConnectingMsg|


#  Scenario Outline: Check ability to auto recheck internet connection is available or not every 15s
#    And Login with account "<HolderUser>"
#    And Go to screen "<screen>"
#    And Turn off Wifi mode
#    And Touch the snapshort of app
#    And Get the time for the display of Footer with message "<retryMsg>"
#    Then Verify the display of Disconnection icon Loading is "true"
#    Then Verify the display of Disconnection button TryAgain is "false"
#    And Get the time for the display of Footer with message "<noInternetMsg>"
#    And Get the time for the display of Footer with message "<retryMsg>"
#    Then Verify the "<time>" between the two display of Footer with message "<retryMsg>"
#    Examples:
#      |HolderUser|screen|retryMsg|noInternetMsg|time|
#      |validAccountForRobo|Login|ConnectingMsg|Footer_DisConnectInternet|TimeForReCheckInternet|