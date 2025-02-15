package PagesTest;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.*;
import pages.*;
import webHooks.WebHooks;
import static com.codeborne.selenide.Selenide.$x;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HW3Tests extends WebHooks {
    private final String login = getProperty("login");
    private final String password = getProperty("password");
    private final AuthenticationPage authPage = new AuthenticationPage();
    private final TestPage testPage = new TestPage();
    private final JiraTask jiraTask = new JiraTask();
    private final CreateTask createJiraTask = new CreateTask();

    @DisplayName("Authorization check")
    @Test
    public void loginTest() {
        authPage.login(login, password);
        Assertions.assertTrue(ChecksTask.isUserProfileDisplayed());
    }

    @DisplayName("Tasks Check")
    @Test
    public void projectPageTest() {
        authPage.login(login, password);
        testPage.openProject();
        SelenideElement tasksTitle = $x("//*[@id='issues-subnavigation-title']");
        tasksTitle.shouldBe(Condition.visible);
        assertEquals("Открытые задачи", tasksTitle.getText(), "не тот проект");
    }

    @DisplayName("Check total task count")
    @Test
    public void taskCountTest() {
        authPage.login(login, password);
        testPage.openProject();
        int startNumberTask = testPage.countTask();
        createJiraTask.createTask("Тестовый проект", "Баг", "Окружение");
        Selenide.refresh();
        int endNumberTask = testPage.countTask();
        Assertions.assertEquals(startNumberTask + 1, endNumberTask, "количество должно увеличиться на 1");
    }

    @DisplayName("Check fields by task TestSeleniumATHomework")
    @Test
    public void taskTestSelenium() {
        authPage.login(login, password);
        testPage.openTask("TestSeleniumATHomework");
        assertEquals("СДЕЛАТЬ", jiraTask.getStatus(), "статус задачи неверный");
        assertEquals("Version 2.0", jiraTask.getVersion(), "версия задачи неверная");
    }

    @DisplayName("Create new bug")
    @Test
    public void CreateJiraTask() {
        authPage.login(login, password);
        testPage.openProject();
        int startNumTask = testPage.countTask();
        createJiraTask.createTask("Тестовый проект", "Bug", "Окружение");
        Selenide.refresh();
        int endNumTask = testPage.countTask();
        assertEquals(startNumTask + 1, endNumTask, "количество должно увеличиться на 1");
    }
}
