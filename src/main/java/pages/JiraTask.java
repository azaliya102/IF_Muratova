package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import java.time.Duration;
import static com.codeborne.selenide.Selenide.$x;

public class JiraTask {
    private final SelenideElement status = $x("//span[@id='status-val']/child::span")
            .as("Статус задачи");
    private final SelenideElement version = $x("//span[@id='fixVersions-field']/child::a")
            .as("Версия задачи");

    public String getStatus() {
        return status.shouldBe(Condition.visible, Duration.ofSeconds(10)).getText();
    }

    public String getVersion() {
        return version.shouldBe(Condition.visible, Duration.ofSeconds(10)).getText();
    }
}
