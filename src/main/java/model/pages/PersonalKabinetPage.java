package model.pages;

import org.openqa.selenium.WebDriver;

import static common.Constants.*;

/**
 * Страница персонального кабинета https://stellarburgers.nomoreparties.site/account/profile
 *
 * @author  smirnov sergey
 * @since   03.05.2023
 */
public class PersonalKabinetPage extends BasePage {

    /**
     * конструктор
     *
     * @param driver    веб-драйвер.
     */
    public PersonalKabinetPage(WebDriver driver) {
        super(driver);
        setURL(PERSONAL_KABINET_PAGE_URL);
        setIdentifier(PERSONAL_KABINET_PAGE_TEXT_PANE);
        setButtons(PERSONAL_KABINET_PAGE_BUTTONS);
    }

}