package model.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.List;

/**
 * Страница регистрации пользователя https://stellarburgers.nomoreparties.site/register
 *
 * @author  smirnov sergey
 * @since   30.04.2023
 */
public class RegistrationPage extends BasePage {

    private final By registrationHeader = By.xpath("//h2[text()='Регистрация']");
    private final By nameInputField = By.xpath("//label[text()='Имя']/../input");
    private final By emailInputField = By.xpath("//label[text()='Email']/../input");
    private final By passwordInputField = By.xpath("//label[text()='Пароль']/../input");
    private final By registrationButton = By.xpath("//button[text()='Зарегистрироваться']");
    private final By passwordInputErrorText = By.xpath("//p[text()='Некорректный пароль']");

    /**
     * конструктор
     *
     * @param driver    веб-драйвер.
     */
    public RegistrationPage(WebDriver driver) {
        super(driver);
    }

    @Step("Ввод имени: {name}")
    public RegistrationPage fillName(String name) {
        fillTheInputField(nameInputField, name);
        return this;
    }

    @Step("Ввод электронного адреса: {email}")
    public RegistrationPage fillEmail(String email) {
        fillTheInputField(emailInputField, email);
        return this;
    }

    @Step("Ввод пароля: {password}")
    public RegistrationPage fillPassword(String password) {
        fillTheInputField(passwordInputField, password);
        return this;
    }

    @Step("Заполнение формы регистрации")
    public RegistrationPage fillRegistrationForm(List<String> userData) {
        fillName(userData.get(0));
        fillEmail(userData.get(1));
        fillPassword(userData.get(2));
        return this;
    }

    // не используется
    @Step("Проверка валидатора пароля")
    public boolean isValidationPassword() {
        return isElementVisible(passwordInputErrorText);
    }

    @Step("Нажатие на кнопку 'Зарегистрироваться'")
    public LoginPage clickRegistrationButton() {
        clickButton(registrationButton);
        return new LoginPage(driver);
    }

}