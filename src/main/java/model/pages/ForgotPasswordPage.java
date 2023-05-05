package model.pages;

import io.qameta.allure.Step;
import model.pages.components.LoginButtonComponent;
import org.openqa.selenium.WebDriver;

/**
 * Страница восстановления пароля https://stellarburgers.nomoreparties.site/forgot-password
 *
 * @author  smirnov sergey
 * @since   02.05.2023
 */
public class ForgotPasswordPage extends BasePage {

    private final LoginButtonComponent loginButton;

    /**
     * конструктор
     *
     * @param driver    веб-драйвер.
     */
    public ForgotPasswordPage(WebDriver driver) {
        super(driver);
        this.loginButton = new LoginButtonComponent(driver);
    }

    @Step("Нажатие на кнопку 'Войти'")
    public LoginPage clickLoginButton() {
        loginButton.clickLoginButton();
        return new LoginPage(driver);
    }

}