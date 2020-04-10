package com.automationpractice.at;

import org.junit.Assert;
import org.junit.Test;

import static java.lang.Thread.sleep;
// 1.Перейти на сайт http://automationpractice.com/
// 2. в строке поиска набрать ввести данные (см. ниже)
//3. нажать на кнопку поиск
// вводные данные       ожидаемый результат
// Dress                количество товаров от 2 до 10
//Blouse                Количество товаров от 1 до 10
//Summer Dress          Количество товаров от 1 до 10
//Платье                Присутствует надпись "No results were found for your search "платье" и "0 results have been found."




public class SearchTest extends BaseTest{

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
        Assert.assertTrue(count < 10);
        Assert.assertTrue(count > 2);

        Thread.sleep(1000);
    }
    @Test
    public void searchBlouse() throws InterruptedException{
        String text;
        mainPagе.home();
        mainPagе.startSearch("Blouse");
        //System.out.println(searchPage.getTextSearchInformation());

        text = searchPage.getTextSearchInformation();
        String[] token = text.split(" ");
        int count = Integer.parseInt(token[5]);
        Assert.assertTrue(count < 10);
        Assert.assertTrue(count > 0);

        Thread.sleep(1000);
    }

    @Test
    public void searchSummerDress() throws InterruptedException{
        String text;
        mainPagе.home();
        mainPagе.startSearch("Summer Dress");
        //System.out.println(searchPage.getTextSearchInformation());

        text = searchPage.getTextSearchInformation();
        String[] token = text.split(" ");
        int count = Integer.parseInt(token[5]);
        Assert.assertTrue(count < 10);
        Assert.assertTrue(count > 0);

        Thread.sleep(1000);
    }
    @Test
    public void searchNegative() throws InterruptedException{
        String text;
        mainPagе.home();
        mainPagе.startSearch("Платья");
        System.out.println(searchPage.getTextSearchInformation1Negative());
        System.out.println(searchPage.getTextSearchInformation2Negative());

        Assert.assertEquals(searchPage.getTextSearchInformation1Negative(),"No results were found for your search \"Платья\"");
        Assert.assertEquals(searchPage.getTextSearchInformation2Negative(),"0 results have been found.");


        Thread.sleep(1000);
    }
}

