@watchList
Feature: watchList

  Background:
    Given Login page is open


  Scenario Outline: Verify sorted by name column
    And Login with account "<HolderUser>"
    And Tap on Watchlist
    And Swipe to see WatchlistModule group "<group>"
    And Tap on WatchlistModule group "<group>"
    Then Verify the sorting of WatchlistGroup CounterTable column Name is correct
    Examples:
      |HolderUser|group|
      |validAccountHolder|SG|

  Scenario Outline: CounterDetail is opened when Tap on a counter row
    And Login with account "<HolderUser>"
    And Tap on Watchlist
    And Scroll to see WatchlistGroup counter type "EQ"
    And Tap on WatchlistGroup counter type "EQ"
    Then Verify the display of CounterDetail is "true"
    Examples:
      |HolderUser|
      |validAccountHolder|
  Scenario Outline: Login successfully
    And Login with account "<HolderUser>"
    Then Verify the display of ContentApp is "true"
    Examples:
      |HolderUser|
      |validAccountHolder|

  Scenario Outline: Login unsuccessfully
    And Login with account "<invalideAccount>"
    Then Verify value LoginPage message is "<errorMsg>"
    Examples:
      |invalideAccount|errorMsg|
      |invalidAccountHolder|err_invalid_username_or_password|



  Scenario Outline: icons under Watchlist work normally
    And Login with account "<HolderUser>"
    And Tap on Watchlist
    And Tap on WatchlistGroup icon Rotate
    And Tap on WatchlistGroup icon Rotate
    And Tap on WatchlistGroup icon Edit
    And Turn on WatchlistGroup icon ScrollableHorizontal
    And Tap on WatchlistGroup icon Setting
    And Tap on WatchlistSetting icon Back
    Examples:
      |HolderUser|
      |validAccountHolder|

  Scenario Outline: Global search is opened when click on Add Counter button
    And Login with account "<HolderUser>"
    And Tap on Watchlist
    And Scroll to see WatchlistGroup button Add Group
    And Tap on WatchlistGroup button Add Group
    Then Verify the display of GlobalSearch is "true"
    Examples:
      |HolderUser|
      |validAccountHolder|

    Scenario Outline: Edit Incides screen is opened when click on Edit Incides icon
    And Login with account "<HolderUser>"
    And Tap on Watchlist
    And Scroll to see WatchlistModule incides "<incides>"
    Then Verify the display of WatchlistModule incides "<incides>" is "true"
    And Scroll to see WatchlistModule button EditIncides
    And Tap on WatchlistModule icon EditIncides
    Then Verify the display of WatchlistModule IndicesSetting is "true"
      Examples:
      |HolderUser|incides|
      |validAccountHolder|Hang Seng|

  Scenario Outline: Check keep setting after exit Setting screen
    And Login with account "<HolderUser>"
    And Tap on Watchlist
    And Swipe to see WatchlistModule group "<group>"
    And Tap on WatchlistModule group "<group>"
    And Tap on WatchlistGroup icon Setting
    And Tap on WatchlistSetting tab Columns
    And Scroll to see WatchlistSetting tab Columns checkBox "<column>"
    And Tap on WatchlistSetting tab Columns checkBox "<column>"
    And Tap on WatchlistSetting icon Back
    And Tap on WatchlistGroup icon Setting
    And Tap on WatchlistSetting tab Columns
    And Scroll to see WatchlistSetting tab Columns checkBox "<column>"
    And Verify checking on WatchlistSetting column "<column>" is "true"
    Examples:
      |HolderUser|column|group|
      |validAccountHolder|Call Date|SG|

  Scenario Outline: Could be change position of group
    And Login with account "<HolderUser>"
    And Tap on Watchlist
    And Tap on WatchlistGroup icon Setting
    And Tap on WatchlistSetting tab Columns
    And Drag WatchlistSetting tab Columns checkBox "<checkBox1>" to "<checkBox2>"
    Examples:
      |HolderUser|checkBox1|checkBox2|
      |validAccountHolder|Change|Asset|

  Scenario Outline: Check action on IOS
    And Login with account "<HolderUser>"
    And Tap on Watchlist
    And Tap on WatchlistModule group "B"
    Examples:
      |HolderUser|
      |validAccountHolder|
