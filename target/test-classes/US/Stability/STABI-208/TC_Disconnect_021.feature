#@Stabi208
Feature:

  Background: Check ability to show the disconnect screen when user tap on icon on the current screen to open a new screen
    Given Login page is open

  Scenario Outline:Check ability to show the disconnect screen when user tap on icon on the current screen to open a new screen
    And Login with account "<HolderUser>"
    And Go to screen "<screen>"
    And Turn off Wifi mode
    And Touch the snapshort of app
    And Tap on an element of "<screen>" that init a new screen
    Then Verify value footer is "<message>"
    Examples:
      |HolderUser|screen|message|
      |validAccountForRobo|Login|Footer_DisConnectInternet|