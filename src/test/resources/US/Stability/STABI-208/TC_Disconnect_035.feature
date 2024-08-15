#@Stabi208
Feature:Check ability to back to previous screen of Splash screen in case internet is available

  Background:
    Given Login page is open

  Scenario Outline: Check ability to back to previous screen of Splash screen in case internet is available
    And Login with account "<HolderUser>"
    And Go to screen "<screen>"
    And Tap on an element of "<screen>" that init a new screen
    And Turn off Wifi mode
    And Touch the snapshort of app
    And Turn on Wifi mode
    And Tap on button Back
    And Verify the display of the screen "<previousScreen>" is "true"
    Examples:
      |HolderUser|screen|previousScreen|
      |validAccountForRobo|WatchListSetting|WatchList|
