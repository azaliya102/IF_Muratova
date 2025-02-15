package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import java.time.Duration;

import static com.codeborne.selenide.Selenide.$x;

public class TestPage {
    private final SelenideElement projButton = $x("//a[@id='browse_link']")
            .as("Кнопка \"Проекты\"");
    private final SelenideElement icoTest = $x("//a[@id='admin_main_proj_link_lnk']")
            .as("Кнопка \"Тест(Test)\"");
    private final SelenideElement searchInput = $x("//input[@id='quickSearchInput']")
            .as("Поиск");
    private final SelenideElement tasksCount = $x("//div[@class='showing']/child::span")
            .as("Количество задач");
    private final SelenideElement taskTitle = $x("//h1[@id='summary-val']")
            .as("Заголовок задачи");

    public void openProject() {
        projButton.click();
        icoTest.click();
    }

    public int countTask() {
        String countTaskText = tasksCount.shouldBe(Condition.visible, Duration.ofSeconds(10)).getText();
        return Integer.parseInt(countTaskText.split(" ")[2]);
    }

    public void openTask(String taskName) {
        searchInput.setValue(taskName).pressEnter();
        taskTitle.shouldBe(Condition.visible, Duration.ofSeconds(10));
    }
}
