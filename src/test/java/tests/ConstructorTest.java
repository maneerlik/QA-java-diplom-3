package tests;

import extensions.WebDriverFactory;
import io.github.cdimascio.dotenv.Dotenv;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.junit4.DisplayName;
import model.pages.StellarburgersHomePage;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertTrue;

/**
 * Тест раздела Конструктор
 *
 * @author  smirnov sergey
 * @since   03.05.2023
 */
public class ConstructorTest {

    private WebDriver driver;

    @Before
    public void setup() {
        driver = WebDriverFactory.getDriver(Dotenv.load().get("STELLARBURGERS_URL"));
    }

    @Test
    @Epic(value = "Конструктор")
    @Feature(value = "Проверка перехода по разделам")
    @DisplayName("Проверка перехода к разделу по нажатию соответствующей кнопки")
    @Severity(SeverityLevel.CRITICAL)
    public void constructorSectionTest() throws InterruptedException {
        assertTrue(new StellarburgersHomePage(driver)
                .clickSaucesButton()
                .isSectionPositionTop("Соусы")
        );
    }

}