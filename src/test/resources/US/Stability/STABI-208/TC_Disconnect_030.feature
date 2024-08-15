#@Stabi208
Feature:check ability to tap on [Try Again] button in case internet is back to available at the same time


  Background:
    Given Login page is open

  Scenario Outline:check ability to tap on [Try Again] button in case internet is back to available at the same time
    And Login with account "<HolderUser>"
    And Go to screen "<screen>"
    And Turn off Wifi mode
    And Touch the snapshort of app
    And Tap on an element of "<screen>" that init a new screen
    And Tap on Disconnection button TryAgain
    Then Verify value footer is "<message>"
    And Turn on Wifi mode
    And Touch the snapshort of app
    Then Verify value footer is "<message2>"
    Then Verify the display of Disconnect is "false"
    Examples:
      |HolderUser|screen|message|message2|
      |validAccountForRobo|Login|ConnectingMsg|BackOnlineMsg|
