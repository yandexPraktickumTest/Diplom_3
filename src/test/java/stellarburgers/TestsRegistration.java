package stellarburgers;

import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.ValidatableResponse;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.stellarburgers.API.UserToken;
import org.stellarburgers.API.UserWithEmailAndPassword;
import org.stellarburgers.ClassesWithMethods.MainPage;
import org.stellarburgers.ClassesWithMethods.RegistrationForm;

import java.util.concurrent.TimeUnit;

@RunWith(Parameterized.class)
public class TestsRegistration extends TestBase
{

    private final String browserPath;
    private final String driverPath;


    public TestsRegistration(String browserPath, String driverPath)
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
    @DisplayName("Регистрация пользователя")
    public void checkRegistrationIsSucceed()
    {
        //Arrange
        MainPage mainPage = new MainPage(driver);
        RegistrationForm registrationForm = new RegistrationForm(mainPage, driver);
        By pathName = registrationForm.getNameInputField();
        By pathEmail = registrationForm.getEmailInputField();
        By pathPassword = registrationForm.getPasswordInputField();
        By pathRegistration = registrationForm.getRegistrationButton();
        String name = "UserName";
        String email = "HapHup1@mail.ru";
        String password = "passdword";

        //Act
        mainPage.openSite();
        mainPage.clickButton(mainPage.getRegistrationButton());
        mainPage.inputDataInChosenField(name, pathName);
        mainPage.inputDataInChosenField(email, pathEmail);
        mainPage.inputDataInChosenField(password, pathPassword);
        mainPage.clickButton(pathRegistration);

        //Assert
        mainPage.checkTheButtonDisplayed(mainPage.getLogInButton());
    }
    @After
    public  void cleanData()
    {
        UserWithEmailAndPassword user = new UserWithEmailAndPassword("HapHup1@mail.ru","password" );
        MainPage methods = new MainPage(driver);
        String token;

        ValidatableResponse response = methods.logInUser(user );
        token = response.extract().path("accessToken");
        UserToken obj = new UserToken(token);

        methods.deleteUser(obj);
    }

    @Test
    @DisplayName("Проверка верификации поля ввода пароля при регистрации")
    public void checkIncorrectPasswordErrorAppear()
    {
        //Arrange
        MainPage mainPage = new MainPage(driver);
        RegistrationForm registrationForm = new RegistrationForm(mainPage, driver);
        By pathPassword = registrationForm.getPasswordInputField();
        By pathTextIncorrectPassword = registrationForm.getTextIncorrectPassword();
        By pathEmail = registrationForm.getEmailInputField();
        String password = "p";
        String expectedText = "Некорректный пароль";

        //Act
        mainPage.openSite();
        mainPage.clickButton(mainPage.getRegistrationButton());
        mainPage.inputDataInChosenField(password, pathPassword);
        mainPage.clickButton(pathEmail);

        //Assert
        mainPage.checkTheButtonDisplayed(pathTextIncorrectPassword);
        mainPage.acceptTextOfElementsIsEqual(pathTextIncorrectPassword,expectedText);
    }
}
