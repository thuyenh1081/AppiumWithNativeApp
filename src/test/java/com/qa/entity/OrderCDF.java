package com.qa.entity;

public class OrderCDF {
    private static String LimitPrice;
    private static String Quantity;
    private static String Validity;
    private static String GrossContractValue;
    private static String MarginRequirement;
    private static String AccountNumber;
    private static String CashBalance;
    private static String ExposureLimitLeft;
    private static int totalOfOrder;

    public int getTotalOfOrder() {
        return totalOfOrder;
    }

    public void setTotalOfOrder(int totalOfOrder) {
        OrderCDF.totalOfOrder = totalOfOrder;
    }

    public String getLimitPrice() {
        return LimitPrice;
    }

    public void setLimitPrice(String limitPrice) {
        LimitPrice = limitPrice;
    }

    public String getQuantity() {
        return Quantity;
    }

    public void setQuantity(String quantity) {
        Quantity = quantity;
    }

    public String getValidity() {
        return Validity;
    }

    public void setValidity(String validity) {
        Validity = validity;
    }

    public String getGrossContractValue() {
        return GrossContractValue;
    }

    public void setGrossContractValue(String grossContractValue) {
        GrossContractValue = grossContractValue;
    }

    public String getMarginRequirement() {
        return MarginRequirement;
    }

    public void setMarginRequirement(String marginRequirement) {
        MarginRequirement = marginRequirement;
    }

    public String getAccountNumber() {
        return AccountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        AccountNumber = accountNumber;
    }

    public String getCashBalance() {
        return CashBalance;
    }

    public void setCashBalance(String cashBalance) {
        CashBalance = cashBalance;
    }

    public String getExposureLimitLeft() {
        return ExposureLimitLeft;
    }

    public void setExposureLimitLeft(String exposureLimitLeft) {
        ExposureLimitLeft = exposureLimitLeft;
    }

    public void resetAllValue()
    {
        LimitPrice = "";
        Quantity = "";
        Validity = "";
        GrossContractValue = "";
        MarginRequirement = "";
        AccountNumber = "";
        CashBalance = "";
        ExposureLimitLeft = "";
    }
}
