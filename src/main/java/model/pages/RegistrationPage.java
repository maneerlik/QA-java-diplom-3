package model.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

import java.util.List;

import static common.Constants.*;

/**
 * Страница регистрации пользователя https://stellarburgers.nomoreparties.site/register
 *
 * @author  smirnov sergey
 * @since   30.04.2023
 */
public class RegistrationPage extends BasePage {

    /**
     * конструктор
     *
     * @param driver    веб-драйвер.
     */
    public RegistrationPage(WebDriver driver) {
        super(driver);
        setURL(REGISTRATION_PAGE_URL);
        setIdentifier(REGISTRATION_PAGE_HEADER);
        setButtons(REGISTRATION_PAGE_BUTTONS);
        setFields(REGISTRATION_PAGE_FIELDS);
    }

    @Step("Заполнить форму регистрации")
    public RegistrationPage fillRegistrationForm(List<String> userData) {
        fill("Имя", userData.get(0));
        fill("Email", userData.get(1));
        fill("Пароль", userData.get(2));
        return this;
    }

}