package model.pages;

import io.github.cdimascio.dotenv.Dotenv;
import io.qameta.allure.Step;
import model.pojo.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Map;

/**
 * Страница логина пользователя https://stellarburgers.nomoreparties.site/login
 *
 * @author  smirnov sergey
 * @since   01.05.2023
 */
public class LoginPage extends BasePage {

    // заголовок страницы (идентификатор страницы)
    private final By loginHeader = By.xpath("//h2[text()='Вход']");

    // кнопки
    private final Map<String, By> buttons = Map.of(
            "Войти", By.xpath("//button[text()='Войти']"),
            "Зарегистрироваться", By.xpath("//a[text()='Зарегистрироваться']"),
            "Восстановить пароль", By.xpath("//a[text()='Восстановить пароль']")
    );

    // поля ввода
    private final Map<String, By> fields = Map.of(
            "Email", By.xpath("//label[text()='Email']/following-sibling::input"),
            "Пароль", By.xpath("//label[text()='Пароль']/following-sibling::input")
    );

    /**
     * конструктор
     *
     * @param driver    веб-драйвер.
     */
    public LoginPage(WebDriver driver) {
        super(driver);
        setURL(Dotenv.load().get("LOGIN_URL"));
        setButtons(buttons);
        setFields(fields);
        setIdentifier(loginHeader);
    }

    @Step("Авторизоваться")
    public StellarburgersHomePage logIn(User user) {
        fill("Email", user.getEmail());
        fill("Пароль", user.getPassword());
        return transitionClick("Войти", new StellarburgersHomePage(driver));
    }

}