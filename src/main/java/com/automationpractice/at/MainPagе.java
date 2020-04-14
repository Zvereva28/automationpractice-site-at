package com.automationpractice.at;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.xml.bind.Element;


public class MainPagе extends BaseActions {

    private static final String HOMEPAGE_URL = "http://automationpractice.com/";
    private static final By SEARCH_FIELD_SELECTOR = By.cssSelector("#search_query_top");
    private static final By SEARCH_BUTTON_SELECTOR = By.cssSelector(".btn.btn-default.button-search");
    private static final By SIGN_IN_BUTTON_SELECTOR = By.cssSelector(".login");

    public MainPagе(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }
    public void home(){//метод выхода на главную страницу
        driver.get(HOMEPAGE_URL);
    }

    public void startSearch (String textSearch ){
        inputText(SEARCH_FIELD_SELECTOR, textSearch);
        WebElement element = driver.findElement(SEARCH_BUTTON_SELECTOR); //Находим кнопку поиска
        element.click();
    }

    public void SignInStart (){
        WebElement element = driver.findElement(SIGN_IN_BUTTON_SELECTOR); //Находим кнопку
        element.click();
    }


}
