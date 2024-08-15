package com.qa.pages.watchlist;

import com.qa.pages.CommonContentPage;
import org.openqa.selenium.WebElement;

public class CounterTable extends CommonContentPage {
    WebElement parent;
    public CounterTable(WebElement counterTable)
    {
        parent = counterTable;
    }
}
