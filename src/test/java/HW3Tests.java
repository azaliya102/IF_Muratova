import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.*;
import pages.*;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static org.junit.jupiter.api.Assertions.assertEquals;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class HW3Tests {
    private final String login = "AT3";
    private final String password = "Qwerty123";
    private final AuthPage authPage = new AuthPage();
    private final TestPage testPage = new TestPage();
    private final JiraTask jiraTask = new JiraTask();
    private final CreateTask createJiraTask = new CreateTask();

    @BeforeEach
    public void openBrowser() {
        Selenide.open("https://edujira.ifellow.ru");
        getWebDriver().manage().window().maximize();
    }

    @AfterEach
    public void closeBrowser() {
        Selenide.closeWebDriver();
    }

    @DisplayName("Authorization check")
    @Test
    @Order(1)
    public void loginTest() {
        authPage.login(login, password);
        Assertions.assertTrue(ChecksTask.isUserProfileDisplayed());
    }

    @DisplayName("Tasks Check")
    @Test
    @Order(2)
    public void projectPageTest() {
        authPage.login(login, password);
        testPage.openProject();
        SelenideElement tasksTitle = $x("//*[@id='issues-subnavigation-title']");
        tasksTitle.shouldBe(Condition.visible);
        assertEquals("Открытые задачи", tasksTitle.getText(), "не тот проект");
    }


    @DisplayName("Check total task count")
    @Test
    @Order(3)
    public void taskCountTest() {
        authPage.login(login, password);
        testPage.openProject();
        int startNumberTask = testPage.countTask();
        createJiraTask.createTask("Тестовый проект", "Баг", "Тестовая задача");
        Selenide.refresh();
        int endNumberTask = testPage.countTask();
        assertEquals(startNumberTask + 1, endNumberTask, "количество должно увеличиться на 1");
        testPage.printProgressBar(50, endNumberTask % 50);
    }

    @DisplayName("Check fields by task TestSeleniumATHomework")
    @Test
    @Order(4)
    public void taskTestSelenium() {
        authPage.login(login, password);
        testPage.openTask("TestSeleniumATHomework");
        assertEquals("СДЕЛАТЬ", jiraTask.getStatus(), "статус задачи неверный");
        assertEquals("Version 2.0", jiraTask.getVersion(), "версия задачи неверная");
    }

    @DisplayName("Create new bug")
    @Test
    @Order(5)
    public void CreateJiraTask() {
        authPage.login(login, password);
        testPage.openProject();
        int startNumTask = testPage.countTask();
        createJiraTask.createTask("Твой проект", "Bug", "Что-то не так");
        Selenide.refresh();
        int endNumTask = testPage.countTask();
        assertEquals(startNumTask + 1, endNumTask, "количество должно увеличиться на 1");
    }
}
