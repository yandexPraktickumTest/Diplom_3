package org.stellarburgers.tests.ui;

import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import org.openqa.selenium.By;
import org.stellarburgers.classes.with.methods.MainPage;
import org.stellarburgers.classes.with.methods.RegistrationForm;
import org.stellarburgers.classes.support.Constructor;
import org.stellarburgers.classes.support.RestorePasswordForm;
import org.stellarburgers.tests.support.TestBase;

import java.util.concurrent.TimeUnit;

public class TestsLogIn extends TestBase
{
    @Test
    @DisplayName("Автоизация с главной страницы")
    public void checkLogInFromManePageIsSucceed()
    {
        //Arrange
        MainPage mainPage = new MainPage(driver);
        Constructor constructor = new Constructor(driver);
        By pathEmail = mainPage.getEmailInputField();
        By pathPassword = mainPage.getPasswordInputField();
        By pathLogInButton = mainPage.getLogInButton();
        By pathBunSectionButton = constructor.getBunSectionButton();
        String email = "test1-data@yandex.ru";
        String password = "password";

        //Act
        mainPage.openSite();
        mainPage.inputDataInChosenField(email, pathEmail);
        mainPage.inputDataInChosenField(password, pathPassword);
        mainPage.clickButton(pathLogInButton);

        //Assert
        mainPage.checkTheButtonDisplayed(pathBunSectionButton);
    }

    @Test
    @DisplayName("Авторизация с переходом из конструктора  через нажатие на кнопку личный кабинет")
    public void checkLogInByPersonalRoomIsSucceed()
    {
        //Arrange
        MainPage mainPage = new MainPage(driver);
        Constructor constructor = new Constructor(driver);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        By pathEmail = mainPage.getEmailInputField();
        By pathPassword = mainPage.getPasswordInputField();
        By pathLogInButton = mainPage.getLogInButton();
        By pathBunSectionButton = constructor.getBunSectionButton();
        By pathConstructor = mainPage.getConstructorButton();
        By pathPersonalRoom = constructor.getPersonalRoomButton();
        String email = "test1-data@yandex.ru";
        String password = "password";

        //Act
        mainPage.openSite();
        mainPage.clickButton(pathConstructor);
        mainPage.clickButton(pathPersonalRoom);
        mainPage.inputDataInChosenField(email, pathEmail);
        mainPage.inputDataInChosenField(password, pathPassword);
        mainPage.clickButton(pathLogInButton);

        //Assert
        mainPage.checkTheButtonDisplayed(pathBunSectionButton);
    }

    @Test
    @DisplayName("Авторизация с переходом из формы регистрации  через нажатие на кнопки Войти")
    public void checkLogInByRegistrationFormIsSucceed()
    {
        //Arrange
        MainPage mainPage = new MainPage(driver);
        Constructor constructor = new Constructor(driver);
        RegistrationForm registrationForm = new RegistrationForm(driver);
        By pathEmail = mainPage.getEmailInputField();
        By pathPassword = mainPage.getPasswordInputField();
        By pathLogInButton = mainPage.getLogInButton();
        By pathBunSectionButton = constructor.getBunSectionButton();
        By pathRegistrationButton = mainPage.getRegistrationButton();
        By pathLogInButtonFromRegistrationForm = registrationForm.getLogInButton();
        String email = "test1-data@yandex.ru";
        String password = "password";

        //Act
        mainPage.openSite();
        mainPage.clickButton(pathRegistrationButton);
        mainPage.clickButton(pathLogInButtonFromRegistrationForm);
        mainPage.inputDataInChosenField(email, pathEmail);
        mainPage.inputDataInChosenField(password, pathPassword);
        mainPage.clickButton(pathLogInButton);

        //Assert
        mainPage.checkTheButtonDisplayed(pathBunSectionButton);
    }


    @Test
    @DisplayName("Авторизация с переходом из формы восстановления пароля   через нажатие на кнопки Войти")
    public void checkLogInByRestorePasswordFormIsSucceed()
    {
        //Arrange
        MainPage mainPage = new MainPage(driver);
        Constructor constructor = new Constructor(driver);
        RestorePasswordForm restorePasswordForm = new RestorePasswordForm(driver);
        By pathEmail = mainPage.getEmailInputField();
        By pathPassword = mainPage.getPasswordInputField();
        By pathLogInButton = mainPage.getLogInButton();
        By pathBunSectionButton = constructor.getBunSectionButton();
        By pathRestorePasswordButton = mainPage.getPasswordRecovery();
        By pathLogInButtonFromRestorePasswordForm = restorePasswordForm.getLogInButton();
        String email = "test1-data@yandex.ru";
        String password = "password";

        //Act
        mainPage.openSite();
        mainPage.clickButton(pathRestorePasswordButton);
        mainPage.clickButton(pathLogInButtonFromRestorePasswordForm);
        mainPage.inputDataInChosenField(email, pathEmail);
        mainPage.inputDataInChosenField(password, pathPassword);
        mainPage.clickButton(pathLogInButton);

        //Assert
        mainPage.checkTheButtonDisplayed(pathBunSectionButton);
    }
}