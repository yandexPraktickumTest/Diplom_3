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

@RunWith(Parameterized.class)
public class TestsLogOut extends TestBase
{

    private final String browserPath;
    private final String driverPath;


    public TestsLogOut(String browserPath, String driverPath)
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
