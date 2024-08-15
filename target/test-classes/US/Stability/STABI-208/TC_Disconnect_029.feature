#@Stabi208
Feature: check ability to tap on [Try Again] button on the disconnect screen and still no internet connectio

  Background:
    Given Login page is open

  Scenario Outline: check ability to tap on [Try Again] button on the disconnect screen and still no internet connectio
    And Login with account "<HolderUser>"
    And Go to screen "<screen>"
    And Turn off Wifi mode
    And Touch the snapshort of app
    And Tap on Disconnection button TryAgain
    Then Verify value footer is "<retryMsg>"
    Then Verify the display of Disconnection icon Loading is "true"
    Then Verify the display of Disconnection button TryAgain is "false"
    And Wait for try connecting internet
    Then Verify value footer is "<retryMsg>"
    Examples:
      |HolderUser|screen|retryMsg|
      |validAccountForRobo|Login|ConnectingMsg|