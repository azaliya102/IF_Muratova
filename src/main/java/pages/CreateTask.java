package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import java.time.Duration;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.switchTo;

public class CreateTask {
    private final SelenideElement createTask = $x("//*[@id='create_link']")
            .as("\"Кнопка Создать\"");
    private final SelenideElement summaryField = $x("//*[@id='summary']")
            .as("Тема задачи");
    private final SelenideElement submitButton = $x("//*[@id='create-issue-submit']")
            .as("\"Кнопка Создать\"(подтверждение)");
    private final SelenideElement createdTaskLink = $x("//a[@class='issue-created-key issue-link']")
            .as("Уведомление о созданной задаче");

    public void createTask(String taskTheme, String description, String environmentDescription) {
        createTask.shouldBe(Condition.visible, Duration.ofSeconds(10)).click();
        summaryField.shouldBe(Condition.visible, Duration.ofSeconds(10)).setValue(taskTheme);
        SelenideElement iframe = $x("//iframe[@id='mce_0_ifr']")
                .shouldBe(Condition.visible, Duration.ofSeconds(10));
        switchTo().frame(iframe);
        SelenideElement iframeTextArea = $x("//body[@id='tinymce']");
        iframeTextArea.shouldBe(Condition.visible, Duration.ofSeconds(10)).setValue(description);
        switchTo().defaultContent();
        SelenideElement envIframe = $x("//*[@id=\"mce_6_ifr\"]")
                .shouldBe(Condition.visible, Duration.ofSeconds(10));
        switchTo().frame(envIframe);
        SelenideElement envIframeTextArea = $x("//*[@id=\"tinymce\"]");
        envIframeTextArea.shouldBe(Condition.visible, Duration.ofSeconds(10)).setValue(environmentDescription);
        switchTo().defaultContent();
        submitButton.shouldBe(Condition.visible, Duration.ofSeconds(10)).click();
        createdTaskLink.shouldBe(Condition.visible, Duration.ofSeconds(10));
    }
}
