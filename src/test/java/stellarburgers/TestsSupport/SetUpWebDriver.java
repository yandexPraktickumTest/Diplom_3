package stellarburgers.TestsSupport;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class SetUpWebDriver
{
    public  String getBrowserNameFromProperties(String keyName) throws IOException
    {
        System.getProperties().load(ClassLoader.getSystemResourceAsStream("browser.properties"));

        return System.getProperty(keyName);
    }
    public  WebDriver  setWebDriver(String keyName ) throws IOException
    {

        switch (getBrowserNameFromProperties(keyName))
        {
            case "Chrome":
                WebDriverManager.chromedriver().setup();
                return  new ChromeDriver();

            case "Yandex":
                System.setProperty("webdriver.chrome.driver", "D:\\Java projects\\Diplom_3\\src\\main\\resources\\chromedriverForYandex.exe");
                ChromeOptions options = new ChromeOptions();
                options.setBinary("C:\\Users\\kaufa\\AppData\\Local\\Yandex\\YandexBrowser\\Application\\browser.exe");
                return  new ChromeDriver(options);

            default:
                throw new RuntimeException("Incorrect BrowserName");
        }
    }
}
