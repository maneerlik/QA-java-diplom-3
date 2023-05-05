package model.pages;

import io.github.cdimascio.dotenv.Dotenv;
import io.qameta.allure.Step;
import model.pages.components.ConstructorButtonComponent;
import model.pages.components.LogoComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Страница персонального кабинета https://stellarburgers.nomoreparties.site/account/profile
 *
 * @author  smirnov sergey
 * @since   03.05.2023
 */
public class PersonalKabinetPage extends BasePage {

    private final ConstructorButtonComponent constructorButton;
    private final LogoComponent logo;

    private final By accountTextPane = By.xpath("//p[text()='В этом разделе вы можете изменить свои персональные данные']");
    private final By logoutButton = By.xpath("//button[text()='Выход']");

    /**
     * конструктор
     *
     * @param driver    веб-драйвер.
     */
    public PersonalKabinetPage(WebDriver driver) {
        super(driver);
        this.constructorButton = new ConstructorButtonComponent(driver);
        this.logo = new LogoComponent(driver);
    }

    @Step("Нажать кнопку 'Конструктор'")
    public StellarburgersHomePage clickConstructorButton() {
        constructorButton.clickConstructorButton();
        return new StellarburgersHomePage(driver);
    }

    @Step("Нажать на логотип")
    public StellarburgersHomePage clickLogo() {
        logo.clickLogo();
        return new StellarburgersHomePage(driver);
    }

    @Step("Нажать кнопку 'Выход'")
    public LoginPage clickLogout() {
        clickButton(logoutButton);
        return new LoginPage(driver);
    }

    @Step("Валидация страницы личного кабинета")
    public boolean isValidPersonalKabinetPage() {
        return isValidPage(Dotenv.load().get("PERSONAL_KABINET"), accountTextPane);
    }

}