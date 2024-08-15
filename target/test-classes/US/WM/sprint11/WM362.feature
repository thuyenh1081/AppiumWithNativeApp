@WM362
Feature: dien han ten cua feature vao day

  Background:
    Given Login page is open

  Scenario Outline:  Verify UI [Deposit] screen with status
    And Login with account "<HolderUser>"
    And Tap on Trade
    And Scroll to see TradeModule type "Robo"
    And Tap on TradeModule type "Robo"
    And Scroll to see RoboTrade"<RoboAccount>"
    And Tap on RoboTrade icon "<RoboAccount>"
    And Tap on RoboTrade icon Cash
    And Tap on RoboTrade icon Deposit
    And Tap on RoboTrade icon PayNow
    Then Verify the display of screen PayNow is "true"
    Examples:
      |HolderUser|RoboAccount|
      |validAccountForRobo|RoboAccountWithApprovedStatus|

  Scenario Outline: Verify can go to [PayNow] screen with Submitted status account
    And Login with account "<HolderUser>"
    And Tap on Trade
    And Scroll to see TradeModule type "Robo"
    And Tap on TradeModule type "Robo"
    And Scroll to see RoboTrade"<RoboAccount>"
    And Tap on RoboTrade icon "<RoboAccount>"
    And Tap on RoboTrade icon Deposit
#      Hình như thiếu button Deposit với trạng thái Pending Appreved ấy bác
    Then Verify the display of screen PayNow is "true"
    Examples:
      |HolderUser|RoboAccount|
      |validAccountForRobo|AccountRoboPendingApprovedCash|

#  case nay nen check default display cua screen PayNow gồm có các thành phần là gì, mesage.....
  Scenario Outline: <TCID><RoboAccount> Check default message about minimum value of Amount
    And Login with account "<HolderUser>"
    And Tap on Trade
    And Scroll to see TradeModule type "Robo"
    And Tap on TradeModule type "Robo"
    And Scroll to see RoboTrade"<RoboAccount>"
    And Tap on RoboTrade icon "<RoboAccount>"
    And Tap on RoboTrade icon Cash
    And Tap on RoboTrade icon Deposit
    And Tap on RoboTrade icon PayNow
    Then Verify value PayNow message amount is "<message>"
    Examples:
      |TCID|HolderUser|RoboAccount|message|
      |TC_Robo-Deposit(Cash)_009|validAccountForRobo|AccountRoboApprovedCashR1|Minimum amount is SGD 300.00|
      |TC_Robo-Deposit(Cash)_010|validAccountForRobo|AccountRoboApprovedCashR2|Minimum amount is SGD 300.00|
      |TC_Robo-Deposit(Cash)_011|validAccountForRobo|AccountRoboApprovedCashR3GI|Minimum amount is SGD 300.00|
      |TC_Robo-Deposit(Cash)_012|validAccountForRobo|AccountRoboApprovedCashR3US|Minimum amount is SGD 3000.00|
      |TC_Robo-Deposit(Cash)_013|validAccountForRobo|AccountRoboApprovedCash45663US|Minimum amount is SGD 3000.00|

  Scenario Outline: Check data in dropdown list
    And Login with account "<HolderUser>"
    And Tap on Trade
    And Scroll to see TradeModule type "Robo"
    And Tap on TradeModule type "Robo"
    And Scroll to see RoboTrade"<RoboAccount>"
    And Tap on RoboTrade icon "<RoboAccount>"
    And Tap on RoboTrade icon Cash
    And Tap on RoboTrade icon Deposit
    And Tap on RoboTrade icon PayNow
    And Tap on PayNow textBox TransferAccount
    Then //duw lieeujd dungs loaij
    Then Verify the sorting of PayNow list of Account is correct
    Examples:
      |HolderUser|RoboAccount|
      |validAccountForRobo|AccountRoboApprovedCashR1|

  Scenario Outline:Check the order of list accoutn when choosing account in the bottom
    And Login with account "<HolderUser>"
    And Tap on Trade
    And Scroll to see TradeModule type "Robo"
    And Tap on TradeModule type "Robo"
    And Scroll to see RoboTrade"<RoboAccount>"
    And Tap on RoboTrade icon "<RoboAccount>"
    And Tap on RoboTrade icon Cash
    And Tap on RoboTrade icon Deposit
    And Tap on RoboTrade icon PayNow
    And Tap on PayNow textBox TransferAccount
    And Scroll to see PayNow dropDownList Account"<AccountForTransfer>"
    And Tap on PayNow dropDownList account "<AccountForTransfer>"
    And Tap on PayNow textBox TransferAccount
    Then Verify the sorting of PayNow list of Account is correct
    Examples:
      |HolderUser|RoboAccount|AccountForTransfer|
      |validAccountForRobo|AccountRoboApprovedCashR1|AccountForTransfer|

  Scenario Outline:Check behavior of amount textbox
    And Login with account "<HolderUser>"
    And Tap on Trade
    And Scroll to see TradeModule type "Robo"
    And Tap on TradeModule type "Robo"
    And Scroll to see RoboTrade"<RoboAccount>"
    And Tap on RoboTrade icon "<RoboAccount>"
    And Tap on RoboTrade icon Cash
    And Tap on RoboTrade icon Deposit
    And Tap on RoboTrade icon PayNow
    Then Verify editable PayNow textBox Amount is "true"
    Then Verify just could be input number PayNow textBox Amount
    Examples:
      |HolderUser|RoboAccount|
      |validAccountForRobo|AccountRoboApprovedCashR1|

  Scenario Outline: Validate value of textBox Amount
    And Login with account "<HolderUser>"
    And Tap on Trade
    And Scroll to see TradeModule type "Robo"
    And Tap on TradeModule type "Robo"
    And Scroll to see RoboTrade"<RoboAccount>"
    And Tap on RoboTrade icon "<RoboAccount>"
    And Tap on RoboTrade icon Cash
    And Tap on RoboTrade icon Deposit
    And Tap on RoboTrade icon PayNow
    And Enter PayNow textBox amount "<overMax>"
    Then Verify enable PayNow button Continue is "true"
    And Enter PayNow textBox amount "<max>"
    Then Verify enable PayNow button Continue is "false"
    And Enter PayNow textBox amount "<min>"
    Then Verify enable PayNow button Continue is "true"
    And Enter PayNow textBox amount "<underMin>"
    Then Verify enable PayNow button Continue is "false"
    And Enter PayNow textBox amount "<middle>"
    Then Verify enable PayNow button Continue is "false"
    Examples:
      |HolderUser|RoboAccount|max|min|overMax|underMin|middle|
      |validAccountForRobo|AccountRoboApprovedCashR1|200000|300|2000001|299.99|150000|
      |validAccountForRobo|AccountRoboApprovedCashR2|200000|300|2000001|299.99|150000|
      |validAccountForRobo|AccountRoboApprovedCashR3GI|200000|300|2000001|299.99|150000|
      |validAccountForRobo|AccouxntRoboApprovedCashR3US|200000|3000|200001|2999.99|1000 |

  Scenario Outline:  Check format of text box amount
    And Login with account "<HolderUser>"
    And Tap on Trade
    And Scroll to see TradeModule type "Robo"
    And Tap on TradeModule type "Robo"
    And Scroll to see RoboTrade"<RoboAccount>"
    And Tap on RoboTrade icon "<RoboAccount>"
    And Tap on RoboTrade icon Cash
    And Tap on RoboTrade icon Deposit
    And Tap on RoboTrade icon PayNow
    And Enter PayNow textBox amount "<amount>"
    Then Verify format PayNow textBox amount is "<format>"
    Examples:
      |HolderUser|RoboAccount|amount|format|
      |validAccountForRobo|AccountRoboApprovedCashR3US|234.2|234.20|
      |validAccountForRobo|AccountRoboApprovedCashR3US|89.90|89.90|
      |validAccountForRobo|AccountRoboApprovedCashR3US|89.999|89.99|

  Scenario Outline: Check action of Back button on the screen PayNow
    And Login with account "<HolderUser>"
    And Tap on Trade
    And Scroll to see TradeModule type "Robo"
    And Tap on TradeModule type "Robo"
    And Scroll to see RoboTrade"<RoboAccount>"
    And Tap on RoboTrade icon "<RoboAccount>"
    And Tap on RoboTrade icon Cash
    And Tap on RoboTrade icon Deposit
    And Tap on RoboTrade icon PayNow
    And Tap on PayNow icon Back
    Then Verify the display of screen RoboTrade is "true"
    Examples:
      |HolderUser|RoboAccount|
      |validAccountForRobo|AccountRoboApprovedCashR3US|

  Scenario Outline:  sua lai desscription
    And Login with account "<HolderUser>"
    And Tap on Trade
    And Scroll to see TradeModule type "Robo"
    And Tap on TradeModule type "Robo"
    And Scroll to see RoboTrade"<RoboAccount>"
    And Tap on RoboTrade icon "<RoboAccount>"
    And Tap on RoboTrade icon Cash
    And Tap on RoboTrade icon Deposit
    And Tap on RoboTrade icon PayNow
    And Enter PayNow textBox amount "89.90"
    And Tap on PayNow icon Continue
    Then Verify the display of QRCode is "true"
    Examples:
      |HolderUser|RoboAccount|
      |validAccountForRobo|AccountRoboApprovedCashR3US|

  Scenario Outline:  Check default display of screen QRCode
    And Login with account "<HolderUser>"
    And Tap on Trade
    And Scroll to see TradeModule type "Robo"
    And Tap on TradeModule type "Robo"
    And Scroll to see RoboTrade"<RoboAccount>"
    And Tap on RoboTrade icon "<RoboAccount>"
    And Tap on RoboTrade icon Cash
    And Tap on RoboTrade icon Deposit
    And Tap on RoboTrade icon PayNow
    And Enter PayNow textBox amount "<amount>"
    And Tap on PayNow icon Continue
    Then Verify value QRCode message QRCodeMessage
    Then Verify value QRCode field DepositAmount is "<amount>"
#    Then Verify value QRCode label ReferenNo is "<ReferenNo>"
    Then Verify value QRCode Amount is "<amount>"
    Then Verify value QRCode field UEN is "<UEN>"
    Then Verify value QRCode message QRCodeGuide is "<QRCodeGuide>"
    Examples:
      |HolderUser|RoboAccount|amount|QRCodeMessage|ReferenNo|QRCodeGuide|UEN|
      |validAccountForRobo|AccountRoboApprovedCashR3US|89.90|QRCodeMessage|fsfsd|QRCodeGuide$|UEN|

  Scenario Outline:  Check action of Back button on the screen QRCode
    And Login with account "<HolderUser>"
    And Tap on Trade
    And Scroll to see TradeModule type "Robo"
    And Tap on TradeModule type "Robo"
    And Scroll to see RoboTrade"<RoboAccount>"
    And Tap on RoboTrade icon "<RoboAccount>"
    And Tap on RoboTrade icon Cash
    And Tap on RoboTrade icon Deposit
    And Tap on RoboTrade icon PayNow
    And Enter PayNow textBox amount "89.90"
    And Tap on PayNow icon Continue
    And Tap on QRCode icon Back
    Then Verify the display of screen PayNow is "true"
    Examples:
      |HolderUser|RoboAccount|
      |validAccountForRobo|AccountRoboApprovedCashR3US|

  Scenario Outline:  Check Save QR code button successfully
    And Login with account "<HolderUser>"
    And Tap on Trade
    And Scroll to see TradeModule type "Robo"
    And Tap on TradeModule type "Robo"
    And Scroll to see RoboTrade"<RoboAccount>"
    And Tap on RoboTrade icon "<RoboAccount>"
    And Tap on RoboTrade icon Cash
    And Tap on RoboTrade icon Deposit
    And Tap on RoboTrade icon PayNow
    And Enter PayNow textBox amount "89.90"
    And Tap on PayNow icon Continue
    And Tap on QRCode button SaveQRCode
    Then Verify value QRCode icon toast is "<toast>"
    Then Verify saving QRCode icon QRCodeImage
    Examples:
      |HolderUser|RoboAccount|toast|
      |validAccountForRobo|AccountRoboApprovedCashR3US|success_payNow_toast|

  Scenario Outline:  Check Save QR code button unsuccessfully
    And Login with account "<HolderUser>"
    And Tap on Trade
    And Scroll to see TradeModule type "Robo"
    And Tap on TradeModule type "Robo"
    And Scroll to see RoboTrade"<RoboAccount>"
    And Tap on RoboTrade icon "<RoboAccount>"
    And Tap on RoboTrade icon Cash
    And Tap on RoboTrade icon Deposit
    And Tap on RoboTrade icon PayNow
    And Enter PayNow textBox amount "89.90"
    And Tap on PayNow icon Continue
    Then Verify value QRCode icon toast incase no internet is "<toast>"
    Then Verify saving QRCode icon QRCodeImage
    Examples:
      |HolderUser|RoboAccount|toast|
      |validAccountForRobo|AccountRoboApprovedCashR3US|no_internet_toast|

  Scenario Outline:   Check show pop-up with the  first login app
    And Login with account "<HolderUser>"
    And Tap on Trade
    And Scroll to see TradeModule type "Robo"
    And Tap on TradeModule type "Robo"
    And Scroll to see RoboTrade"<RoboAccount>"
    And Tap on RoboTrade icon "<RoboAccount>"
    And Tap on RoboTrade icon Cash
    And Tap on RoboTrade icon Deposit
    And Tap on RoboTrade icon PayNow
    And Enter PayNow textBox amount "89.90"
    And Tap on PayNow icon Continue
    And Tap on QRCode button SaveQRCode
    Then Verify the display of Popup PhotoAccessPermission is "true"
    Examples:
      |HolderUser|RoboAccount|
      |validAccountForRobo|AccountRoboApprovedCashR3US|