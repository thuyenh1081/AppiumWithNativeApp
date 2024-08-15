#@Stabi208
Feature: Check ability to show footer on page when user trigger to show popup incase no internet connection

  Background:
    Given Login page is open

  Scenario Outline: <TCID> : <screen>: Check ability to show footer on page when user trigger to show popup incase no internet connection
    And Login with account "<HolderUser>"
    And Go to screen "<screen>"
    And Turn off Wifi mode
    And Tap on an element to trigger popup displaying at "<screen>"
    Then Verify value footer is "<message>"
    Examples:
      |TCID|HolderUser|screen|message|
      |TC_Disconnect_004|validAccountForRobo|Setting|Footer_DisConnectInternet|