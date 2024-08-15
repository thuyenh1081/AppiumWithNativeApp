#@Stabi208
Feature: Check ability to auto-refresh the screen after internet connection is back to available

  Background:
    Given Login page is open

  Scenario Outline: Check ability to auto-refresh the screen after internet connection is back to available
    And Login with account "<HolderUser>"
    And Go to screen "<screen>"
    And Tap on an element of "<screen>" that init a new screen
    And Turn off Wifi mode
    And Touch the snapshort of app
    And Turn on Wifi mode
    Then Verify value footer is "<message>"
    And Wait for run out of time the display of Back Online message
    Then Verify the display of Footer is "false"
    Examples:
      |HolderUser|screen|message|
      |validAccountForRobo|Login|BackOnlineMsg|