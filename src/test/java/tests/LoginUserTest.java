package tests;

import io.github.cdimascio.dotenv.Dotenv;
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
        assertTrue((homePage.transitionClick("Войти в аккаунт", new LoginPage(driver))
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
        assertTrue((homePage.transitionClick("Личный Кабинет", new LoginPage(driver))
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
        driver.get(Dotenv.load().get("LOGIN_URL"));
        assertTrue((loginPage.transitionClick("Зарегистрироваться", new RegistrationPage(driver))
                .transitionClick("Войти", new LoginPage(driver))
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

        driver.get(Dotenv.load().get("LOGIN_URL"));
        assertTrue((loginPage.transitionClick("Восстановить пароль", forgotPasswordPage)
                .transitionClick("Войти", loginPage)
                .logIn(user)
                .isValidatePage(StellarburgersHomePage.class)) && homePage.isVisibleButton("Оформить заказ")
        );
    }

}