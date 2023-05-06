package model.pages;

import io.github.cdimascio.dotenv.Dotenv;
import io.qameta.allure.Step;
import model.pojo.User;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
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

    // заголовок 'Соберите бургер' (идентификатор страницы)
    private final By constructorHeader = By.xpath("//h1[text()='Соберите бургер']");
    // контейнер ингредиентов, для проверки переходов конструктора
    private final By ingredientContainer =
            By.xpath("//div[@class='BurgerIngredients_ingredients__menuContainer__Xu3Mo']");

    // заголовки разделов конструктора
    private final Map<String, By> sections = Map.of(
            "Булки", By.xpath("//h2[text()='Булки']"),
            "Соусы", By.xpath("//h2[text()='Соусы']"),
            "Начинки", By.xpath("//h2[text()='Начинки']")
    );

    // кнопки
    private final Map<String, By> buttons = Map.of(
            "Войти в аккаунт", By.xpath("//button[text()='Войти в аккаунт']"),
            "Оформить заказ", By.xpath("//button[text()='Оформить заказ']"),
            "Личный Кабинет", By.xpath("//p[text()='Личный Кабинет']"),
            "Булки", By.xpath("//span[text()='Булки']"),
            "Соусы", By.xpath("//span[text()='Соусы']"),
            "Начинки", By.xpath("//span[text()='Начинки']")
    );

    /**
     * конструктор
     *
     * @param driver    веб-драйвер.
     */
    public StellarburgersHomePage(WebDriver driver) {
        super(driver);
        setURL(Dotenv.load().get("STELLARBURGERS_URL"));
        setButtons(buttons);
        setIdentifier(constructorHeader);
    }

    /*
     * Проверяет, совпадение координаты по (y) 'контейнера ингредиентов' и 'наименования раздела ингредиентов',
     * если элемент не существует бросает исключение
     */
    @Step("Проверка прокрутки раздела '{section}' относительно области конструктора")
    public boolean isSectionPositionScrolled(String section) {
        if(sections.containsKey(section)) {
            return new WebDriverWait(driver, Duration.ofSeconds(5)).until(
                    drv -> (Math.abs(drv.findElement(ingredientContainer).getLocation().y -
                            drv.findElement(sections.get(section)).getLocation().y) < 0.3));
        } else {
            throw new NoSuchElementException("Элемент не был найден");
        }
    }

    @Step("Авторизоваться и перейти в личный кабинет")
    public PersonalKabinetPage loginPersonalKabinet(User user) {
        return transitionClick("Войти в аккаунт", new LoginPage(driver))
                .logIn(user)
                .transitionClick("Личный Кабинет", new PersonalKabinetPage(driver));
    }

}