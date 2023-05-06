package model.pages;

import io.qameta.allure.Step;
import model.pojo.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Map;

import static common.Constants.*;

/**
 * Домашняя страница https://stellarburgers.nomoreparties.site
 *
 * @author  smirnov sergey
 * @since   30.04.2023
 */
public class StellarburgersHomePage extends BasePage {

    /**
     * конструктор
     *
     * @param driver    веб-драйвер.
     */
    public StellarburgersHomePage(WebDriver driver) {
        super(driver);
        setURL(STELLARBURGERS_PAGE_URL);
        setButtons(STELLARBURGERS_HOME_PAGE_BUTTONS);
        setIdentifier(STELLARBURGERS_PAGE_CONSTRUCTOR_HEADER);
    }

    /*
     * Проверяет, совпадение координаты по (y) 'контейнера ингредиентов' и 'наименования раздела ингредиентов',
     * если элемент не существует бросает исключение
     */
    @Step("Проверка прокрутки раздела '{section}' относительно области конструктора")
    public boolean isSectionPositionScrolled(String section) {
        Map<String, By> sections = STELLARBURGERS_HOME_PAGE_TITLES_OF_SECTION;
        if(isFound(section, sections)) {
            return new WebDriverWait(driver, Duration.ofSeconds(5)).until(
                    drv -> (Math.abs(drv.findElement(STELLARBURGERS_PAGE_INGREDIENT_CONTAINER).getLocation().y -
                            drv.findElement(sections.get(section)).getLocation().y) < 0.3));
        } else return false;
    }

    @Step("Авторизоваться и перейти в личный кабинет")
    public PersonalKabinetPage loginPersonalKabinet(User user) {
        return click("Войти в аккаунт")
                .goToPage(new LoginPage(driver))
                .logIn(user)
                .click("Личный Кабинет")
                .goToPage(new PersonalKabinetPage(driver));
    }

}