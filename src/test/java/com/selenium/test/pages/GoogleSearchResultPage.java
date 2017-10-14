package com.selenium.test.pages;

import com.selenium.test.webtestsbase.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

import java.util.List;
import java.util.NoSuchElementException;

public class GoogleSearchResultPage extends BasePage{


    @FindBy(className="_Rm")
    private WebElement contentElement;

    @FindBys({@FindBy(className="_Rm")})
    private List<WebElement> contentElements;


    public GoogleSearchResultPage(){
        super(true);
    }

    public GoogleSearchResultPage(boolean openPageByUrl) {
        super(openPageByUrl);
    }

    @Override
    protected void openPage() {
        //do nothing
    }

    @Override
    public boolean isPageOpened() {
        try {
            return contentElement.isDisplayed();
        } catch (NoSuchElementException e){
            return false;
        }
    }
    public int numberOfLinks() {
        return contentElements.size();
    }
}
