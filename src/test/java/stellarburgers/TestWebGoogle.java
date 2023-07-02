package stellarburgers;

import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.stellarburgers.*;
import static org.junit.Assert.*;

@RunWith(Enclosed.class)
public class TestWebGoogle
{
    public static class RegistrationTests extends TestBaseGoogle
    {
        @Test
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
            String email = "HapHup@mail.ru";
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

        @Test
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

    public static class LogInTest extends TestBaseGoogle
    {
        @Test
        public void checkLogInFromManePageIsSucceed()
        {
            //Arrange
            MainPage mainPage = new MainPage(driver);
            Constructor constructor = new Constructor(driver);
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
        public void checkLogInByPersonalRoomIsSucceed()
        {
            //Arrange
            MainPage mainPage = new MainPage(driver);
            Constructor constructor = new Constructor(driver);
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
        public void checkLogInByRegistrationFormIsSucceed()
        {
            //Arrange
            MainPage mainPage = new MainPage(driver);
            Constructor constructor = new Constructor(driver);
            RegistrationForm registrationForm = new RegistrationForm(driver);
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
        public void checkLogInByRestorePasswordFormIsSucceed()
        {
            //Arrange
            MainPage mainPage = new MainPage(driver);
            Constructor constructor = new Constructor(driver);
            RestorePasswordForm restorePasswordForm = new RestorePasswordForm(driver);
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

    public static class TransitionToPersonalRoomTest extends TestBaseGoogle
    {
        @Test
        public void checkTransferToPersonalRoomIsSucceed()
        {
            //Arrange
            MainPage mainPage = new MainPage(driver);
            Constructor constructor = new Constructor(driver);
            PersonalRoom personalRoom = new PersonalRoom(driver);
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

    }
    public static class TransitionFromPersonalRoomToConstructorTest extends TestBaseGoogle
    {
        @Test
        public void checkTransferFromPersonalRoomToConstructorByConstructorButtonIsSucceed()
        {
            //Arrange
            MainPage mainPage = new MainPage(driver);
            Constructor constructor = new Constructor(driver);
            PersonalRoom personalRoom = new PersonalRoom(driver);
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
        public void checkTransferFromPersonalRoomToConstructorByLogoIsSucceed()
        {
            //Arrange
            MainPage mainPage = new MainPage(driver);
            Constructor constructor = new Constructor(driver);
            PersonalRoom personalRoom = new PersonalRoom(driver);
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

    }
    public static class ExitFromAccountTest extends TestBaseGoogle
    {
        @Test
        public void checkLogOutFromAccountIsSucceed()
        {
            //Arrange
            MainPage mainPage = new MainPage(driver);
            Constructor constructor = new Constructor(driver);
            PersonalRoom personalRoom = new PersonalRoom(driver);
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
    public static class ConstructorTests extends TestBaseGoogle
    {
        @Test
        public void checkTransferToBunSectionInConstructorIsSucceed()
        {
            //Arrange
            MainPage mainPage = new MainPage(driver);
            Constructor constructor = new Constructor(driver);
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
        public void checkTransferToSouseSectionInConstructorIsSucceed()
        {
            //Arrange
            MainPage mainPage = new MainPage(driver);
            Constructor constructor = new Constructor(driver);
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
        public void checkTransferToFillingSectionInConstructorIsSucceed()
        {
            //Arrange
            MainPage mainPage = new MainPage(driver);
            Constructor constructor = new Constructor(driver);
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
}
