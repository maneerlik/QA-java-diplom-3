package tests;

import extensions.WebDriverFactory;
import io.github.cdimascio.dotenv.Dotenv;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.junit4.DisplayName;
import model.pages.RegistrationPage;
import model.pojo.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static data.RandomUser.randomPassword;
import static data.RandomUser.randomUserWithoutPassword;
import static steps.BaseSteps.delete;

/**
 * Тест неудачная регистрация пользователя
 *
 * @author  smirnov sergey
 * @since   01.05.2023
 */
@RunWith(Parameterized.class)
public class FailUserRegistrationTest {

    private WebDriver driver;

    private User user;
    private final String password;

    @Before
    public void setup() {
        user = randomUserWithoutPassword();
        driver = WebDriverFactory.getDriver(Dotenv.load().get("REGISTRATION_URL"));
    }

    /**
     * конструктор
     *
     * @param password  пароль
     */
    public FailUserRegistrationTest(String password) {
        this.password = password;
    }

    @Parameterized.Parameters(name = "{index}: password - {0}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                        { randomPassword(5) }, // случайный пароль 5 символов
                        { randomPassword(0) }, // пустой пароль
                        { "\u0020\u0020\u0020\u0020\u0020\u0020" } // 6 пробелов
                }
        );
    }

    @Test(expected = TimeoutException.class)
    @Epic(value = "Авторизация и регистрация пользователя")
    @Feature(value = "Регистрация пользователя")
    @DisplayName("Неудачная регистрация пользователя")
    @Description("Попытка зарегистрировать пользователя с некорректным паролем")
    public void failUserRegistrationTest() {
        user.setPassword(password); // заменяет пароль пользователя
        new RegistrationPage(driver)
                .fillRegistrationForm(List.of(user.getName(), user.getEmail(), user.getPassword()))
                .clickRegistrationButton()
                .isValidLoginPage(); // ожидает перехода на страницу логина после успешной регистрации
    }

    @After
    public void teardown() {
        driver.quit();
        delete(user);
    }

}