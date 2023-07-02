package org.stellarburgers;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class MainPage
{
    public MainPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }
    private final WebDriver webDriver;
    final private By emailInputField = By.xpath("/html/body/div/div/main/div/form/fieldset[1]/div/div/input");
    final private By passwordInputField = By.xpath("/html/body/div/div/main/div/form/fieldset[2]/div/div/input");
    final private By logInButton = By.xpath("/html/body/div/div/main/div/form/button");
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
}
