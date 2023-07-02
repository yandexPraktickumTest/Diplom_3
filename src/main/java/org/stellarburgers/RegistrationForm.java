package org.stellarburgers;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertEquals;

public class RegistrationForm
{
    public RegistrationForm(WebDriver webDriver) {this.webDriver = webDriver;}
    private MainPage mainPage;

    public RegistrationForm(MainPage mainPage, WebDriver webDriver)
    {
        this.mainPage = mainPage;
        this.webDriver = webDriver;
    }

    private final WebDriver webDriver;
    final private By textIncorrectPassword = By.xpath(".//p[@class='input__error text_type_main-default']");
    final private By nameInputField = By.xpath("/html/body/div/div/main/div/form/fieldset[1]/div/div/input");
    final private By emailInputField = By.xpath("/html/body/div/div/main/div/form/fieldset[2]/div/div/input");
    final private By passwordInputField = By.xpath("/html/body/div/div/main/div/form/fieldset[3]/div/div/input");
    final private By registrationButton = By.xpath(".//button[@class='button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_medium__3zxIa' and text()='Зарегистрироваться']");
    final private By logInButton = By.xpath(".//a[@class='Auth_link__1fOlj']");

    public By getTextIncorrectPassword() {return textIncorrectPassword;}

    public By getNameInputField() {return nameInputField;}

    public By getEmailInputField() {return emailInputField;}

    public By getPasswordInputField() {return passwordInputField;}

    public By getRegistrationButton() {return registrationButton;}

    public By getLogInButton() {return logInButton;}

    @Step("Register new user")
    public void registerNewUser(String password, String email,String name,
                                By passwordButton, By emailButton,
                                By nameButton, By registrationButton)
    {
        mainPage.inputDataInChosenField(name, nameButton);
        mainPage.inputDataInChosenField(email, emailButton);
        mainPage.inputDataInChosenField(password, passwordButton);
        mainPage.clickButton(registrationButton);
    }



}
