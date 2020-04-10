package com.automationpractice.at;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
public abstract class BaseActions {
    protected WebDriver driver;
    protected WebDriverWait wait;
    // конструктор абстрактного класса
    public BaseActions(WebDriver driver, WebDriverWait wait){
        this.driver = driver;
        this.wait = wait;
    }
    //метод введения текста text в поле, найденное по локатору by
    public void inputText(By by, String text){
        wait.until(ExpectedConditions.presenceOfElementLocated(by)); //ждем пока элемент не появится
        WebElement element = driver.findElement(by); //Находим элемент по by
        element.click();//нажимает на поле
        element.clear();//очищает поле
        element.sendKeys(text);// вводит текст
    }
    // метод проверки существования элемента
    public boolean isElementPresent(By by){
        try{
            driver.findElement(by);
            return true;// если элемент существует то метод возвращает true
        }catch (NoSuchElementException e){//если елемент не найден то мы ловим ошибку и возвращаем false
            return false;
        }


            }

}
