package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import java.time.Duration;

import static com.codeborne.selenide.Selenide.$x;

public class CreateTask {
    private final SelenideElement createButton = $x("//*[@id='create_link']");
    private final SelenideElement projectField = $x("//*[@id='project-field']");
    private final SelenideElement issueType = $x("//*[@id='issuetype-field']");
    private final SelenideElement summaryField = $x("//*[@id='summary']");
    private final SelenideElement submitButton = $x("//*[@id='create-issue-submit']");
    private final SelenideElement createdTaskLink = $x("//a[@class='issue-created-key issue-link']");

    public void createTask(String projectName, String issueTypeName, String summary) {
        createButton.shouldBe(Condition.visible, Duration.ofSeconds(10)).click();

        projectField.shouldBe(Condition.visible, Duration.ofSeconds(10)).setValue(projectName).pressEnter();
        issueType.shouldBe(Condition.visible, Duration.ofSeconds(10)).setValue(issueTypeName).pressEnter();
        summaryField.shouldBe(Condition.visible, Duration.ofSeconds(10)).setValue(summary);

        submitButton.shouldBe(Condition.visible, Duration.ofSeconds(10)).click();
        createdTaskLink.shouldBe(Condition.visible, Duration.ofSeconds(10));
    }
}
