package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import java.time.Duration;

import static com.codeborne.selenide.Selenide.$x;

public class AuthPage {
    private final SelenideElement inputName = $x("//input[@name='os_username']");
    private final SelenideElement inputPassword = $x("//input[@name='os_password']");
    private final SelenideElement loginButton = $x("//input[@name='login']");
    private final SelenideElement userProfile = $x("//a[@id='header-details-user-fullname']");

    public void login(String log, String pass) {
        inputName.shouldBe(Condition.visible, Duration.ofSeconds(10)).setValue(log);
        inputPassword.shouldBe(Condition.visible, Duration.ofSeconds(10)).setValue(pass);
        loginButton.click();
        userProfile.shouldBe(Condition.visible, Duration.ofSeconds(10));
    }
}
