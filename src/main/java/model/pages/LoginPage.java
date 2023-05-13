package model.pages;

import io.qameta.allure.Step;
import model.pojo.User;
import org.openqa.selenium.WebDriver;

import static common.Constants.*;

/**
 * Страница логина пользователя https://stellarburgers.nomoreparties.site/login
 *
 * @author  smirnov sergey
 * @since   01.05.2023
 */
public class LoginPage extends BasePage {

    /**
     * конструктор
     *
     * @param driver    веб-драйвер.
     */
    public LoginPage(WebDriver driver) {
        super(driver);
        setURL(LOGIN_PAGE_URL);
        setButtons(LOGIN_PAGE_BUTTONS);
        setFields(LOGIN_PAGE_FIELDS);
        setIdentifier(LOGIN_PAGE_HEADER);
    }

    @Step("Авторизоваться")
    public StellarburgersHomePage logIn(User user) {
        fill("Email", user.getEmail());
        fill("Пароль", user.getPassword());
        return click("Войти")
                .goToPage(new StellarburgersHomePage(driver));
    }

}