package com.selenium.test.pages;

import com.selenium.test.webtestsbase.BasePage;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;

public class GooglePage extends BasePage {

    private static final String PAGE_URL = "http://google.com";
    private static final String SEL_NAME = "q";

    @FindBy(name = SEL_NAME)
    private WebElement searchForm;

    @Override
    public boolean isPageOpened() {
        return searchForm.isDisplayed();
    }

    public GooglePage()  {
    super(true);
}
    protected void openPage() {getDriver().get(PAGE_URL);}

    public void inputText(String arg){
        WebElement searchForm = getDriver().findElement(By.name(SEL_NAME));
        searchForm.sendKeys(arg);
    }

    public GoogleSearchResultPage doSearch (){
        searchForm.submit();
        return new GoogleSearchResultPage();
    }
}
