package model.pages;

import org.openqa.selenium.*;
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
    protected boolean isVisibleElement(By element) {
        return driver.findElement(element).isDisplayed();
    }

    // валидация страницы
    protected boolean isValidPage(String url, By element) {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(element));

        return driver.getCurrentUrl().equals(url) && isVisibleElement(element);
    }

    // ожидание загрузки страницы
    protected void waitingLoadPage(String url, By element) {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(
                driver -> (driver.getCurrentUrl().equals(url) && driver.findElement(element).isDisplayed()));
    }

    // получает локатор объекта By в строковом представлении
    protected String getXPath(By by) {
        return by.toString().replace("By.xpath: ", "");
    }

    /*
     * Получает значение координаты y/top элемента из DOMRect объекта скриптом JS
     * document.evaluate("xpath", document, null, XPathResult.ANY_TYPE, null).iterateNext().getBoundingClientRect().top
     */
    protected double getTopPositionElement(By by) {
        JavascriptExecutor js = (JavascriptExecutor)driver;
        return (double) js.executeScript(String.format(
               "return document.evaluate(\"%s\", document, null, XPathResult.ANY_TYPE, null)" +
                       ".iterateNext().getBoundingClientRect().top", getXPath(by)
        ));
    }

}