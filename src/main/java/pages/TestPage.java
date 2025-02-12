package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import java.time.Duration;

import static com.codeborne.selenide.Selenide.$x;

public class TestPage {
    private final SelenideElement projButton = $x("//a[@id='browse_link']");
    private final SelenideElement icoTest = $x("//a[@id='admin_main_proj_link_lnk']");
    private final SelenideElement searchInput = $x("//input[@id='quickSearchInput']");
    private final SelenideElement tasksCount = $x("//div[@class='showing']/child::span");
    private final SelenideElement taskTitle = $x("//h1[@id='summary-val']");

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

    public void printProgressBar(int total, int current) {
        int progressSize = 20;
        int filledHearts = (int) ((double) current / total * progressSize);

        StringBuilder progressBar = new StringBuilder("Прогресс: ");
        progressBar.append("❤️".repeat(filledHearts));
        progressBar.append("🤍".repeat(progressSize - filledHearts));

        System.out.println(progressBar);
    }
}
