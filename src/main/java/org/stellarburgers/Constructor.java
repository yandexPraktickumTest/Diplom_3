package org.stellarburgers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Constructor
{
    public Constructor(WebDriver webDriver) {this.webDriver = webDriver;}
    private final WebDriver webDriver;

    final private By personalRoomButton = By.xpath(".//p[@class='AppHeader_header__linkText__3q_va ml-2'and text()='Личный Кабинет']");
    final private By bunSectionButton = By.xpath(".//span[@class='text text_type_main-default' and text()='Булки']");
    final private By bunSectionButtonName = By.xpath("/html/body/div/div/main/section[1]/div[1]/div[1]");
    final private By souseSectionButton = By.xpath(".//span[@class='text text_type_main-default' and text()='Соусы']");
    final private By souseSectionButtonName = By.xpath("/html/body/div/div/main/section[1]/div[1]/div[2]");
    final private By fillingSectionButton = By.xpath(".//span[@class='text text_type_main-default' and text()='Начинки']");
    final private By fillingSectionButtonName = By.xpath("/html/body/div/div/main/section[1]/div[1]/div[3]");

    public By getPersonalRoomButton() {return personalRoomButton;}

    public By getBunSectionButton() {return bunSectionButton;}

    public By getSouseSectionButton() {return souseSectionButton;}

    public By getFillingSectionButton() {return fillingSectionButton;}

    public By getBunSectionButtonName() { return bunSectionButtonName;}

    public By getSouseSectionButtonName() {return souseSectionButtonName;}

    public By getFillingSectionButtonName() {return fillingSectionButtonName;}
}
