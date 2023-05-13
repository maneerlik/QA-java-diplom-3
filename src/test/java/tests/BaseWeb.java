package tests;

import controllers.user.UserClient;
import extensions.WebDriverFactory;
import model.pojo.User;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;

import static common.Constants.STELLARBURGERS_PAGE_URL;
import static data.RandomUser.randomValidUser;
import static steps.BaseSteps.delete;

/**
 * Реализация базового теста
 *
 * @author  smirnov sergey
 * @since   03.05.2023
 */
public class BaseWeb {

    protected WebDriver driver;
    protected User user;

    @Before
    public void setup() {
        user = randomValidUser();
        new UserClient().register(user);
        driver = WebDriverFactory.getDriver(STELLARBURGERS_PAGE_URL);
    }

    @After
    public void teardown() {
        driver.quit();
        delete(user);
    }

}