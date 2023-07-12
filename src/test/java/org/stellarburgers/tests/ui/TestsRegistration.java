package org.stellarburgers.tests.ui;

import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.ValidatableResponse;
import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.By;
import org.stellarburgers.classes.api.UserToken;
import org.stellarburgers.classes.api.UserWithEmailAndPassword;
import org.stellarburgers.classes.with.methods.MainPage;
import org.stellarburgers.classes.with.methods.RegistrationForm;
import org.stellarburgers.tests.support.TestBase;

public class TestsRegistration extends TestBase
{
    @Test
    @DisplayName("Регистрация пользователя")
    public void checkRegistrationIsSucceed()
    {
        //Arrange
        MainPage mainPage = new MainPage(driver);
        RegistrationForm registrationForm = new RegistrationForm(mainPage, driver);
        By pathName = registrationForm.getNameInputField();
        By pathEmail = registrationForm.getEmailInputField();
        By pathPassword = registrationForm.getPasswordInputField();
        By pathRegistration = registrationForm.getRegistrationButton();
        String name = "UserName";
        String email = "HapHup1@mail.ru";
        String password = "passdword";

        //Act
        mainPage.openSite();
        mainPage.clickButton(mainPage.getRegistrationButton());
        mainPage.inputDataInChosenField(name, pathName);
        mainPage.inputDataInChosenField(email, pathEmail);
        mainPage.inputDataInChosenField(password, pathPassword);
        mainPage.clickButton(pathRegistration);

        //Assert
        mainPage.checkTheButtonDisplayed(mainPage.getLogInButton());
    }
    @After
    public  void cleanData()
    {
        UserWithEmailAndPassword user = new UserWithEmailAndPassword("HapHup1@mail.ru","password" );
        MainPage methods = new MainPage(driver);
        String token;

        ValidatableResponse response = methods.logInUser(user );
        token = response.extract().path("accessToken");
        UserToken obj = new UserToken(token);

        methods.deleteUser(obj);
    }

    @Test
    @DisplayName("Проверка верификации поля ввода пароля при регистрации")
    public void checkIncorrectPasswordErrorAppear()
    {
        //Arrange
        MainPage mainPage = new MainPage(driver);
        RegistrationForm registrationForm = new RegistrationForm(mainPage, driver);
        By pathPassword = registrationForm.getPasswordInputField();
        By pathTextIncorrectPassword = registrationForm.getTextIncorrectPassword();
        By pathEmail = registrationForm.getEmailInputField();
        String password = "p";
        String expectedText = "Некорректный пароль";

        //Act
        mainPage.openSite();
        mainPage.clickButton(mainPage.getRegistrationButton());
        mainPage.inputDataInChosenField(password, pathPassword);
        mainPage.clickButton(pathEmail);

        //Assert
        mainPage.checkTheButtonDisplayed(pathTextIncorrectPassword);
        mainPage.acceptTextOfElementsIsEqual(pathTextIncorrectPassword,expectedText);
    }
}
