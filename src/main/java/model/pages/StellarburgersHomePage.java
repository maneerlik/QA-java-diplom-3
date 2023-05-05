package model.pages;

import io.github.cdimascio.dotenv.Dotenv;
import io.qameta.allure.Step;
import model.pojo.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Map;

/**
 * Домашняя страница https://stellarburgers.nomoreparties.site
 *
 * @author  smirnov sergey
 * @since   30.04.2023
 */
public class StellarburgersHomePage extends BasePage {

    private final By ingredientContainer = By.xpath("//div[@class='BurgerIngredients_ingredients__menuContainer__Xu3Mo']");
    private final By sectionBuns = By.xpath("//h2[text()='Булки']");
    private final By sectionSauces = By.xpath("//h2[text()='Соусы']");
    private final By sectionFillings = By.xpath("//h2[text()='Начинки']");
    private final By burgerHeader = By.xpath("//h1[text()='Соберите бургер']");
    private final By signInAccountButton = By.xpath("//button[text()='Войти в аккаунт']");
    private final By personalKabinet = By.xpath("//p[text()='Личный Кабинет']");
    private final By bunsButton = By.xpath("//span[text()='Булки']");
    private final By saucesButton = By.xpath("//span[text()='Соусы']");
    private final By fillingsButton = By.xpath("//span[text()='Начинки']");

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

    @Step("Нажатие на кнопку 'Личный Кабинет'")
    public LoginPage clickPersonalKabinetButton() {
        clickButton(personalKabinet);
        return new LoginPage(driver);
    }

    @Step("Нажать кнопку 'Булки'")
    public StellarburgersHomePage clickBunsButton() {
        clickButton(bunsButton);
        return this;
    }

    @Step("Проверка позиции раздела {section}")
    public boolean isSectionPositionTop(String section) throws InterruptedException {
        Map<String, By> sections = Map.of(
                "Булки", sectionBuns,
                "Соусы", sectionSauces,
                "Начинки", sectionFillings
        );

        Thread.sleep(1000);

        // сравнивает позицию контейнера ингредиентов с позицией наименования раздела
        return Math.abs(getTopPositionElement(ingredientContainer) - getTopPositionElement(sections.get(section))) < 0.3;
    }

    @Step("Нажать кнопку 'Соусы'")
    public StellarburgersHomePage clickSaucesButton() {
        clickButton(saucesButton);
        return this;
    }

    @Step("Нажать кнопку 'Начинки'")
    public StellarburgersHomePage clickFillingsButton() {
        clickButton(fillingsButton);
        return this;
    }

    @Step("Валидация главной страницы")
    public boolean isValidMainPage() {
        return isValidPage(Dotenv.load().get("STELLARBURGERS_URL"), burgerHeader);
    }

    @Step("Проверка отображения кнопки 'Оформить заказ'")
    public boolean isMakeOrderButtonVisible() {
        return isVisibleElement(burgerHeader);
    }

    @Step("Вход в личный кабинет")
    public PersonalKabinetPage loginPersonalKabinet(User user) {
        clickSignInAccountButton().fillAutorizationForm(user).clickPersonalKabinetButton();
        return new PersonalKabinetPage(driver);
    }

}