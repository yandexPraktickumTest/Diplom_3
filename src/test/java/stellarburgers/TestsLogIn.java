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
import org.stellarburgers.ClassesWithMethods.RegistrationForm;
import org.stellarburgers.SupportClasses.Constructor;
import org.stellarburgers.SupportClasses.RestorePasswordForm;

import java.util.concurrent.TimeUnit;

@RunWith(Parameterized.class)
public class TestsLogIn extends TestBase
{

    private final String browserPath;
    private final String driverPath;


    public TestsLogIn(String browserPath, String driverPath)
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
    @DisplayName("Автоизация с главной страницы")
    public void checkLogInFromManePageIsSucceed()
    {
        //Arrange
        MainPage mainPage = new MainPage(driver);
        Constructor constructor = new Constructor(driver);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
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
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
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
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
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