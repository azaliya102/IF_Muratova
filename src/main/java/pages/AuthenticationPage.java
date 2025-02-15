package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import java.time.Duration;

import static com.codeborne.selenide.Selenide.$x;

public class AuthenticationPage {
    private final SelenideElement inputName = $x("//input[@name='os_username']")
            .as("Имя пользователя");
    private final SelenideElement inputPassword = $x("//input[@name='os_password']")
            .as("Пароль пользователя");
    private final SelenideElement loginButton = $x("//input[@name='login']")
            .as("Кнопка \"Войти\"");
    private final SelenideElement userProfile = $x("//a[@id='header-details-user-fullname']")
            .as("Уголок пользователя");

    public void login(String log, String pass) {
        inputName.shouldBe(Condition.visible, Duration.ofSeconds(10)).setValue(log);
        inputPassword.shouldBe(Condition.visible, Duration.ofSeconds(10)).setValue(pass);
        loginButton.click();
        userProfile.shouldBe(Condition.visible, Duration.ofSeconds(10));
    }
}
