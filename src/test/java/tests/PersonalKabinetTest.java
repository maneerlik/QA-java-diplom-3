package tests;

import io.qameta.allure.*;
import io.qameta.allure.junit4.DisplayName;
import model.pages.LoginPage;
import model.pages.StellarburgersHomePage;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Тест персонального кабинета
 *
 * @author  smirnov sergey
 * @since   03.05.2023
 */
public class PersonalKabinetTest extends BaseWeb {

    @Test
    @Epic(value = "Авторизация и регистрация пользователя")
    @Feature(value = "Авторизация пользователя")
    @DisplayName("Авторизация пользователя в личном кабинете")
    @Severity(SeverityLevel.CRITICAL)
    public void loginToPersonalKabinetTest() {
        assertTrue(new StellarburgersHomePage(driver)
                .loginPersonalKabinet(user)
                .isValidatePage(PersonalKabinetTest.class)
        );
    }

    @Test
    @Epic(value = "Авторизация и регистрация пользователя")
    @Feature(value = "Выход пользователя")
    @DisplayName("Проверка выхода пользователя из аккаунта")
    @Severity(SeverityLevel.CRITICAL)
    public void logoutUserTest() {
        assertTrue(new StellarburgersHomePage(driver)
                .loginPersonalKabinet(user)
                .transitionClick("Выход", new LoginPage(driver))
                .isValidatePage(LoginPage.class)
        );
    }

    @Test
    @Epic(value = "Проверка интерфейса")
    @Feature(value = "Кнопка конструктор")
    @DisplayName("Проверка перехода при нажатии на кнопку 'Конструктор' в личном кабинете")
    @Severity(SeverityLevel.CRITICAL)
    public void transitionCheckFromConstructorButtonTest() {
        assertTrue(new StellarburgersHomePage(driver)
                .loginPersonalKabinet(user)
                .transitionClick("Конструктор", new StellarburgersHomePage(driver))
                .isValidatePage(StellarburgersHomePage.class)
        );
    }

    @Test
    @Epic(value = "Проверка интерфейса")
    @Feature(value = "Логотип сайта")
    @DisplayName("Проверка перехода при нажатии на логотип сайта в личном кабинете")
    @Severity(SeverityLevel.CRITICAL)
    public void transitionCheckFromLogoTest() {
        assertTrue(new StellarburgersHomePage(driver)
                .loginPersonalKabinet(user)
                .transitionClick("Логотип сайта", new StellarburgersHomePage(driver))
                .isValidatePage(StellarburgersHomePage.class)
        );
    }

}