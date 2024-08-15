@haley

Feature: Haley test the first function

  Background:
    Given Login page is open

  Scenario Outline:  Haley test the first function'
    And Login with account "<accountHolder>"
    And Go to screen "<screen>"
    And Tap on Trade
    And Scroll to see TradeModule type "<tradeModuleType>"
    And Tap on TradeModule type "<tradeModuleType>"
    And Tap on TradeOrders
    And Tap on OrderList row order 3

    Examples:
      |accountHolder|screen|tradeModuleType|
      |validAccountHolder|Trade|Stocks     |