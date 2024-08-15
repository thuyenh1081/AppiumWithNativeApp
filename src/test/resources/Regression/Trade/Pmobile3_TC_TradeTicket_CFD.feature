#@Trade_CFD
Feature: Check feature of CFD

  Background:
    Given Login page is open

  Scenario Outline: <ID> :Place Buy a CFD
    And Login with account "<HolderUser>"
    And Tap on Trade
    And Scroll to see TradeModule type "<TradeType>"
    And Tap on TradeModule type "<TradeType>"
    And Tap on TradeCFD tab Order
    And Count number of Today order TradeCFD
    And Tap on TradeCFD button Trade
    And Enter GlobalSearch textBox Search as "CFD"
    And Tap on Global Search row name 1
    And Tap on TradeTicketCFD button Buy
    And Tap on TradeTicketCFD button PlaceBuyLimitOrder
    Then Verify value TradeTicketCFD dialog OrderConfirmation
    And Tap on TradeTicketCFD OrderConfirmation button Confirm
    Then Verify the increasing of number of Today order is 1
    And Tap on TradeCFDOrdersPage tab Order row 1
    Then Verify value TradeTicket dialog OrderDetail
    Examples:
      |ID|HolderUser|TradeType|
      |1|validAccountForCFD1|CFD|

#
#  Scenario Outline: Place Buy a CFD
#    And Login with account "<HolderUser>"
#    And Tap on Trade
#    And Scroll to see TradeModule type "<TradeType>"
#    And Tap on TradeModule type "<TradeType>"
#    And Tap on CFDTrade icon Order
#    And Tap on CFDTrade icon Trade
#    And Enter GlobalSearch textBox Search as "CFD"
#    And Tap on Global Search row name 1
#    And Tap on CFDTradeTicket icon Buy
#    And Tap on CFDTradeTicket icon PlaceBuyLimitOrder
#    Then Verify value CFDTradeTicket dialog OrderConfirmation
#    And Tap on OrderConfirmation icon Confirm
#    And Tap on CFDTrade icon Trade
#    And Enter GlobalSearch textBox Search as "CFD"
#    And Tap on Global Search row name 1
#    And Tap on CFDTradeTicket icon Buy
#    And Tap on CFDTradeTicket icon PlaceBuyLimitOrder
#    Then Verify value CFDTradeTicket dialog OrderConfirmation
#    And Tap on OrderConfirmation icon Confirm
#    And Tap on CFDTrade icon Trade
#    And Enter GlobalSearch textBox Search as "CFD"
#    And Tap on Global Search row name 1
#    And Tap on CFDTradeTicket icon Buy
#    And Tap on CFDTradeTicket icon PlaceBuyLimitOrder
#    Then Verify value CFDTradeTicket dialog OrderConfirmation
#    And Tap on OrderConfirmation icon Confirm
#    And Tap on CFDTrade icon Trade
#    And Enter GlobalSearch textBox Search as "CFD"
#    And Tap on Global Search row name 1
#    And Tap on CFDTradeTicket icon Buy
#    And Tap on CFDTradeTicket icon PlaceBuyLimitOrder
#    Then Verify value CFDTradeTicket dialog OrderConfirmation
#    And Tap on OrderConfirmation icon Confirm
#    And Tap on CFDTrade icon Trade
#    And Enter GlobalSearch textBox Search as "CFD"
#    And Tap on Global Search row name 1
#    And Tap on CFDTradeTicket icon Buy
#    And Tap on CFDTradeTicket icon PlaceBuyLimitOrder
#    Then Verify value CFDTradeTicket dialog OrderConfirmation
#    And Tap on OrderConfirmation icon Confirm
#    And Tap on CFDTrade icon Trade
#    And Enter GlobalSearch textBox Search as "CFD"
#    And Tap on Global Search row name 1
#    And Tap on CFDTradeTicket icon Buy
#    And Tap on CFDTradeTicket icon PlaceBuyLimitOrder
#    Then Verify value CFDTradeTicket dialog OrderConfirmation
#    And Tap on OrderConfirmation icon Confirm
#    And Tap on CFDTrade icon Trade
#    And Enter GlobalSearch textBox Search as "CFD"
#    And Tap on Global Search row name 1
#    And Tap on CFDTradeTicket icon Buy
#    And Tap on CFDTradeTicket icon PlaceBuyLimitOrder
#    Then Verify value CFDTradeTicket dialog OrderConfirmation
#    And Tap on OrderConfirmation icon Confirm
#    And Tap on CFDTrade icon Trade
#    And Enter GlobalSearch textBox Search as "CFD"
#    And Tap on Global Search row name 1
#    And Tap on CFDTradeTicket icon Buy
#    And Tap on CFDTradeTicket icon PlaceBuyLimitOrder
#    Then Verify value CFDTradeTicket dialog OrderConfirmation
#    And Tap on OrderConfirmation icon Confirm
#    And Tap on CFDTrade icon Trade
#    And Enter GlobalSearch textBox Search as "CFD"
#    And Tap on Global Search row name 1
#    And Tap on CFDTradeTicket icon Buy
#    And Tap on CFDTradeTicket icon PlaceBuyLimitOrder
#    Then Verify value CFDTradeTicket dialog OrderConfirmation
#    And Tap on OrderConfirmation icon Confirm
#    And Tap on CFDTrade icon Trade
#    And Enter GlobalSearch textBox Search as "CFD"
#    And Tap on Global Search row name 1
#    And Tap on CFDTradeTicket icon Buy
#    And Tap on CFDTradeTicket icon PlaceBuyLimitOrder
#    Then Verify value CFDTradeTicket dialog OrderConfirmation
#    And Tap on OrderConfirmation icon Confirm
#    And Tap on CFDTrade icon Trade
#    And Enter GlobalSearch textBox Search as "CFD"
#    And Tap on Global Search row name 1
#    And Tap on CFDTradeTicket icon Buy
#    And Tap on CFDTradeTicket icon PlaceBuyLimitOrder
#    Then Verify value CFDTradeTicket dialog OrderConfirmation
#    And Tap on OrderConfirmation icon Confirm
#    And Tap on CFDTrade icon Trade
#    And Enter GlobalSearch textBox Search as "CFD"
#    And Tap on Global Search row name 1
#    And Tap on CFDTradeTicket icon Buy
#    And Tap on CFDTradeTicket icon PlaceBuyLimitOrder
#    Then Verify value CFDTradeTicket dialog OrderConfirmation
#    And Tap on OrderConfirmation icon Confirm
#    And Tap on CFDTrade icon Trade
#    And Enter GlobalSearch textBox Search as "CFD"
#    And Tap on Global Search row name 1
#    And Tap on CFDTradeTicket icon Buy
#    And Tap on CFDTradeTicket icon PlaceBuyLimitOrder
#    Then Verify value CFDTradeTicket dialog OrderConfirmation
#    And Tap on OrderConfirmation icon Confirm
#    And Tap on CFDTrade icon Trade
#    And Enter GlobalSearch textBox Search as "CFD"
#    And Tap on Global Search row name 1
#    And Tap on CFDTradeTicket icon Buy
#    And Tap on CFDTradeTicket icon PlaceBuyLimitOrder
#    Then Verify value CFDTradeTicket dialog OrderConfirmation
#    And Tap on OrderConfirmation icon Confirm
#    And Tap on CFDTrade icon Trade
#    And Enter GlobalSearch textBox Search as "CFD"
#    And Tap on Global Search row name 1
#    And Tap on CFDTradeTicket icon Buy
#    And Tap on CFDTradeTicket icon PlaceBuyLimitOrder
#    Then Verify value CFDTradeTicket dialog OrderConfirmation
#    And Tap on OrderConfirmation icon Confirm
#    And Tap on CFDTrade icon Trade
#    And Enter GlobalSearch textBox Search as "CFD"
#    And Tap on Global Search row name 1
#    And Tap on CFDTradeTicket icon Buy
#    And Tap on CFDTradeTicket icon PlaceBuyLimitOrder
#    Then Verify value CFDTradeTicket dialog OrderConfirmation
#    And Tap on OrderConfirmation icon Confirm
#    And Tap on CFDTrade icon Trade
#    And Enter GlobalSearch textBox Search as "CFD"
#    And Tap on Global Search row name 1
#    And Tap on CFDTradeTicket icon Buy
#    And Tap on CFDTradeTicket icon PlaceBuyLimitOrder
#    Then Verify value CFDTradeTicket dialog OrderConfirmation
#    And Tap on OrderConfirmation icon Confirm
#    And Tap on CFDTrade icon Trade
#    And Enter GlobalSearch textBox Search as "CFD"
#    And Tap on Global Search row name 1
#    And Tap on CFDTradeTicket icon Buy
#    And Tap on CFDTradeTicket icon PlaceBuyLimitOrder
#    Then Verify value CFDTradeTicket dialog OrderConfirmation
#    And Tap on OrderConfirmation icon Confirm
#    And Tap on CFDTrade icon Trade
#    And Enter GlobalSearch textBox Search as "CFD"
#    And Tap on Global Search row name 1
#    And Tap on CFDTradeTicket icon Buy
#    And Tap on CFDTradeTicket icon PlaceBuyLimitOrder
#    Then Verify value CFDTradeTicket dialog OrderConfirmation
#    And Tap on OrderConfirmation icon Confirm
#    And Tap on CFDTrade icon Trade
#    And Enter GlobalSearch textBox Search as "CFD"
#    And Tap on Global Search row name 1
#    And Tap on CFDTradeTicket icon Buy
#    And Tap on CFDTradeTicket icon PlaceBuyLimitOrder
#    Then Verify value CFDTradeTicket dialog OrderConfirmation
#    And Tap on OrderConfirmation icon Confirm
#
#    Examples:
#      |HolderUser|TradeType|
#      |validAccountForCFD|CFD|
