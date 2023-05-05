package tests;

import extensions.WebDriverFactory;
import io.github.cdimascio.dotenv.Dotenv;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.junit4.DisplayName;
import model.pages.RegistrationPage;
import model.pojo.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import static data.RandomUser.randomValidUser;
import static org.junit.Assert.assertTrue;
import static steps.BaseSteps.delete;

/**
 * Тест успешная регистрация пользователя
 *
 * @author  smirnov sergey
 * @since   01.05.2023
 */
public class SuccessUserRegistrationTest {

    private WebDriver driver;
    private User user;

    @Before
    public void setup() {
        user = randomValidUser();
        driver = WebDriverFactory.getDriver(Dotenv.load().get("REGISTRATION_URL"));
    }

    @Test
    @Epic(value = "Авторизация и регистрация пользователя")
    @Feature(value = "Регистрация пользователя")
    @DisplayName("Успешная регистрация пользователя")
    public void successfulRegistrationUserTest() {
        assertTrue(new RegistrationPage(driver)
                .fillName(user.getName())
                .fillEmail(user.getEmail())
                .fillPassword(user.getPassword())
                .clickRegistrationButton()
                .isValidLoginPage()
        );
    }

    @After
    public void teardown() {
        delete(user);
        driver.quit();
    }

}