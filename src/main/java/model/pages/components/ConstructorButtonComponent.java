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
public class ConstructorButtonComponent extends BasePage {

    private final By constructorButton = By.xpath("//p[text()='Конструктор']");

    /**
     * конструктор
     *
     * @param driver    веб-драйвер.
     */
    public ConstructorButtonComponent(WebDriver driver) {
        super(driver);
    }

    public StellarburgersHomePage clickConstructorButton() {
        clickButton(constructorButton);
        return new StellarburgersHomePage(driver);
    }

}