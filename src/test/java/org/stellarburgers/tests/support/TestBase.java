package org.stellarburgers.tests.support;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class TestBase
{
    public  static WebDriver driver;

    @Before
    public void setUp() throws IOException
    {
        SetUpWebDriver setUpWebDriver = new SetUpWebDriver();

        driver = setUpWebDriver.setWebDriver("browser2");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @After
    public void tearDown(){driver.quit();}
}
