#@Test
Feature: check internet connection

  Background:
    Given Login page is open


  Scenario Outline: Verify existing of the screen "<screen>"
    And Login with account "<HolderUser>"
    And Go to screen "<screen>"
    Then Verify the display of the screen "<screen>" is "true"
  Examples:
    |HolderUser|screen|
    |validAccountForRobo|MarketStockIndicies|
#    |validAccountForRobo|MarketStockIndiciesChange|
#    |validAccountForRobo|MarketStockTopVolumn|
#    |validAccountForRobo|MarketStockTopLoserChangePercent|
#    |validAccountForRobo|MarketStockTopLoserChange|
#    |validAccountForRobo|MarketStockTopGainerChange|
#    |validAccountForRobo|MarketStockTopGainerChangePercent|
#    |validAccountForRobo|MarketStockUT|
#    |validAccountForRobo|MarketUTTopPerformingWeekly|
#    |validAccountForRobo|MarketUTTopPerformingDaily|
#    |validAccountForRobo|MarketUTTopPerformingMonthly|
#    |validAccountForRobo|MarketUTWorstPerformingWeekly|
#    |validAccountForRobo|MarketUTWorstPerformingDaily|
#    |validAccountForRobo|MarketUTWorstPerformingMonthly|
#    |validAccountForRobo|MarketNews|
#    |validAccountForRobo|MarketNewsMyNews|
#    |validAccountForRobo|MarketCalender|
#    |validAccountForRobo|MarketCalenderSetting|
#    |validAccountForRobo|GlobalSearchNews|
#    |validAccountForRobo|GlobalSearchCounters|
#    |validAccountForRobo|GlobalSearchCommunity|
#    |validAccountForRobo|GlobalSearchArticles|
    |validAccountForRobo|Watchlist|
#    |validAccountForRobo|Search Counter|
#    |validAccountForRobo|Edit Watchlist|
#    |validAccountForRobo|WatchlistSettingDisplay|
#    |validAccountForRobo|WatchlistSettingColumn|
#    |validAccountForRobo|WatchlistSettingGroup|
#    |validAccountForRobo|GlobalSearchNews|
#    |validAccountForRobo|GlobalSearchCounters|
#    |validAccountForRobo|GlobalSearchCommunity|
#    |validAccountForRobo|GlobalSearchArticles|
#  |      |
#  |      |
#  |      |
#  |      |
#  |      |
#  |      |
#  |      |
#  |      |
#  |      |
#  |      |
#  |      |
#  |      |
#  |      |
#  |      |
#  Scenario Outline: Login successfully
#    And Enter Login textBox Account as "0000000"
#    And Enter Login textBox Pass as "Phillip1"
#    And Tap on Login button Login
#    And Tap on Trade
#    And Turn off Wifi mode
#    And Touch the snapshort of app
#    Then Verify Popup incase no internet connection is "<message>"
#    And Turn on Wifi mode
#    Examples:
#      |message|
#      |noInternetConnection|