#@Pre_CFD
Feature: Check feature of CFD

  Background:
    Given Login page is open

  Scenario Outline:  <TCID> : Check not show Pre market when turn off Watchlist setting (portrait mode)
    And Login with account "<HolderUser>"
    And Tap on Watchlist
    And Scroll to see WatchlistModule group "<watchlistGroup>"
    And Tap on WatchlistModule group "<watchlistGroup>"
    And Tap on WatchlistGroup icon Setting
    And Turn off WatchlistSetting tab Display icon ShowPreAndPostMarket
    And Tap on WatchlistSetting icon Back
    And Scroll to see WatchlistGroup counter name "<counterName>"
    Then Verify the value of counter Watchlist found by counterName "<counterName>" : counterType "<counterType>" counterCode "<counterCode>" counterChart "<counterChart>" firstLabel "<fistLabel>" secondLabel "<secondLabel>" lastDonePrice "<lastDonePrice>" change "<Change>" changePCT "<Change%>" with showPrePostOption is "<showPrePostOption>" and scrollableHorizontal is "<scrollableHorizontal>" and landscapeMode is "<landscapeMode>"
    Examples:
      | TCID    | HolderUser         | watchlistGroup | counterName | counterType | counterCode | counterChart | fistLabel | secondLabel | lastDonePrice |Change    | Change%   | showPrePostOption | scrollableHorizontal |
      | 001 002 | validAccountForCFD | AutoPre        | Apple Inc   | CFD         | not empty   | empty        | not empty | not empty   | not empty     |not empty | not empty | false             | false                |


  Scenario Outline:  <TCID> : Check show Pre market when turn on Watchlist setting  (portrait mode)
    And Login with account "<HolderUser>"
    And Tap on Watchlist
    And Scroll to see WatchlistModule group "<watchlistGroup>"
    And Tap on WatchlistModule group "<watchlistGroup>"
    And Tap on WatchlistGroup icon Setting
    And Turn on WatchlistSetting tab Display icon ShowPreAndPostMarket
    And Tap on WatchlistSetting icon Back
    And Scroll to see WatchlistGroup counter name "<counterName>"
    Then Verify the value of counter Watchlist found by counterName "<counterName>" : counterType "<counterType>" counterCode "<counterCode>" counterChart "<counterChart>" firstLabel "<fistLabel>" secondLabel "<secondLabel>" lastDonePrice "<lastDonePrice>" change "<Change>" changePCT "<Change%>" with showPrePostOption is "<showPrePostOption>" and scrollableHorizontal is "<scrollableHorizontal>" and landscapeMode is "<landscapeMode>"
    Examples:
      | TCID            | HolderUser         | watchlistGroup | counterName | counterType | counterCode | counterChart | fistLabel | secondLabel | lastDonePrice |Change    | Change%   | showPrePostOption | scrollableHorizontal |
      | 003 004 005 007 | validAccountForCFD | AutoPre        | Apple Inc   | CFD         | not empty   | empty        | not empty | not empty   | not empty     |not empty | not empty | true              | false                |
      | 050             | validAccountForCFD | AutoPre        | DBS         | CFD         | not empty   | empty        | not empty | not empty   | not empty     |not empty | not empty | true              | false                |

  Scenario Outline:  <TCID> : Check not show Pre market when turn off Watchlist setting (horizontal mode)
    And Login with account "<HolderUser>"
    And Tap on Watchlist
    And Tap on WatchlistGroup icon Setting
    And Turn off WatchlistSetting tab Display icon ShowPreAndPostMarket
    And Tap on WatchlistSetting icon Back
    And Scroll to see WatchlistModule group "<watchlistGroup>"
    And Tap on WatchlistModule group "<watchlistGroup>"
    And Turn on WatchlistGroup icon ScrollableHorizontal
    And Scroll to see WatchlistGroup counter name "<counterName>"
    Then Verify the value of counter Watchlist found by counterName "<counterName>" : counterType "<counterType>" counterCode "<counterCode>" counterChart "<counterChart>" firstLabel "<fistLabel>" secondLabel "<secondLabel>" lastDonePrice "<lastDonePrice>" change "<Change>" changePCT "<Change%>" with showPrePostOption is "<showPrePostOption>" and scrollableHorizontal is "<scrollableHorizontal>" and landscapeMode is "<landscapeMode>"
    Examples:
      | TCID    | HolderUser         | watchlistGroup | counterName | counterType | counterCode | counterChart | fistLabel | secondLabel | lastDonePrice |Change    | Change%   | showPrePostOption | scrollableHorizontal | landscapeMode |
      | 022 023 | validAccountForCFD | AutoPre        | Apple Inc   | CFD         | not empty   | empty        | not empty | not empty   | not empty     |not empty | not empty | false             | true                 | false         |
      | 051     | validAccountForCFD | AutoPre        | DBS         | CFD         | not empty   | empty        | not empty | not empty   | not empty     |not empty | not empty | false             | true                 | false         |

  Scenario Outline:  <TCID> : Check show Pre market when turn on Watchlist setting (horizontal mode)
    And Login with account "<HolderUser>"
    And Tap on Watchlist
    And Scroll to see WatchlistModule group "<watchlistGroup>"
    And Tap on WatchlistModule group "<watchlistGroup>"
    And Tap on WatchlistGroup icon Setting
    And Turn on WatchlistSetting tab Display icon ShowPreAndPostMarket
    And Tap on WatchlistSetting icon Back
    And Turn on WatchlistGroup icon ScrollableHorizontal
    And Scroll to see WatchlistGroup counter name "<counterName>"
    Then Verify the value of counter Watchlist found by counterName "<counterName>" : counterType "<counterType>" counterCode "<counterCode>" counterChart "<counterChart>" firstLabel "<fistLabel>" secondLabel "<secondLabel>" lastDonePrice "<lastDonePrice>" change "<Change>" changePCT "<Change%>" with showPrePostOption is "<showPrePostOption>" and scrollableHorizontal is "<scrollableHorizontal>" and landscapeMode is "<landscapeMode>"
    Examples:
      | TCID            | HolderUser         | watchlistGroup | counterName | counterType | counterCode | counterChart | fistLabel | secondLabel | lastDonePrice |Change   | Change%   | showPrePostOption | scrollableHorizontal | landscapeMode |
      | 024 025 026 028 | validAccountForCFD | AutoPre        | Apple Inc   | CFD         | not empty   | empty        | not empty | not empty   | not empty     |not empty| not empty | true              | true                 | false         |
      | 051             | validAccountForCFD | AutoPre        | DBS         | CFD         | not empty   | empty        | not empty | not empty   | not empty     |not empty| not empty | true              | true                 | false         |

  Scenario Outline:  <TCID> Check not show Pre market when turn off Watchlist setting (landscape mode)
    And Login with account "<HolderUser>"
    And Tap on Watchlist
    And Scroll to see WatchlistModule group "<watchlistGroup>"
    And Tap on WatchlistModule group "<watchlistGroup>"
    And Tap on WatchlistGroup icon Setting
    And Turn off WatchlistSetting tab Display icon ShowPreAndPostMarket
    And Tap on WatchlistSetting icon Back
    And Tap on WatchlistGroup icon Rotate
    And Scroll to see WatchlistGroup counter name "<counterName>"
    Then Verify the value of counter Watchlist found by counterName "<counterName>" : counterType "<counterType>" counterCode "<counterCode>" counterChart "<counterChart>" firstLabel "<fistLabel>" secondLabel "<secondLabel>" lastDonePrice "<lastDonePrice>" change "<Change>" changePCT "<Change%>" with showPrePostOption is "<showPrePostOption>" and scrollableHorizontal is "<scrollableHorizontal>" and landscapeMode is "<landscapeMode>"
    Examples:
      | TCID    | HolderUser         | watchlistGroup | counterName | counterType | counterCode | counterChart | fistLabel | secondLabel | lastDonePrice |Change | Change%   | showPrePostOption | scrollableHorizontal | landscapeMode |
      | 036 037 | validAccountForCFD | AutoPre        | Apple Inc   | CFD         | not empty   | empty        | not empty | not empty   | not empty     |not empty | not empty | false             | false                | true          |
      | 052     | validAccountForCFD | AutoPre        | DBS         | CFD         | not empty   | empty        | not empty | not empty   | not empty     |not empty | not empty | false             | false                | true          |

  Scenario Outline:  <TCID> : Check show Pre market when turn on Watchlist setting (landscape mode)
    And Login with account "<HolderUser>"
    And Tap on Watchlist
    And Scroll to see WatchlistModule group "<watchlistGroup>"
    And Tap on WatchlistModule group "<watchlistGroup>"
    And Tap on WatchlistGroup icon Setting
    And Turn on WatchlistSetting tab Display icon ShowPreAndPostMarket
    And Tap on WatchlistSetting icon Back
    And Tap on WatchlistGroup icon Rotate
    And Scroll to see WatchlistGroup counter name "<counterName>"
    Then Verify the value of counter Watchlist found by counterName "<counterName>" : counterType "<counterType>" counterCode "<counterCode>" counterChart "<counterChart>" firstLabel "<fistLabel>" secondLabel "<secondLabel>" lastDonePrice "<lastDonePrice>" change "<Change>" changePCT "<Change%>" with showPrePostOption is "<showPrePostOption>" and scrollableHorizontal is "<scrollableHorizontal>" and landscapeMode is "<landscapeMode>"
    Examples:
      | TCID            | HolderUser         | watchlistGroup | counterName | counterType | counterCode | counterChart | fistLabel | secondLabel | lastDonePrice |Change    | Change%   | showPrePostOption | scrollableHorizontal | landscapeMode |
      | 038 039 040 042 | validAccountForCFD | AutoPre        | Apple Inc   | CFD         | not empty   | empty        | not empty | not empty   | not empty     |not empty | not empty | true             | false                | true          |
      | 052             | validAccountForCFD | AutoPre        | DBS         | CFD         | not empty   | empty        | not empty | not empty   | not empty     |not empty | not empty | true             | false                | true          |

  Scenario Outline:  <TCID> : Check show Pre market when turn on Watchlist setting & turn on chart (portrait mode)
    And Login with account "<HolderUser>"
    And Tap on Watchlist
    And Scroll to see WatchlistModule group "<watchlistGroup>"
    And Tap on WatchlistModule group "<watchlistGroup>"
    And Tap on WatchlistGroup icon Setting
    And Turn on WatchlistSetting tab Display icon ShowPreAndPostMarket
    And Tap on WatchlistSetting icon Back
    And Turn on WatchlistGroup icon Chart
    And Scroll to see WatchlistGroup counter name "<counterName>"
    Then Verify the value of counter Watchlist found by counterName "<counterName>" : counterType "<counterType>" counterCode "<counterCode>" counterChart "<counterChart>" firstLabel "<fistLabel>" secondLabel "<secondLabel>" lastDonePrice "<lastDonePrice>" change "<Change>" changePCT "<Change%>" with showPrePostOption is "<showPrePostOption>" and scrollableHorizontal is "<scrollableHorizontal>" and landscapeMode is "<landscapeMode>"
    Examples:
      | TCID | HolderUser         | watchlistGroup | counterName | counterType | counterCode | counterChart | fistLabel | secondLabel | lastDonePrice |Change    | Change%   | showPrePostOption | scrollableHorizontal | landscapeMode |
      | 054  | validAccountForCFD | AutoPre        | Apple Inc   | CFD         | not empty   | not empty    | not empty | not empty   | not empty     |not empty | not empty | true              | false                | false         |

  Scenario Outline:  <TCID> :Check show Pre market when turn on Watchlist setting & turn on chart (horizontal mode)
    And Login with account "<HolderUser>"
    And Tap on Watchlist
    And Scroll to see WatchlistModule group "<watchlistGroup>"
    And Tap on WatchlistModule group "<watchlistGroup>"
    And Tap on WatchlistGroup icon Setting
    And Turn on WatchlistSetting tab Display icon ShowPreAndPostMarket
    And Tap on WatchlistSetting icon Back
    And Turn on WatchlistGroup icon Chart
    And Turn on WatchlistGroup icon ScrollableHorizontal
    And Scroll to see WatchlistGroup counter name "<counterName>"
    Then Verify the value of counter Watchlist found by counterName "<counterName>" : counterType "<counterType>" counterCode "<counterCode>" counterChart "<counterChart>" firstLabel "<fistLabel>" secondLabel "<secondLabel>" lastDonePrice "<lastDonePrice>" change "<Change>" changePCT "<Change%>" with showPrePostOption is "<showPrePostOption>" and scrollableHorizontal is "<scrollableHorizontal>" and landscapeMode is "<landscapeMode>"
    Examples:
      | TCID | HolderUser         | watchlistGroup | counterName | counterType | counterCode | counterChart | fistLabel | secondLabel | lastDonePrice |Change    | Change%   | showPrePostOption | scrollableHorizontal | landscapeMode |
      | 053  | validAccountForCFD | AutoPre        | Apple Inc   | CFD         | not empty   | not empty    | not empty | not empty   | not empty     |not empty | not empty | true              | true                 | false         |

  Scenario Outline:  <TCID> : Check show Pre market when turn on Watchlist setting & turn on chart (Landscape mode)
    And Login with account "<HolderUser>"
    And Tap on Watchlist
    And Scroll to see WatchlistModule group "<watchlistGroup>"
    And Tap on WatchlistModule group "<watchlistGroup>"
    And Tap on WatchlistGroup icon Setting
    And Turn on WatchlistSetting tab Display icon ShowPreAndPostMarket
    And Tap on WatchlistSetting icon Back
    And Turn on WatchlistGroup icon Chart
    And Turn on WatchlistGroup icon ScrollableHorizontal
    And Tap on WatchlistGroup icon Rotate
    And Scroll to see WatchlistGroup counter name "<counterName>"
    Then Verify the value of counter Watchlist found by counterName "<counterName>" : counterType "<counterType>" counterCode "<counterCode>" counterChart "<counterChart>" firstLabel "<fistLabel>" secondLabel "<secondLabel>" lastDonePrice "<lastDonePrice>" change "<Change>" changePCT "<Change%>" with showPrePostOption is "<showPrePostOption>" and scrollableHorizontal is "<scrollableHorizontal>" and landscapeMode is "<landscapeMode>"
    Examples:
      | TCID | HolderUser         | watchlistGroup | counterName | counterType | counterCode | counterChart | fistLabel | secondLabel | lastDonePrice | Change%   | showPrePostOption | scrollableHorizontal | landscapeMode |
      | 054  | validAccountForCFD | AutoPre        | Apple Inc   | CFD         | not empty   | not empty    | not empty | not empty   | not empty     | not empty | true              | false                | true          |

  Scenario Outline:  <TCID> : Navigate to screen CounterDetail when clicking on counter row
    And Login with account "<HolderUser>"
    And Tap on Watchlist
    And Scroll to see WatchlistModule group "<watchlistGroup>"
    And Tap on WatchlistModule group "<watchlistGroup>"
    And Tap on WatchlistGroup icon Setting
    And Turn on WatchlistSetting tab Display icon ShowPreAndPostMarket
    And Tap on WatchlistSetting icon Back
    And Scroll to see WatchlistGroup counter name "<counterName>"
    And Tap on WatchlistGroup counter name "<counterName>"
    Then Verify the display of the screen "CounterDetai" is "true"
    Examples:
      | TCID | HolderUser         | watchlistGroup | counterName |
      | 021  | validAccountForCFD | AutoPre        | Apple Inc   |