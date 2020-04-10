package com.automationpractice.at;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AuthenticationPage extends BaseActions{
    public AuthenticationPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    private static final String AUTHENTICATION_URL = "http://automationpractice.com/index.php?controller=authentication&back=my-account";
    private static final By EMAIL_FIELD_SELECTOR = By.cssSelector("#email");
    private static final By PASSWORD_FIELD_SELECTOR = By.cssSelector("#passwd");
    private static final By BUTTON_SIGN_IN_SELECTOR = By.cssSelector(".icon-lock.left");
    private static final By NEGATIVE_INFORMATION_AUTHENTICATION = By.xpath("//*[@id=\"center_column\"]/div[1]");


    public void SignInProcess(String email, String password ){
        inputText(EMAIL_FIELD_SELECTOR, email);
        inputText(PASSWORD_FIELD_SELECTOR, password);
        WebElement element = driver.findElement(BUTTON_SIGN_IN_SELECTOR); //Находим кнопку поиска
        element.click();
    }
    public String getTextInformationNegative(){
        return driver.findElement(NEGATIVE_INFORMATION_AUTHENTICATION).getText();}






}
