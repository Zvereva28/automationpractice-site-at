package com.automationpractice.at;

import org.junit.Assert;
import org.junit.Test;

public class AuthenticationTest extends BaseTest{
    // 1.Перейти на сайт http://automationpractice.com/
// 2. нажать на кнопку "Sign in"
//3. Ввести данные в поле Email address
// 4. Ввести данные в поле Password
// 5.Нажать на кнопку "Sign in"
// вводные данныеEmail     вводные данныеPassword        ожидаемый результат
//1236                        12365                       There is 1 error
//                                                          Invalid email address.
// 123@2365.ru                 ddhj                         There is 1 error
//                                                           Invalid password.





    @Test
    public void NegativeAuth1() throws InterruptedException{
        String text;
        mainPagе.home();
        mainPagе.SignInStart();
        authenticationPage.SignInProcess("1236","12365");


        text = authenticationPage.getTextInformationNegative();

        Assert.assertTrue(text.startsWith("There is 1 error"));
        Assert.assertTrue(text.endsWith("Invalid email address."));
        Thread.sleep(1000);
    }

    @Test
    public void NegativeAuth2() throws InterruptedException{
        String text;
        mainPagе.home();
        mainPagе.SignInStart();
        authenticationPage.SignInProcess("123@2365.ru","ddhj");


        text = authenticationPage.getTextInformationNegative();

        Assert.assertTrue(text.startsWith("There is 1 error"));
        Assert.assertTrue(text.endsWith("Invalid password."));
        Thread.sleep(1000);
    }
}
