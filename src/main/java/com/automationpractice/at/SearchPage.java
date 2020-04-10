package com.automationpractice.at;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchPage extends BaseActions{
    private static final By INFORMATION_SEARCH = By.cssSelector(".product-count");
    private static final By NEGATIVE_INFORMATION1_SEARCH = By.cssSelector(".alert.alert-warning");
    private static final By NEGATIVE_INFORMATION2_SEARCH = By.cssSelector(".heading-counter");

    public SearchPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public String getTextSearchInformation(){
        WebElement element = driver.findElement(INFORMATION_SEARCH);
        return element.getText();
    }
    public String getTextSearchInformation1Negative(){
        WebElement element = driver.findElement(NEGATIVE_INFORMATION1_SEARCH);
        return element.getText();
    }
    public String getTextSearchInformation2Negative(){
        WebElement element = driver.findElement(NEGATIVE_INFORMATION2_SEARCH);
        return element.getText();
    }
}
