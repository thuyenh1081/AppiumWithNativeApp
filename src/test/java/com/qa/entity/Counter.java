package com.qa.entity;

public class Counter {
    private static String CounterType;
    private static String CounterName;
    private static String CounterCode;
    private static String DelayImg;
    private static String ChartImg;
    private static String FirstLabel;
    private static String SecondLabel;
    private static String pmpFirstData;
    private static String pmpSecondData;

    public static String getCounterType() {
        return CounterType;
    }

    public static void setCounterType(String counterType) {
        CounterType = counterType;
    }

    public static String getCounterName() {
        return CounterName;
    }

    public static void setCounterName(String counterName) {
        CounterName = counterName;
    }

    public static String getCounterCode() {
        return CounterCode;
    }

    public static void setCounterCode(String counterCode) {
        CounterCode = counterCode;
    }

    public static String getDelayImg() {
        return DelayImg;
    }

    public static void setDelayImg(String delayImg) {
        DelayImg = delayImg;
    }

    public static String getChartImg() {
        return ChartImg;
    }

    public static void setChartImg(String chartImg) {
        ChartImg = chartImg;
    }

    public static String getFirstLabel() {
        return FirstLabel;
    }

    public static void setFirstLabel(String FirstLabel) {
        Counter.FirstLabel = FirstLabel;
    }

    public static String getSecondLabel() {
        return SecondLabel;
    }

    public static void setSecondLabel(String SecondLabel) {
        Counter.SecondLabel = SecondLabel;
    }

    public static String getLastDonePrice() {
        return pmpFirstData;
    }

    public static void setLastDonePrice(String lastDonePrice) {
        pmpFirstData = lastDonePrice;
    }

    public static String getChangePercent() {
        return pmpSecondData;
    }

    public static void setChangePercent(String changePercent) {
        pmpSecondData = changePercent;
    }

    public void resetAllValue()
    {
        CounterType = "";
        CounterName = "";
        CounterCode = "";
        DelayImg = "";
        FirstLabel = "";
        SecondLabel = "";
        pmpFirstData = "";
        pmpSecondData = "";
    }

}
