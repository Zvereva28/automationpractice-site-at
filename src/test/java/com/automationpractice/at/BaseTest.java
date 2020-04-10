package com.automationpractice.at;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseTest {
    private WebDriver driver;
    private WebDriverWait wait;
    protected MainPagе mainPagе;
    protected SearchPage searchPage;
    protected AuthenticationPage authenticationPage;


    @Before// перед запуском каждлго теста
    public void  init(){
        driver = new ChromeDriver(); // открываем Хром
        driver.manage().window().maximize();//разворачиваем окно на весь экран
        wait = new WebDriverWait(driver,5); // каждое действие будет "делаться" в течении 5 секунд и только потом "падать"
        mainPagе = new MainPagе(driver,wait);// создаем экземпляры каждого класса, что бы иметь возможность обратиться к элементам каждой страницы
        searchPage = new SearchPage(driver,wait);
        authenticationPage = new AuthenticationPage(driver, wait);

    }
    @After
    public void shutdown(){
        driver.quit();
    }
}
