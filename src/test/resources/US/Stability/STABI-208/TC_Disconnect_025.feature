#@Stabi208
Feature:Check ability to show the disconnect screen when user open screen from a deeplink incase session has not yet expired and no internet connection

  Background:
    Given Login page is open

   Scenario Outline:Check ability to show the disconnect screen when user open screen from a deeplink incase session has not yet expired and no internet connection
    And Login with account "<HolderUser>"
    And Go to screen "<screen>"
    And Turn off Wifi mode
    And Open an url "<deeplink>"
     Then Verify the display of Disconnect is "true"
    Examples:
      |HolderUser|screen|deeplink|
      |validAccountForRobo|Home|deeplink|