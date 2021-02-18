package tests;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class IssueTest {

    private static final String REPOSITORY = "eroshenkoam/allure-example";
    private static final String ISSUES = "Issues";
    private static final String NUMBER = "#68";

    @Test
    void testIssueSearch() {
        open("https://github.com");
        $("[name = q]").setValue(REPOSITORY).pressEnter();
        $(byLinkText(REPOSITORY)).click();
        $(byText(ISSUES)).click();
        $(withText(ISSUES)).shouldBe(visible);
    }
}
