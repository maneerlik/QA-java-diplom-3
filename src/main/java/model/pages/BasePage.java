package model.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/**
 * Реализация базовых методов
 *
 * @author  smirnov sergey
 * @since   30.04.2023
 */
public class BasePage {

    protected WebDriver driver;

    /**
     * конструктор
     *
     * @param driver    веб-драйвер.
     */
    protected BasePage(WebDriver driver) {
        this.driver = driver;
    }

    // заполнение поля ввода
    protected void fillTheInputField(By element, String value) {
        driver.findElement(element).sendKeys(value);
    }

    // нажатие на кнопку
    protected void clickButton(By element) {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(element));

        driver.findElement(element).click();
    }

    // проверка видимости элемента
    protected boolean isElementVisible(By element) {
        return driver.findElement(element).isDisplayed();
    }


    // ожидание загрузки элемента
    protected void elementLoaded(By element) {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(
                driver -> (driver.findElement(element).getText() != null
                        && !driver.findElement(element).getText().isEmpty()));
    }

    // валидация страницы
    protected boolean isValidPage(String url, By element) {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(element));

        return driver.getCurrentUrl().equals(url) && isElementVisible(element);
    }

}