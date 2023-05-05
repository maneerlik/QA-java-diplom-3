package model.pages.components;

import model.pages.BasePage;
import model.pages.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Компонент кнопка 'Войти' на странице регистрации/восстановления пароля
 *
 * @author  smirnov sergey
 * @since   02.05.2023
 */
public class LoginButtonComponent extends BasePage {

    private final By loginButton = By.xpath("//a[text()='Войти']");

    /**
     * конструктор
     *
     * @param driver    веб-драйвер.
     */
    public LoginButtonComponent(WebDriver driver) {
        super(driver);
    }

    public LoginPage clickLoginButton() {
        clickButton(loginButton);
        return new LoginPage(driver);
    }

}