package org.stellarburgers.classes.with.methods;

import io.qameta.allure.Step;
import io.restassured.response.ValidatableResponse;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class MainPage
{

    public MainPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }
    private final WebDriver webDriver;
    final private By emailInputField = By.xpath(".//label[((@class='input__placeholder text noselect text_type_main-default') or (@class='input__placeholder text noselect text_type_main-default input__placeholder-focused')) and text()='Email']/following-sibling::input");
    final private By passwordInputField = By.xpath(".//label[((@class='input__placeholder text noselect text_type_main-default') or (@class='input__placeholder text noselect text_type_main-default input__placeholder-focused')) and text()='Пароль']/following-sibling::input");
    final private By logInButton = By.xpath(".//button[@class='button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_medium__3zxIa']");
    final private By personalRoomButton = By.xpath(".//p[@class='AppHeader_header__linkText__3q_va ml-2'and text()='Личный Кабинет']");
    final private By registrationButton = By.xpath(".//a[@class='Auth_link__1fOlj' and text()='Зарегистрироваться']");
    final private By constructorButton = By.xpath(".//p[@class='AppHeader_header__linkText__3q_va ml-2' and text()='Конструктор']");
    final private By passwordRecovery = By.xpath(".//a[@class='Auth_link__1fOlj' and text()='Восстановить пароль']");

    public By getEmailInputField() {return emailInputField;}

    public By getPasswordInputField() {return passwordInputField;}

    public By getLogInButton() {return logInButton;}

    public By getPersonalRoomButton() {return personalRoomButton;}

    public By getRegistrationButton() {return registrationButton;}

    public By getConstructorButton() {return constructorButton;}

    public By getPasswordRecovery() {return passwordRecovery;}

    @Step("Open site")
    public void openSite() {
        webDriver.get("https://stellarburgers.nomoreparties.site/login");
    }
    @Step("Click need button")
    public void clickButton(By button) {webDriver.findElement(button).click(); }
    @Step("Fill chosen field")
    public void inputDataInChosenField(String data, By button)
    {
        clickButton(button);
        webDriver.findElement(button).sendKeys(data);
    }
    @Step("Log in")
    public void logIn(String email, String password, By emailButton,
                      By passwordButton, By logInButton)
    {
      inputDataInChosenField(email,emailButton);
      inputDataInChosenField(password, passwordButton);
      clickButton(logInButton);
    }
    @Step("Check the button exist")
    public void checkTheButtonDisplayed(By button)
    {
        assertTrue(webDriver.findElement(button).isDisplayed());
    }
    @Step("Get text from element")
    public String getTextFromElement(By element){ return webDriver.findElement(element).getText();}
    @Step("Compare text of elements")
    public void acceptTextOfElementsIsEqual(By element, String expectedText) {assertEquals("",expectedText,getTextFromElement(element));}
    @Step("Send information to delete user")
    public ValidatableResponse deleteUser(Object obj)
    {
        return given()
                .header("Content-type", "application/json")
                .and()
                .body(obj)
                .when()
                .delete("https://stellarburgers.nomoreparties.site/api/auth/user")
                .then();
    }
    @Step("Send information to log in user")
    public ValidatableResponse logInUser(Object obj)
    {
        return given()
                .header("Content-type", "application/json")
                .and()
                .body(obj)
                .when()
                .post("https://stellarburgers.nomoreparties.site/api/auth/login")
                .then();
    }
}
