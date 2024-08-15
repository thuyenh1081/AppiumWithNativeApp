#@Stabi208
Feature:Check ability to show the disconnect screen when user already logged in opens app after killing app for awhile

  Background:
    Given Login page is open

  Scenario Outline:Check ability to show the disconnect screen when user already logged in opens app after killing app for awhile
    And Login with account "<HolderUser>"
    And Go to screen "<screen>"
    And Kill app
    And Turn off Wifi mode
    And Touch the snapshort of app
    Then Verify value footer is "<message>"
    Examples:
      |HolderUser|screen|message|
      |validAccountForRobo|Login|Footer_DisConnectInternet|
