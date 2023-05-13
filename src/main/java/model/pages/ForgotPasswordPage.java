package model.pages;

import org.openqa.selenium.WebDriver;

import static common.Constants.*;

/**
 * Страница восстановления пароля https://stellarburgers.nomoreparties.site/forgot-password
 *
 * @author  smirnov sergey
 * @since   02.05.2023
 */
public class ForgotPasswordPage extends BasePage {

    /**
     * конструктор
     *
     * @param driver    веб-драйвер.
     */
    public ForgotPasswordPage(WebDriver driver) {
        super(driver);
        setURL(FORGOT_PASSWORD_PAGE_URL);
        setButtons(FORGOT_PASSWORD_PAGE_BUTTONS);
    }

}