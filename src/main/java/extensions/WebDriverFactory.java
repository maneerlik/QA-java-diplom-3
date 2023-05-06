package extensions;

import config.WebDriverConfig;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.cdimascio.dotenv.Dotenv;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

/**
 * Служебный класс для конфигурации драйвера
 *
 * @author  smirnov sergey
 * @since   29.04.2023
 */
public class WebDriverFactory {

    /**
     * приватный конструктор служебного класса
     */
    private WebDriverFactory() {
        throw new IllegalStateException("Utility class");
    }

    public static WebDriver getDriver(String url) {
        String browserName = Dotenv.load().get("BROWSER");

        WebDriver driver;
        switch(browserName) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                // --remote-allow-origins=* - для решения проблем с версией 111
                driver = new ChromeDriver(new ChromeOptions()
                        .addArguments("--remote-allow-origins=*")
                        .addArguments("--headless")
                );
                break;
            case "yandex":
                System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
                driver = new ChromeDriver(new ChromeOptions()
                        .setBinary("C:/Users/smirn/AppData/Local/Yandex/YandexBrowser/Application/browser.exe")
                        .addArguments("--headless")
                );
                break;
            default: throw new RuntimeException("Browser " + browserName + " not exist");
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(WebDriverConfig.WAIT_TEN_SECONDS_TIMEOUT));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(WebDriverConfig.WAIT_FIVE_SECONDS_TIMEOUT));
        driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(WebDriverConfig.WAIT_TEN_SECONDS_TIMEOUT));
        driver.get(url);

        return driver;
    }

}