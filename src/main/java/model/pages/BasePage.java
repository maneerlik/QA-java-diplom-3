package model.pages;

import io.github.cdimascio.dotenv.Dotenv;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Map;
import java.util.logging.Logger;

/**
 * Реализация базовых методов POM
 *
 * @author  smirnov sergey
 * @since   30.04.2023
 */
public class BasePage {

    protected WebDriver driver;
    private String url;
    private By identifier;
    private Map<String, By> buttons;
    private Map<String, By> fields;

    /**
     * конструктор
     *
     * @param driver    веб-драйвер.
     */
    protected BasePage(WebDriver driver) {
        this.driver = driver;
    }

    // нажать на кнопку из справочника
    @Step("Нажать кнопку '{button}'")
    public BasePage click(String button) {
        if(isFound(button, buttons)) {
            By btn = buttons.get(button);
            new WebDriverWait(driver, Duration.ofSeconds(5))
                    .until(ExpectedConditions.elementToBeClickable(btn));
            driver.findElement(btn).click();
        }
        return this;
    }

    // заполнить поле
    @Step("Ввести '{value}' в поле '{field}'")
    public void fill(String field, String value) {
        if(isFound(field, fields)) driver.findElement(fields.get(field)).sendKeys(value);
    }

    // проверка отображения кнопки
    @Step("Проверка отображения кнопки '{button}'")
    public boolean isVisibleButton(String button) {
        if(isFound(button, buttons)) return isVisibleElement(buttons.get(button));
        else return false;
    }

    // валидация страницы
    @Step("Валидация страницы '{clazz}'")
    public <T> boolean isValidatePage(Class<T> clazz) {
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(drv -> isVisibleElement(identifier));
        return driver.getCurrentUrl().equals(url) && isVisibleElement(identifier);
    }

    @Step("Переход на страницу '{page}'")
    public <T extends BasePage> T goToPage(T page) {
        return page;
    }

    // проверка видимости элемента
    private boolean isVisibleElement(By element) {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(element));
        return driver.findElement(element).isDisplayed();
    }

    protected boolean isFound(String key, Map<String, By> elements) {
        try {
            return elements.containsKey(key);
        } catch(NullPointerException e) {
            Logger log = Logger.getLogger(BasePage.class.getName());
            log.info(key);
            log.info(Dotenv.load().get("NULL_POINTER_EXCEPTION"));
        }
        return false;
    }

    protected void setButtons(Map<String, By> buttons) {
        this.buttons = buttons;
    }

    protected void setFields(Map<String, By> fields) {
        this.fields = fields;
    }

    protected void setURL(String url) {
        this.url = url;
    }

    protected void setIdentifier(By identifier) {
        this.identifier = identifier;
    }

    // оставил часть предыдущей реализации - на память о боли :)
//    // получает локатор объекта By в строковом представлении
//    protected String getXPath(By by) {
//        return by.toString().replace("By.xpath: ", "");
//    }
//
//    /*
//     * Получает значение координаты y/top элемента из DOMRect объекта скриптом JS
//     * document.evaluate("xpath", document, null, XPathResult.ANY_TYPE, null).iterateNext().getBoundingClientRect().top
//     */
//    protected double getTopPositionElement(By by) {
//        JavascriptExecutor js = (JavascriptExecutor)driver;
//        return (double) js.executeScript(String.format(
//               "return document.evaluate(\"%s\", document, null, XPathResult.ANY_TYPE, null)" +
//                       ".iterateNext().getBoundingClientRect().top", getXPath(by)
//        ));
//    }

//    /*
//     * Нажать на кнопку с переходом на другую страницу.
//     * Реализация клика по кнопке с переходом на следующую страницу. Возвращает POM объект.
//     */
//    @Step("Нажать кнопку '{button}' и перейти на страницу '{clazz}'")
//    public <T extends BasePage> T transitionClick(String button, T page) {
//        click(button);
//        return page;
//    }

}