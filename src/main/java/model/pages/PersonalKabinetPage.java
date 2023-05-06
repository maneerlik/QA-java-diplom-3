package model.pages;

import io.github.cdimascio.dotenv.Dotenv;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Map;

/**
 * Страница персонального кабинета https://stellarburgers.nomoreparties.site/account/profile
 *
 * @author  smirnov sergey
 * @since   03.05.2023
 */
public class PersonalKabinetPage extends BasePage {

    // статический текст (идентификатор страницы)
    private final By accountTextPane =
            By.xpath("//p[text()='В этом разделе вы можете изменить свои персональные данные']");

    // кнопки
    private final Map<String, By> buttons = Map.of(
            "Логотип сайта", By.xpath("//div[@class='AppHeader_header__logo__2D0X2']/a"),
            "Конструктор", By.xpath("//p[text()='Конструктор']"),
            "Выход", By.xpath("//button[text()='Выход']")
    );

    /**
     * конструктор
     *
     * @param driver    веб-драйвер.
     */
    public PersonalKabinetPage(WebDriver driver) {
        super(driver);
        setURL(Dotenv.load().get("PERSONAL_KABINET"));
        setIdentifier(accountTextPane);
        setButtons(buttons);
    }

}