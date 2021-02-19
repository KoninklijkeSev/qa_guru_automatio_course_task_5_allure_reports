package tests;

import io.qameta.allure.Link;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class IssueTestLambdaWithStep {

    private static final String URL = "https://github.com";
    private static final String REPOSITORY = "eroshenkoam/allure-example";
    private static final String ISSUES = "Issues";
    private static final String NUMBER = "#68";

    @Test
    @Link(URL)
    @DisplayName("Поиск Issue по номеру в репозитории")
    void testIssueSearch() {
        step("Открываем главную страницу", () -> {
            open(URL);
        });

        step("Ищем репозиторий" + REPOSITORY, () -> {
            $("[name = q]").setValue(REPOSITORY).pressEnter();
        });

        step("Кликаем на репозиторий" + REPOSITORY, () -> {
            $(byLinkText(REPOSITORY)).click();
        });

        step("Переходим в раздел" + ISSUES, () -> {
            $(byText(ISSUES)).click();
        });

        step("Проверяем наличие " + ISSUES + "с номером " + NUMBER, () -> {
            $(withText(NUMBER)).shouldBe(visible);
        });
    }
}
