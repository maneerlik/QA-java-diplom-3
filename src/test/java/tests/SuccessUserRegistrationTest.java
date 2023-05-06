package tests;

import extensions.WebDriverFactory;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.junit4.DisplayName;
import model.pages.LoginPage;
import model.pages.RegistrationPage;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static common.Constants.REGISTRATION_PAGE_URL;
import static data.RandomUser.randomValidUser;
import static org.junit.Assert.assertTrue;

/**
 * Тест успешная регистрация пользователя
 *
 * @author  smirnov sergey
 * @since   01.05.2023
 */
public class SuccessUserRegistrationTest extends BaseWeb {

    @Override
    @Before
    public void setup() {
        user = randomValidUser();
        driver = WebDriverFactory.getDriver(REGISTRATION_PAGE_URL);
    }

    @Test
    @Epic(value = "Авторизация и регистрация пользователя")
    @Feature(value = "Регистрация пользователя")
    @DisplayName("Успешная регистрация пользователя")
    @Severity(SeverityLevel.BLOCKER)
    public void successfulRegistrationUserTest() {
        assertTrue(new RegistrationPage(driver)
                .fillRegistrationForm(List.of(user.getName(), user.getEmail(), user.getPassword()))
                .click("Зарегистрироваться")
                .goToPage(new LoginPage(driver))
                .isValidatePage(LoginPage.class)
        );
    }

}