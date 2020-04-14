package com.automationpractice.at;




import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

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




@Timeout(2)
    @Test
    public void NegativeAuth1() throws InterruptedException{
        String text;
        mainPagе.home();
        mainPagе.SignInStart();
        authenticationPage.SignInProcess("1236","12365");


        text = authenticationPage.getTextInformationNegative();

    Assertions.assertTrue(text.startsWith("There is 1 error"));
    Assertions.assertTrue(text.endsWith("Invalid email address."));
        Thread.sleep(1000);
    }
    @Timeout(20)
    @Test
    public void NegativeAuth2() throws InterruptedException{
        String text;
        mainPagе.home();
        mainPagе.SignInStart();
        authenticationPage.SignInProcess("123@2365.ru","ddhj");


        text = authenticationPage.getTextInformationNegative();

        Assertions.assertTrue(text.startsWith("There is 1 error"));
        Assertions.assertTrue(text.endsWith("Invalid password."));
        Thread.sleep(1000);
    }
}
