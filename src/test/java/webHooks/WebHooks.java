package webHooks;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import java.io.InputStream;
import java.util.Properties;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class WebHooks {
    private static final Properties properties = new Properties();

    static {
        loadProperties();
    }
    public static String getProperty(String key) {
        return properties.getProperty(key);
    }

    private static void loadProperties() {
        try (InputStream input = ClassLoader.getSystemResourceAsStream("config.properties")) {
            if (input == null) {
                throw new RuntimeException("Файл config.properties не найден!");
            }
            properties.load(input);
        } catch (Exception e) {
            throw new RuntimeException("Ошибка загрузки config.properties", e);
        }
    }

    @BeforeAll
    public static void setup() {
        String browser = properties.getProperty("browser");
        if (browser != null && !browser.isEmpty()) {
            Configuration.browser = browser;
        }
    }

    @BeforeEach
    public void openBrowser() {
        String url = properties.getProperty("url");
        if (url == null || url.isEmpty()) {
            throw new RuntimeException("URL не задан в config.properties!");
        }
        Selenide.open(url);
        getWebDriver().manage().window().maximize();
    }

    @AfterEach
    public void closeBrowser(){
        Selenide.closeWebDriver();
    }
}
