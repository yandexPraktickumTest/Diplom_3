package stellarburgers;

import io.qameta.allure.junit4.DisplayName;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.stellarburgers.ClassesWithMethods.MainPage;
import org.stellarburgers.SupportClasses.Constructor;
import org.stellarburgers.SupportClasses.PersonalRoom;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertNotEquals;

@RunWith(Parameterized.class)
public class TestsTransitions extends TestBase
{

    private final String browserPath;
    private final String driverPath;

    public TestsTransitions(String browserPath, String driverPath)
    {
        this.browserPath = browserPath;
        this.driverPath = driverPath;
    }

    @Parameterized.Parameters
    public static Object[][] getValues()
    {

        return new Object[][]
                {

                        {"C:\\Users\\kaufa\\AppData\\Local\\Yandex\\YandexBrowser\\Application\\browser.exe",
                                "D:\\Java projects\\Diplom_3\\src\\main\\resources\\chromedriverForYandex.exe" },
                        {"C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe",
                                "D:\\Java projects\\Diplom_3\\src\\main\\resources\\chromedriverForGoogle.exe"},
                };
    }

    @Before
    public void setUp()
    {
        System.setProperty("webdriver.chrome.driver", driverPath);
        ChromeOptions options = new ChromeOptions();
        options.setBinary(browserPath);
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @Test
    @DisplayName("Проверка перехода в личный кабинет")
    public void checkTransferToPersonalRoomIsSucceed()
    {
        //Arrange
        MainPage mainPage = new MainPage(driver);
        Constructor constructor = new Constructor(driver);
        PersonalRoom personalRoom = new PersonalRoom(driver);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        By pathEmail = mainPage.getEmailInputField();
        By pathPassword = mainPage.getPasswordInputField();
        By pathLogInButton = mainPage.getLogInButton();
        By pathPersonalRoomButton = constructor.getPersonalRoomButton();
        By pathExitButtonFromAccount = personalRoom.getExitButton();
        String email = "test1-data@yandex.ru";
        String password = "password";

        //Act
        mainPage.openSite();
        mainPage.inputDataInChosenField(email, pathEmail);
        mainPage.inputDataInChosenField(password, pathPassword);
        mainPage.clickButton(pathLogInButton);
        mainPage.clickButton(pathPersonalRoomButton);

        //Assert
        mainPage.checkTheButtonDisplayed(pathExitButtonFromAccount);
    }

    @Test
    @DisplayName("Проверка перехода из личного кабинета в раздел конструктор через нажатия кнопки Конструкор")
    public void checkTransferFromPersonalRoomToConstructorByConstructorButtonIsSucceed()
    {
        //Arrange
        MainPage mainPage = new MainPage(driver);
        Constructor constructor = new Constructor(driver);
        PersonalRoom personalRoom = new PersonalRoom(driver);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        By pathEmail = mainPage.getEmailInputField();
        By pathPassword = mainPage.getPasswordInputField();
        By pathLogInButton = mainPage.getLogInButton();
        By pathPersonalRoomButton = constructor.getPersonalRoomButton();
        By pathConstructor = personalRoom.getConstructorButton();
        By pathBun = constructor.getBunSectionButton();
        String email = "test1-data@yandex.ru";
        String password = "password";

        //Act
        mainPage.openSite();
        mainPage.inputDataInChosenField(email, pathEmail);
        mainPage.inputDataInChosenField(password, pathPassword);
        mainPage.clickButton(pathLogInButton);
        mainPage.clickButton(pathPersonalRoomButton);
        mainPage.clickButton(pathConstructor);

        //Assert
        mainPage.checkTheButtonDisplayed(pathBun);
    }

    @Test
    @DisplayName("Проверка перехода из личного кабинета в раздел конструктор через нажатия логотипа")
    public void checkTransferFromPersonalRoomToConstructorByLogoIsSucceed()
    {
        //Arrange
        MainPage mainPage = new MainPage(driver);
        Constructor constructor = new Constructor(driver);
        PersonalRoom personalRoom = new PersonalRoom(driver);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        By pathEmail = mainPage.getEmailInputField();
        By pathPassword = mainPage.getPasswordInputField();
        By pathLogInButton = mainPage.getLogInButton();
        By pathPersonalRoomButton = constructor.getPersonalRoomButton();
        By pathLogo = personalRoom.getLogoButton();
        By pathBun = constructor.getBunSectionButton();
        String email = "test1-data@yandex.ru";
        String password = "password";

        //Act
        mainPage.openSite();
        mainPage.inputDataInChosenField(email, pathEmail);
        mainPage.inputDataInChosenField(password, pathPassword);
        mainPage.clickButton(pathLogInButton);
        mainPage.clickButton(pathPersonalRoomButton);
        mainPage.clickButton(pathLogo);

        //Assert
        mainPage.checkTheButtonDisplayed(pathBun);
    }

    @Test
    @DisplayName("Проверка перехода в подраздел булки раздела конструктор")
    public void checkTransferToBunSectionInConstructorIsSucceed()
    {
        //Arrange
        MainPage mainPage = new MainPage(driver);
        Constructor constructor = new Constructor(driver);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        By pathConstructor = mainPage.getConstructorButton();
        By pathBunSectionButtonName = constructor.getBunSectionButtonName();
        By pathSouseSectionButton = constructor.getSouseSectionButton();
        String expectedClassName;
        String actualClassName;

        //Act
        mainPage.openSite();
        mainPage.clickButton(pathConstructor);
        expectedClassName = driver.findElement(pathBunSectionButtonName).getAttribute("class");
        mainPage.clickButton(pathSouseSectionButton);
        actualClassName = driver.findElement(pathBunSectionButtonName).getAttribute("class");

        //Assert
        assertNotEquals("Название классов не должно совпадать", expectedClassName, actualClassName);
    }


    @Test
    @DisplayName("Проверка перехода в подраздел соусы раздела конструктор")
    public void checkTransferToSouseSectionInConstructorIsSucceed()
    {
        //Arrange
        MainPage mainPage = new MainPage(driver);
        Constructor constructor = new Constructor(driver);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        By pathConstructor = mainPage.getConstructorButton();
        By pathSouseSectionButtonName = constructor.getSouseSectionButtonName();
        By pathSouseSectionButton = constructor.getSouseSectionButton();
        String expectedClassName;
        String actualClassName;

        //Act
        mainPage.openSite();
        mainPage.clickButton(pathConstructor);
        expectedClassName = driver.findElement(pathSouseSectionButtonName).getAttribute("class");
        mainPage.clickButton(pathSouseSectionButton);
        actualClassName = driver.findElement(pathSouseSectionButtonName).getAttribute("class");

        //Assert
        assertNotEquals("Название классов не должно совпадать", expectedClassName, actualClassName);
    }

    @Test
    @DisplayName("Проверка перехода в подраздел начинки раздела конструктор")
    public void checkTransferToFillingSectionInConstructorIsSucceed()
    {
        //Arrange
        MainPage mainPage = new MainPage(driver);
        Constructor constructor = new Constructor(driver);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        By pathConstructor = mainPage.getConstructorButton();
        By pathFillingSectionButtonName = constructor.getFillingSectionButtonName();
        By pathFillingSectionButton = constructor.getFillingSectionButton();
        String expectedClassName;
        String actualClassName;

        //Act
        mainPage.openSite();
        mainPage.clickButton(pathConstructor);
        expectedClassName = driver.findElement(pathFillingSectionButtonName).getAttribute("class");
        mainPage.clickButton(pathFillingSectionButton);
        actualClassName = driver.findElement(pathFillingSectionButtonName).getAttribute("class");

        //Assert
        assertNotEquals("Название классов не должно совпадать", expectedClassName, actualClassName);
    }
}
