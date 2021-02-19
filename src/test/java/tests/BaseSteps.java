package tests;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class BaseSteps {

    private static final String URL = "https://github.com";
    private static final String REPOSITORY = "eroshenkoam/allure-example";
    private static final String ISSUES = "Issues";
    private static final String NUMBER = "#68";

    @Step("Открываем главную страницу" + URL)
    public void openMainPage(String url) {
        open(url);
    }

    @Step("Ищем репозиторий" + REPOSITORY)
    public void searchForRepository(String repository) {
        $("[name = q]").setValue(repository).pressEnter();
    }

    @Step("Кликаем на репозиторий" + REPOSITORY)
    public void openRepositoryIssues(String repository) {
        $(byLinkText(repository)).click();
    }

    @Step("Переходим в раздел" + ISSUES)
    public void goToRepositoryIssues(String issues) {
        $(byText(issues)).click();
    }


    @Step("Проверяем наличие " + ISSUES + "с номером " + NUMBER)
    public void seeIssue(String number) {
        $(withText(number)).shouldBe(visible);
    }
}