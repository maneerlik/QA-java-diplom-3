package model.pages;

import io.github.cdimascio.dotenv.Dotenv;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Страница логина пользователя https://stellarburgers.nomoreparties.site/login
 *
 * @author  smirnov sergey
 * @since   01.05.2023
 */
public class LoginPage extends BasePage {

    private final By loginHeader = By.xpath("//h2[text()='Вход']");
    private final By emailInputField = By.xpath("//label[text()='Email']/following-sibling::input");
    private final By passwordInputField = By.xpath("//label[text()='Пароль']/following-sibling::input");
    private final By loginButton = By.xpath("//button[text()='Войти']");

    /**
     * конструктор
     *
     * @param driver    веб-драйвер.
     */
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Step("Ввод электронного адреса': {email}")
    public LoginPage fillEmail(String email) {
        fillTheInputField(emailInputField, email);
        return this;
    }

    @Step("Ввод пароля: {password}")
    public LoginPage fillPassword(String password) {
        fillTheInputField(passwordInputField, password);
        return this;
    }

    @Step("Нажатие на кнопку 'Войти'")
    public StellarburgersHomePage clickLoginButton() {
        clickButton(loginButton);
        return new StellarburgersHomePage(driver);
    }

    @Step("Валидация страницы логина")
    public boolean isValidLoginPage() {
        return isValidPage(Dotenv.load().get("LOGIN_URL"), loginHeader);
    }

}