package model.pages.components;

import model.pages.BasePage;
import model.pages.StellarburgersHomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Компонент кнопка 'Конструктор'
 *
 * @author  smirnov sergey
 * @since   03.05.2023
 */
public class LogoComponent extends BasePage {

    private final By logoArea = By.xpath("//div[@class='AppHeader_header__logo__2D0X2']/a");

    /**
     * конструктор
     *
     * @param driver    веб-драйвер.
     */
    public LogoComponent(WebDriver driver) {
        super(driver);
    }

    public StellarburgersHomePage clickLogo() {
        clickButton(logoArea);
        return new StellarburgersHomePage(driver);
    }

}