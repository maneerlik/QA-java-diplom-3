package model.pages;

import io.github.cdimascio.dotenv.Dotenv;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.List;
import java.util.Map;

/**
 * Страница регистрации пользователя https://stellarburgers.nomoreparties.site/register
 *
 * @author  smirnov sergey
 * @since   30.04.2023
 */
public class RegistrationPage extends BasePage {

    // статический текст (идентификатор страницы)
    private final By registrationHeader = By.xpath("//h2[text()='Регистрация']");

    // кнопки
    private final Map<String, By> buttons = Map.of(
            "Войти", By.xpath("//a[text()='Войти']"),
            "Зарегистрироваться", By.xpath("//button[text()='Зарегистрироваться']")
    );

    // поля ввода
    private final Map<String, By> fields = Map.of(
            "Имя", By.xpath("//label[text()='Имя']/../input"),
            "Email", By.xpath("//label[text()='Email']/../input"),
            "Пароль", By.xpath("//label[text()='Пароль']/../input")
    );

    /**
     * конструктор
     *
     * @param driver    веб-драйвер.
     */
    public RegistrationPage(WebDriver driver) {
        super(driver);
        setURL(Dotenv.load().get("REGISTRATION_URL"));
        setIdentifier(registrationHeader);
        setButtons(buttons);
        setFields(fields);
    }

    @Step("Заполнить форму регистрации")
    public RegistrationPage fillRegistrationForm(List<String> userData) {
        fill("Имя", userData.get(0));
        fill("Email", userData.get(1));
        fill("Пароль", userData.get(2));
        return this;
    }

}