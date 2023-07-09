package org.stellarburgers.classes.support;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RestorePasswordForm
{
    public RestorePasswordForm(WebDriver webDriver) {this.webDriver = webDriver;}

    public By getLogInButton() {return logInButton;}
    private final WebDriver webDriver;

    final private By logInButton = By.xpath(".//a[@class='Auth_link__1fOlj']");
}
