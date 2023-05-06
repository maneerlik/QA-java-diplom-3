package common;

import org.openqa.selenium.By;

import java.util.Map;

/**
 * Константы
 *
 * @author  smirnov sergey
 * @since   01.05.2023
 */
public class Constants {

    /*
    * Константы страницы STELLARBURGERS_HOME_PAGE:
    */

    // url
    public static final String STELLARBURGERS_PAGE_URL = "https://stellarburgers.nomoreparties.site/";

    // заголовок 'Соберите бургер' (идентификатор страницы)
    public static final By STELLARBURGERS_PAGE_CONSTRUCTOR_HEADER = By.xpath("//h1[text()='Соберите бургер']");

    // контейнер ингредиентов, для проверки переходов конструктора
    public static final By STELLARBURGERS_PAGE_INGREDIENT_CONTAINER =
            By.xpath("//div[@class='BurgerIngredients_ingredients__menuContainer__Xu3Mo']");

    // кнопки
    public static final Map<String, By> STELLARBURGERS_HOME_PAGE_BUTTONS = Map.of(
            "Войти в аккаунт", By.xpath("//button[text()='Войти в аккаунт']"),
            "Оформить заказ", By.xpath("//button[text()='Оформить заказ']"),
            "Личный Кабинет", By.xpath("//p[text()='Личный Кабинет']"),
            "Булки", By.xpath("//span[text()='Булки']"),
            "Соусы", By.xpath("//span[text()='Соусы']"),
            "Начинки", By.xpath("//span[text()='Начинки']")
    );

    // заголовки разделов конструктора
    public static final Map<String, By> STELLARBURGERS_HOME_PAGE_TITLES_OF_SECTION = Map.of(
            "Булки", By.xpath("//h2[text()='Булки']"),
            "Соусы", By.xpath("//h2[text()='Соусы']"),
            "Начинки", By.xpath("//h2[text()='Начинки']")
    );
    //------------------------------------------------------------------------------------------------------------------

    /*
     * Константы страницы LOGIN_PAGE:
     */

    // url
    public static final String LOGIN_PAGE_URL = "https://stellarburgers.nomoreparties.site/login";

    // заголовок страницы (идентификатор страницы)
    public static final By LOGIN_PAGE_HEADER = By.xpath("//h2[text()='Вход']");

    // кнопки
    public static final Map<String, By> LOGIN_PAGE_BUTTONS = Map.of(
            "Войти", By.xpath("//button[text()='Войти']"),
            "Зарегистрироваться", By.xpath("//a[text()='Зарегистрироваться']"),
            "Восстановить пароль", By.xpath("//a[text()='Восстановить пароль']")
    );

    // поля ввода
    public static final Map<String, By> LOGIN_PAGE_FIELDS = Map.of(
            "Email", By.xpath("//label[text()='Email']/following-sibling::input"),
            "Пароль", By.xpath("//label[text()='Пароль']/following-sibling::input")
    );
    //------------------------------------------------------------------------------------------------------------------

    /*
     * Константы страницы REGISTRATION_PAGE:
     */

    // url
    public static final String REGISTRATION_PAGE_URL = "https://stellarburgers.nomoreparties.site/register";

    // статический текст (идентификатор страницы)
    public static final By REGISTRATION_PAGE_HEADER = By.xpath("//h2[text()='Регистрация']");

    // кнопки
    public static final Map<String, By> REGISTRATION_PAGE_BUTTONS = Map.of(
            "Войти", By.xpath("//a[text()='Войти']"),
            "Зарегистрироваться", By.xpath("//button[text()='Зарегистрироваться']")
    );

    // поля ввода
    public static final Map<String, By> REGISTRATION_PAGE_FIELDS = Map.of(
            "Имя", By.xpath("//label[text()='Имя']/../input"),
            "Email", By.xpath("//label[text()='Email']/../input"),
            "Пароль", By.xpath("//label[text()='Пароль']/../input")
    );
    //------------------------------------------------------------------------------------------------------------------

    /*
     * Константы страницы PERSONAL_KABINET_PAGE:
     */

    // url
    public static final String PERSONAL_KABINET_PAGE_URL = "https://stellarburgers.nomoreparties.site/account/profile";

    // статический текст (идентификатор страницы)
    public static final By PERSONAL_KABINET_PAGE_TEXT_PANE =
            By.xpath("//p[text()='В этом разделе вы можете изменить свои персональные данные']");

    // кнопки
    public static final Map<String, By> PERSONAL_KABINET_PAGE_BUTTONS = Map.of(
            "Логотип сайта", By.xpath("//div[@class='AppHeader_header__logo__2D0X2']/a"),
            "Конструктор", By.xpath("//p[text()='Конструктор']"),
            "Выход", By.xpath("//button[text()='Выход']")
    );
    //------------------------------------------------------------------------------------------------------------------

    /*
     * Константы страницы FORGOT_PASSWORD_PAGE:
     */

    // url
    public static final String FORGOT_PASSWORD_PAGE_URL = "https://stellarburgers.nomoreparties.site/forgot-password";

    // кнопки
    public static final Map<String, By> FORGOT_PASSWORD_PAGE_BUTTONS = Map.of(
            "Войти", By.xpath("//a[text()='Войти']")
    );

}