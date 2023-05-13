package tests;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.junit4.DisplayName;
import model.pages.ForgotPasswordPage;
import model.pages.LoginPage;
import model.pages.RegistrationPage;
import model.pages.StellarburgersHomePage;
import org.junit.Test;

import static common.Constants.*;
import static org.junit.Assert.assertTrue;

/**
 * Тест авторизации пользователя
 *
 * @author  smirnov sergey
 * @since   01.05.2023
 */
public class LoginUserTest extends BaseWeb {

    @Test
    @Epic(value = "Авторизация и регистрация пользователя")
    @Feature(value = "Авторизация пользователя с главной страницы")
    @DisplayName("Авторизация через кнопку 'Войти в аккаунт' на главной странице")
    @Severity(SeverityLevel.CRITICAL)
    public void authFromTheSignInAccountBtnFromTheMainPageTest() {
        StellarburgersHomePage homePage = new StellarburgersHomePage(driver);
        assertTrue((homePage.click("Войти в аккаунт")
                .goToPage(new LoginPage(driver))
                .logIn(user)
                .isValidatePage(StellarburgersHomePage.class)) && homePage.isVisibleButton("Оформить заказ")
        );
    }

    @Test
    @Epic(value = "Авторизация и регистрация пользователя")
    @Feature(value = "Авторизация пользователя с главной страницы")
    @DisplayName("Авторизация через кнопку 'Личный кабинет' на главной странице")
    @Severity(SeverityLevel.CRITICAL)
    public void authFromThePersonalKabinetBtnFromTheMainPageTest() {
        StellarburgersHomePage homePage = new StellarburgersHomePage(driver);
        assertTrue((homePage.click("Личный Кабинет")
                .goToPage(new LoginPage(driver))
                .logIn(user)
                .isValidatePage(StellarburgersHomePage.class)) && homePage.isVisibleButton("Оформить заказ")
        );
    }

    @Test
    @Epic(value = "Проверка компонентов")
    @Feature(value = "Кнопка 'Войти'")
    @DisplayName("Авторизация через кнопку 'Войти' на форме регистрации")
    @Severity(SeverityLevel.CRITICAL)
    public void authFromTheLoginBtnFromTheRegistrationPageTest() {
        StellarburgersHomePage homePage = new StellarburgersHomePage(driver);
        LoginPage loginPage = new LoginPage(driver);
        driver.get(LOGIN_PAGE_URL);
        assertTrue((loginPage.click("Зарегистрироваться")
                .goToPage(new RegistrationPage(driver))
                .click("Войти")
                .goToPage(new LoginPage(driver))
                .logIn(user)
                .isValidatePage(StellarburgersHomePage.class)) && homePage.isVisibleButton("Оформить заказ")
        );
    }

    @Test
    @Epic(value = "Проверка компонентов")
    @Feature(value = "Кнопка 'Войти'")
    @DisplayName("Авторизация через кнопку 'Войти' на форме восстановления пароля")
    @Severity(SeverityLevel.CRITICAL)
    public void authFromTheLoginBtnFromTheForgotPasswordPageTest() throws InterruptedException {
        StellarburgersHomePage homePage = new StellarburgersHomePage(driver);
        ForgotPasswordPage forgotPasswordPage = new ForgotPasswordPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        driver.get(LOGIN_PAGE_URL);
        assertTrue((loginPage.click("Восстановить пароль")
                .goToPage(forgotPasswordPage)
                .click("Войти")
                .goToPage(loginPage)
                .logIn(user)
                .isValidatePage(StellarburgersHomePage.class)) && homePage.isVisibleButton("Оформить заказ")
        );
    }

}