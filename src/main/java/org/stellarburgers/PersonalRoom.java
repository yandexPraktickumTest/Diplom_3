package org.stellarburgers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PersonalRoom
{
    public PersonalRoom(WebDriver webDriver) {this.webDriver = webDriver;}

    private final WebDriver webDriver;

    final private By exitButton = By.xpath(".//button[@class='Account_button__14Yp3 text text_type_main-medium text_color_inactive']");
    final private By constructorButton = By.xpath(".//p[@class='AppHeader_header__linkText__3q_va ml-2' and text()='Конструктор']");
    final private By logoButton = By.xpath("//div[@class='AppHeader_header__logo__2D0X2']");

    public By getExitButton() {return exitButton;}

    public By getConstructorButton() {return constructorButton;}

    public By getLogoButton() {return logoButton;}
}
