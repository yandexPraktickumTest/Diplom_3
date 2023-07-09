package org.stellarburgers.tests.ui;

import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import org.openqa.selenium.By;
import org.stellarburgers.classes.with.methods.MainPage;
import org.stellarburgers.classes.support.Constructor;
import org.stellarburgers.classes.support.PersonalRoom;
import org.stellarburgers.tests.support.TestBase;

import java.util.concurrent.TimeUnit;

public class TestsLogOut extends TestBase
{
    @Test
    @DisplayName("Выход из аккаунта")
    public void checkLogOutFromAccountIsSucceed()
    {
        //Arrange
        MainPage mainPage = new MainPage(driver);
        Constructor constructor = new Constructor(driver);
        PersonalRoom personalRoom = new PersonalRoom(driver);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        By pathEmail = mainPage.getEmailInputField();
        By pathPassword = mainPage.getPasswordInputField();
        By pathLogInButton = mainPage.getLogInButton();
        By pathPersonalRoom = constructor.getPersonalRoomButton();
        By pathExitFromAccountButton = personalRoom.getExitButton();
        String email = "test1-data@yandex.ru";
        String password = "password";

        //Act
        mainPage.openSite();
        mainPage.inputDataInChosenField(email, pathEmail);
        mainPage.inputDataInChosenField(password, pathPassword);
        mainPage.clickButton(pathLogInButton);
        mainPage.clickButton(pathPersonalRoom);
        mainPage.clickButton(pathExitFromAccountButton);

        //Assert
        mainPage.checkTheButtonDisplayed(pathLogInButton);
    }
}
