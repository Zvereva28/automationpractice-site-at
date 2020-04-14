package com.automationpractice.at;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import javax.xml.namespace.QName;

import static java.lang.Thread.sleep;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
// 1.Перейти на сайт http://automationpractice.com/
// 2. в строке поиска набрать ввести данные (см. ниже)
//3. нажать на кнопку поиск
// вводные данные       ожидаемый результат
// Dress                количество товаров от 2 до 10
//Blouse                Количество товаров от 1 до 10
//Summer Dress          Количество товаров от 1 до 10
//Платье                Присутствует надпись "No results were found for your search "платье" и "0 results have been found."



@DisplayName("Проверка системы поиска")
public class SearchTest extends BaseTest{
    @DisplayName("Корректное значение Dress")
    @Test
    public void searchDress() throws InterruptedException{
        String text;
        String[] token;
        int count;
        mainPagе.home();
        mainPagе.startSearch("Dress");
        //System.out.println(searchPage.getTextSearchInformation());

        text = searchPage.getTextSearchInformation();
        token = text.split(" ");
        count = Integer.parseInt(token[5]);
        Assertions.assertTrue(count < 10);
        Assertions.assertTrue(count > 2);

        Thread.sleep(1000);
    }
    @DisplayName("Корректное значение Blouse")
    @Test
    public void searchBlouse() throws InterruptedException{
        String text;
        mainPagе.home();
        mainPagе.startSearch("Blouse");
        //System.out.println(searchPage.getTextSearchInformation());

        text = searchPage.getTextSearchInformation();
        String[] token = text.split(" ");
        int count = Integer.parseInt(token[5]);
        Assertions.assertTrue(count < 10);
        Assertions.assertTrue(count > 0);

        Thread.sleep(1000);
    }
    @DisplayName("Корректное значение Summer Dress")
    @Test
    public void searchSummerDress() throws InterruptedException{
        String text;
        mainPagе.home();
        mainPagе.startSearch("Summer Dress");
        //System.out.println(searchPage.getTextSearchInformation());

        text = searchPage.getTextSearchInformation();
        String[] token = text.split(" ");
        int count = Integer.parseInt(token[5]);
        assertThat(count, lessThan(2));
        assertThat(count, greaterThan(0));

        Thread.sleep(1000);
    }
    @DisplayName("Не корректное значение \"Платья\"")
  //  @RepeatedTest(value = 2)
   @Test
    public void searchNegative() throws InterruptedException{
        String text;
        mainPagе.home();
        mainPagе.startSearch("Платья");
//        System.out.println(searchPage.getTextSearchInformation1Negative());
//        System.out.println(searchPage.getTextSearchInformation2Negative());

       assertThat(searchPage.getTextSearchInformation1Negative(),equalToIgnoringCase("No results were found for your search \"Платья\""));
        Assertions.assertEquals(searchPage.getTextSearchInformation2Negative(),"0 results have been found.");


        Thread.sleep(1000);
    }
}

