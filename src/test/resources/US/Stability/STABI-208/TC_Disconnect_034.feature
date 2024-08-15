#@Stabi208
Feature:Check behavior of Disconnection screen in case light theme is light

  Background:
    Given Login page is open

#  1. Access to screen that allows to switch to landscape mode
#  2. Disconnect internet
#  3. Interact with elements on the page that requires init a new view > show the disconnect screen
#  4. Wait until the disconnect screen is auto-refreshed
#  5. Connect internet
#  6. Tap on [Try again] button
  Scenario Outline: Check behavior of Disconnection screen in case light theme is light
    #    Hoa thu tu dien
    Examples:
      |HolderUser|screen|message|message2|
      |validAccountForRobo|Login|ConnectingMsg|BackOnlineMsg|
