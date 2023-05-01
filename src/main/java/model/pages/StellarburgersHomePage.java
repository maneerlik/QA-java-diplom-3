package model.pages;

import io.github.cdimascio.dotenv.Dotenv;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Домашняя страница https://stellarburgers.nomoreparties.site
 *
 * @author  smirnov sergey
 * @since   30.04.2023
 */
public class StellarburgersHomePage extends BasePage {

    private final By registrationHeader = By.xpath("//h1[text()='Соберите бургер']");
    private final By signInAccountButton = By.xpath("//button[text()='Войти в аккаунт']");
    private final By makeOrderButton = By.xpath("//button[text()='Оформить заказ']");

    /**
     * конструктор
     *
     * @param driver    веб-драйвер.
     */
    public StellarburgersHomePage(WebDriver driver) {
        super(driver);
    }

    @Step("Нажатие на кнопку 'Войти в аккаунт'")
    public LoginPage clickSignInAccountButton() {
        clickButton(signInAccountButton);
        return new LoginPage(driver);
    }

    @Step("Валидация главной страницы")
    public boolean isValidMainPage() {
        return isValidPage(Dotenv.load().get("STELLARBURGERS_URL"), registrationHeader);
    }

}