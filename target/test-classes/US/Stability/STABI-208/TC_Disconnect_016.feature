#@Stabi208
Feature:Check landscape mode
  Background:
    Given Login page is open

  Scenario Outline: <TCID> : Check landscape mode
    And Login with account "<HolderUser>"
    And Switch to landscape mode for the "<screen>"
    And Turn off Wifi mode
    Then Verify value footer is "<message>"
    Examples:
      |TCID|HolderUser|screen|message|
      |TC_Disconnect_016|validAccountForRobo|Watchlist|Footer_DisConnectInternet|

#    case nay nghĩ là chỉ nên check đén đây, không nên check hoạt động bt là thế nào