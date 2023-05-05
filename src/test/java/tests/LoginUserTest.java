package tests;

import controllers.user.UserClient;
import extensions.WebDriverFactory;
import io.github.cdimascio.dotenv.Dotenv;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.junit4.DisplayName;
import model.pages.LoginPage;
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

    @Test
    @Epic(value = "Авторизация и регистрация пользователя")
    @Feature(value = "Авторизация пользователя с главной страницы")
    @DisplayName("Авторизация через кнопку 'Войти в аккаунт' на главной странице")
    @Severity(SeverityLevel.CRITICAL)
    public void authFromTheSignInAccountBtnFromTheMainPageTest() {
        assertTrue(new StellarburgersHomePage(driver)
                .clickSignInAccountButton()
                .fillAutorizationForm(user)
                .isMakeOrderButtonVisible()
        );
    }

    @Test
    @Epic(value = "Авторизация и регистрация пользователя")
    @Feature(value = "Авторизация пользователя с главной страницы")
    @DisplayName("Авторизация через кнопку 'Личный кабинет' на главной странице")
    @Severity(SeverityLevel.CRITICAL)
    public void authFromThePersonalKabinetBtnFromTheMainPageTest() {
        assertTrue(new StellarburgersHomePage(driver)
                .clickPersonalKabinetButton()
                .fillAutorizationForm(user)
                .isMakeOrderButtonVisible()
        );
    }

    @Test
    @Epic(value = "Проверка компонентов")
    @Feature(value = "Кнопка 'Войти'")
    @DisplayName("Авторизация через кнопку 'Войти' на форме регистрации")
    @Severity(SeverityLevel.CRITICAL)
    public void authFromTheLoginBtnFromTheRegistrationPageTest() {
        driver.get(Dotenv.load().get("LOGIN_URL"));
        assertTrue(new LoginPage(driver)
                .clickRegisterButton()
                .clickLoginButton()
                .fillAutorizationForm(user)
                .isMakeOrderButtonVisible()
        );
    }

    @Test
    @Epic(value = "Проверка компонентов")
    @Feature(value = "Кнопка 'Войти'")
    @DisplayName("Авторизация через кнопку 'Войти' на форме восстановления пароля")
    @Severity(SeverityLevel.CRITICAL)
    public void authFromTheLoginBtnFromTheForgotPasswordPageTest() {
        driver.get(Dotenv.load().get("LOGIN_URL"));
        assertTrue(new LoginPage(driver)
                .clickForgotPasswordButton()
                .clickLoginButton()
                .fillAutorizationForm(user)
                .isMakeOrderButtonVisible()
        );
    }

    @After
    public void teardown() {
        driver.quit();
        delete(user);
    }

}