package tests;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class IssueTest {

    private static final String URL = "https://github.com";
    private static final String REPOSITORY = "eroshenkoam/allure-example";
    private static final String ISSUES = "Issues";
    private static final String NUMBER = "#68";

    @Test
    void testIssueSearch() {
        open(URL);
        $("[name = q]").setValue(REPOSITORY).pressEnter();
        $(byLinkText(REPOSITORY)).click();
        $(byText(ISSUES)).click();
        $(withText(NUMBER)).shouldBe(visible);
    }
}
