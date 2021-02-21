package steps;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class BaseSteps {

    @Step("Открываем главную страницу {url}")
    public void openMainPage(String url) { open(url); }

    @Step("Ищем репозиторий {repository}")
    public void searchForRepository(String repository) {
        $("[name = q]").setValue(repository).pressEnter();
    }

    @Step("Кликаем на репозиторий {repository}")
    public void openRepositoryIssues(String repository) {
        $(byLinkText(repository)).click();
    }

    @Step("Переходим в раздел {issues}")
    public void goToRepositoryIssues(String issues) {
        $(byText(issues)).click();
    }

    @Step("Проверяем наличие в раздел Issues с номером {number}")
    public void seeIssue(String number) {
        $(withText(number)).shouldBe(visible);
    }
}