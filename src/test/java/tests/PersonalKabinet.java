package tests;

import controllers.user.UserClient;
import extensions.WebDriverFactory;
import io.github.cdimascio.dotenv.Dotenv;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
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
 * Тест персонального кабинета
 *
 * @author  smirnov sergey
 * @since   03.05.2023
 */
public class PersonalKabinet {

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
    @Feature(value = "Авторизация пользователя")
    @DisplayName("Авторизация пользователя в личном кабинете")
    @Severity(SeverityLevel.CRITICAL)
    public void loginToPersonalKabinetTest() {
        assertTrue(new StellarburgersHomePage(driver)
                .loginPersonalKabinet(user)
                .isValidPersonalKabinetPage()
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
                .clickLogout()
                .isValidLoginPage()
        );
    }

    @Test
    @Epic(value = "Проверка компонентов")
    @Feature(value = "Кнопка конструктор")
    @DisplayName("Проверка перехода при нажатии на кнопку 'Конструктор' в личном кабинете")
    @Severity(SeverityLevel.CRITICAL)
    public void transitionCheckFromConstructorButtonTest() {
        assertTrue(new StellarburgersHomePage(driver)
                .loginPersonalKabinet(user)
                .clickConstructorButton()
                .isValidMainPage()
        );
    }

    @Test
    @Epic(value = "Проверка компонентов")
    @Feature(value = "Логотип")
    @DisplayName("Проверка перехода при нажатии на логотип в личном кабинете")
    @Severity(SeverityLevel.CRITICAL)
    public void transitionCheckFromLogoTest() {
        assertTrue(new StellarburgersHomePage(driver)
                .loginPersonalKabinet(user)
                .clickLogo()
                .isValidMainPage()
        );
    }

    @After
    public void teardown() {
        driver.quit();
        delete(user);
    }

}