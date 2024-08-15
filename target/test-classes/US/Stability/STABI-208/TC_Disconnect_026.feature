#@Stabi208
Feature:Check ability to show the disconnect screen when user open screen from a deeplink incase session already expired and no internet connection

  Background:
    Given Login page is open

  Scenario Outline:Check ability to show the disconnect screen when user open screen from a deeplink incase session already expired and no internet connection
    And Login with account "<HolderUser>"
    And Go to screen "<screen>"
    And Turn off Wifi mode
    And Wait for session timeout
    And Turn on Wifi mode
    And Open an url "<deeplink>"
    Then Verify the display of Footer is "false"
    And Enter pass for SSTO popup
    Then Verify the display of the screen "<screen>" is "true"
    Examples:
      |HolderUser|screen|deeplink|
      |validAccountForRobo|Login|deeplink|