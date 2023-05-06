package model.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Map;

/**
 * Страница восстановления пароля https://stellarburgers.nomoreparties.site/forgot-password
 *
 * @author  smirnov sergey
 * @since   02.05.2023
 */
public class ForgotPasswordPage extends BasePage {

    // кнопки
    private final Map<String, By> buttons = Map.of(
            "Войти", By.xpath("//a[text()='Войти']")
    );

    /**
     * конструктор
     *
     * @param driver    веб-драйвер.
     */
    public ForgotPasswordPage(WebDriver driver) {
        super(driver);
        setButtons(buttons);
    }

}