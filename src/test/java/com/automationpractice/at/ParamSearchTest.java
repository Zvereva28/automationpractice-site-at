package com.automationpractice.at;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
@DisplayName("Проверка системы поиска(параметризованная)")
public class ParamSearchTest extends BaseTest {
    @ParameterizedTest
    @MethodSource("stringAndIntProvider")
    @DisplayName("Позитивные тесты с корректными данными")
    void PositiveSearchTest(String wordSearch, int first, int second) {
        String text;
       mainPagе.home();
       mainPagе.startSearch(wordSearch);
       //System.out.println(searchPage.getTextSearchInformation());

      text = searchPage.getTextSearchInformation();
       String[] token = text.split(" ");
       int count = Integer.parseInt(token[5]);
        assertTrue(count < first);
        assertTrue(count > second, "количество " + wordSearch + " меньше или равно " + second);

    }

    static Stream<Arguments> stringAndIntProvider() {
        return Stream.of(Arguments.of("Dress", 10, 2), Arguments.of("Blouse", 10, 0), Arguments.of("Summer Dress", 10, 1));
    }
    //
    //
    //
//    @ParameterizedTest
//    @MethodSource("stringProvider")
//    @DisplayName("Негативные тесты с НЕ корректными данными")
//    @Test
//    void NegativeSearchTest(String wordSearch) {
//        mainPagе.home();
//        mainPagе.startSearch(wordSearch);
//        //System.out.println(searchPage.getTextSearchInformation());
//        assertEquals(searchPage.getTextSearchInformation1Negative(), "No results were found for your search \""+ wordSearch +"\"");
//        assertEquals(searchPage.getTextSearchInformation2Negative(), "0 results have been found.");
//
//
//    }
//
//    static Stream<Arguments> stringProvider() {
//        return Stream.of(Arguments.of("3695"), Arguments.of("1236548"), Arguments.of("gfshh Dress"));
    }






//    public static Collection<Object[]> data() {
//        return Arrays.asList(new Object[][]{
//                {"Dress", 10, 2},
//                {"Blouse", 10, 0},
//                {"Summer Dress", 10, 0},
//        });
//
//    }
//    private String a;
//    private int b, c;
//
//    public ParamSearchTest(String a, int b, int c) {
//        this.a = a;
//        this.b = b;
//        this.c = c;
//
//    }
//    @Test
//    public void PositiveSearchTest(){
//        String text;
//        mainPagе.home();
//        mainPagе.startSearch(a);
//        //System.out.println(searchPage.getTextSearchInformation());
//
//        text = searchPage.getTextSearchInformation();
//        String[] token = text.split(" ");
//        int count = Integer.parseInt(token[5]);
//        Assert.assertTrue(count < b);
//        Assert.assertTrue(count > c);
//
//    }

