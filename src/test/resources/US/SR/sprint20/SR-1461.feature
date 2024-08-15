@Pre_CFD
Feature: Check feature of CFD

  Background:
    Given Login page is open


  Scenario Outline:"<TCID>" Check not show Pre-market price  Turn off Watchlist setting “Show Pre and Post Market”
    And Login with account "<HolderUser>"
    And Tap on Watchlist
    And Tap on WatchlistGroup icon Setting
    And Tap on WatchlistSetting tab Display
    And Turn off WatchlistSetting tab Display icon ShowPreAndPostMarket
    And Tap on WatchlistSetting icon Back
    And Tap on Home
    And Scroll to see HomePage widget Watchlist
    And Tap on HomePage widget Watchlist tab "<watchlistGroup>"
    Then Verify the value of counter HomePage found by counterName "<counterName>" : counterType "<counterType>" counterCode "<counterCode>" counterChart "<counterChart>" firstLabel "<fistLabel>" secondLabel "<secondLabel>" lastDonePrice "<lastDonePrice>" changePCT "<Change%>" with showPrePostOption is "<showPrePostOption>"
    Examples:
      | TCID      | HolderUser          | watchlistGroup | counterName    | counterType | counterCode | counterChart | fistLabel | secondLabel | lastDonePrice | Change%   | showPrePostOption |
      | HP_TC001  | validAccountForCFD | AutoPre        | Apple Inc      | CFD         | not empty   | empty        | not empty | not empty   | not empty     | not empty | false             |
      | HP_TC002  | validAccountForCFD | AutoPre        | AptarGroup Inc | CFD         | not empty   | empty        | not empty | not empty   | not empty     | not empty | false             |
      | HP_TC0015 | validAccountForCFD | AutoPre        | QAT12AMEX      | CFD         | not empty   | empty        | not empty | not empty   | not empty     | not empty | false             |

  Scenario Outline:"<TCID>" Check show Pre-market price Turn on Watchlist setting “Show Pre and Post Market”
    And Login with account "<HolderUser>"
    And Tap on Watchlist
    And Tap on WatchlistGroup icon Setting
    And Tap on WatchlistSetting tab Display
    And Turn on WatchlistSetting tab Display icon ShowPreAndPostMarket
    And Tap on WatchlistSetting icon Back
    And Tap on Home
    And Scroll to see HomePage widget Watchlist
    And Tap on HomePage widget Watchlist tab "<watchlistGroup>"
    Then Verify the value of counter HomePage found by counterName "<counterName>" : counterType "<counterType>" counterCode "<counterCode>" counterChart "<counterChart>" firstLabel "<fistLabel>" secondLabel "<secondLabel>" lastDonePrice "<lastDonePrice>" changePCT "<Change%>" with showPrePostOption is "<showPrePostOption>"
    Examples:
      | TCID      | HolderUser          | watchlistGroup | counterName    | counterType | counterCode | counterChart | fistLabel | secondLabel | lastDonePrice | Change%   | showPrePostOption |
      | HP_TC003  | validAccountForCFD | AutoPre        | Apple Inc      | CFD         | not empty   | empty        | not empty | not empty   | not empty     | not empty | true              |
      | HP_TC004  | validAccountForCFD | AutoPre        | AptarGroup Inc | CFD         | not empty   | empty        | not empty | not empty   | not empty     | not empty | true              |
      | HP_TC0015 | validAccountForCFD | AutoPre        | QAT12AMEX      | CFD         | not empty   | empty        | not empty | not empty   | not empty     | not empty | true              |

  Scenario Outline: "<TCID>" Check show PRE label in Pre-Market session
    And Login with account "<HolderUser>"
    And Tap on Watchlist
    And Tap on WatchlistGroup icon Setting
    And Tap on WatchlistSetting tab Display
    And Turn on WatchlistSetting tab Display icon ShowPreAndPostMarket
    And Tap on WatchlistSetting icon Back
    And Tap on Home
    And Scroll to see HomePage widget Watchlist
    And Tap on HomePage widget Watchlist tab "<watchlistGroup>"
    Then Verify the value of counter HomePage found by counterName "<counterName>" : counterType "<counterType>" counterCode "<counterCode>" counterChart "<counterChart>" firstLabel "<fistLabel>" secondLabel "<secondLabel>" lastDonePrice "<lastDonePrice>" changePCT "<Change%>" with showPrePostOption is "<showPrePostOption>"
    Examples:
      | TCID     | HolderUser         | watchlistGroup | counterName | counterType | counterCode | counterChart | fistLabel | secondLabel | lastDonePrice | Change%   | showPrePostOption |
      | HP_TC007 | validAccountForCFD | AutoPre        | Apple Inc   | CFD         | not empty   | empty        | not empty | PRE         | not empty     | not empty | true              |

  Scenario Outline:"<TCID>" Check the display in case shown chart
    And Login with account "<HolderUser>"
    And Tap on Watchlist
    And Turn on WatchlistGroup icon Chart
    And Tap on WatchlistGroup icon Setting
    And Tap on WatchlistSetting tab Display
    And Turn on WatchlistSetting tab Display icon ShowPreAndPostMarket
    And Tap on WatchlistSetting icon Back
    And Tap on Home
    And Scroll to see HomePage widget Watchlist
    And Tap on HomePage widget Watchlist tab "<watchlistGroup>"
    Then Verify the value of counter HomePage found by counterName "<counterName>" : counterType "<counterType>" counterCode "<counterCode>" counterChart "<counterChart>" firstLabel "<fistLabel>" secondLabel "<secondLabel>" lastDonePrice "<lastDonePrice>" changePCT "<Change%>" with showPrePostOption is "<showPrePostOption>"
    Examples:
      | TCID          | HolderUser          | watchlistGroup | counterName | counterType | counterCode | counterChart | fistLabel | secondLabel | lastDonePrice | Change%   | showPrePostOption |
      | HP_Show Chart | validAccountForCFD | AutoPre        | Apple Inc   | CFD         | not empty   | not empty    | not empty | not empty   | not empty     | not empty | true              |


  Scenario Outline:"<TCID>" Check navigate to counter detail
    And Login with account "<HolderUser>"
    And Tap on Home
    And Scroll to see HomePage widget Watchlist
    And Tap on HomePage widget Watchlist tab "<watchlistGroup>"
    And Tap on HomePage widget Watchlist counter row found by counterName "<counterName>"
    Then Verify the display of the screen "CounterDetai" is "true"
    Examples:
    | TCID     | HolderUser          | watchlistGroup | counterName | counterType | counterCode | counterChart | fistLabel | secondLabel | lastDonePrice | Change%   | showPrePostOption |
    | HP_TC014 | validAccountForCFD | AutoPre        | Apple Inc   | CFD         | not empty   |    empty    | not empty | not empty   | not empty     | not empty | true              |

  Scenario Outline:"<TCID>" Check the display after switching between some tab
    And Login with account "<HolderUser>"
    And Tap on Watchlist
    And Tap on WatchlistGroup icon Setting
    And Tap on WatchlistSetting tab Display
    And Turn on WatchlistSetting tab Display icon ShowPreAndPostMarket
    And Tap on WatchlistSetting icon Back
    And Tap on Home
    And Scroll to see HomePage widget Watchlist
    And Tap on HomePage widget Watchlist tab "<watchlistGroup>"
    And Tap on HomePage widget Watchlist tab "All"
    And Tap on HomePage widget Watchlist tab "<watchlistGroup>"
    Then Verify the value of counter HomePage found by counterName "<counterName>" : counterType "<counterType>" counterCode "<counterCode>" counterChart "<counterChart>" firstLabel "<fistLabel>" secondLabel "<secondLabel>" lastDonePrice "<lastDonePrice>" changePCT "<Change%>" with showPrePostOption is "<showPrePostOption>"
    Examples:
      | TCID             | HolderUser         | watchlistGroup | counterName    | counterType | counterCode | counterChart | fistLabel | secondLabel | lastDonePrice | Change%   | showPrePostOption |
      | HP_switching Tab | validAccountForCFD | AutoPre        | AptarGroup Inc | CFD         | not empty   | empty    | not empty | not empty   | not empty     | not empty | true              |
