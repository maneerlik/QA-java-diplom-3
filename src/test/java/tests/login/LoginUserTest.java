package tests.login;

import controllers.user.UserClient;
import extensions.WebDriverFactory;
import io.github.cdimascio.dotenv.Dotenv;
import io.qameta.allure.*;
import io.qameta.allure.junit4.DisplayName;
import model.pages.StellarburgersHomePage;
import model.pojo.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import static data.RandomUser.randomValidUser;
import static org.junit.Assert.assertTrue;
import static steps.BaseSteps.delete;

/**
 * Тест авторизации пользователя
 *
 * @author  smirnov sergey
 * @since   01.05.2023
 */
public class LoginUserTest {

    private WebDriver driver;
    private User user;

    @Before
    public void setup() {
        user = randomValidUser();
        new UserClient().register(user);
        driver = WebDriverFactory.getDriver(Dotenv.load().get("STELLARBURGERS_URL"));
    }

    @Epic(value = "Авторизация и регистрация пользователя")
    @Feature(value = "Авторизация пользователя")
    @Test
    @DisplayName("Авторизация пользователя с главной страницы")
    @Description("Авторизация пользователя по кнопке 'Войти в аккаунт' на главной странице")
    @Severity(SeverityLevel.CRITICAL)
    public void userAuthorizationFromTheMainPageTest() {
        assertTrue(new StellarburgersHomePage(driver)
                .clickSignInAccountButton()
                .fillEmail(user.getEmail())
                .fillPassword(user.getPassword())
                .clickLoginButton()
                .isValidMainPage()
        );
    }

    @After
    public void teardown() {
        driver.quit();
        delete(user);
    }

}