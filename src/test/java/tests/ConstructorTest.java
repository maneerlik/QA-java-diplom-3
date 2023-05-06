package tests;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.junit4.DisplayName;
import model.pages.StellarburgersHomePage;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertTrue;

/**
 * Тест раздела Конструктор
 *
 * @author  smirnov sergey
 * @since   03.05.2023
 */
@RunWith(Parameterized.class)
public class ConstructorTest extends BaseWeb {

    private final String firstButton;
    private final String secondButton;
    private final String section;

    public ConstructorTest(String firstButton, String secondButton, String section) {
        this.firstButton = firstButton;
        this.secondButton = secondButton;
        this.section = section;
    }

    @Parameterized.Parameters(name = "{index}: {0} > {1}, проверка перехода к разделу {2}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                { "Начинки", "Соусы", "Соусы" },    // нажимает: Начинки > Соусы, проверяет переход к разделу Соусы
                { "Соусы", "Начинки",  "Начинки"},  // нажимает: Соусы > Начинки, проверяет переход к разделу Начинки
                { "Начинки", "Булки",  "Булки"}     // нажимает: Начинки > Булки, проверяет переход к разделу Булки
            }
        );
    }

    @Test
    @Epic(value = "Конструктор")
    @Feature(value = "Проверка перехода по разделам")
    @DisplayName("Проверка перехода к разделу по нажатию соответствующей кнопки")
    @Severity(SeverityLevel.MINOR)
    public void constructorSectionTest() {
        StellarburgersHomePage page = new StellarburgersHomePage(driver);
            page.click(firstButton);
            page.click(secondButton);
            assertTrue(page.isSectionPositionScrolled(section)
        );
    }

}