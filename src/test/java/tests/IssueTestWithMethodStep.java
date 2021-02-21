package tests;

import org.junit.jupiter.api.Test;
import steps.BaseSteps;


public class IssueTestWithMethodStep extends BaseSteps {

    private static final String URL = "https://github.com";
    private static final String REPOSITORY = "eroshenkoam/allure-example";
    private static final String ISSUES = "Issues";
    private static final String NUMBER = "#68";

    BaseSteps steps = new BaseSteps();

    @Test
    void testIssueSearch() {
        steps.openMainPage(URL);
        steps.searchForRepository(REPOSITORY);
        steps.openRepositoryIssues(REPOSITORY);
        steps.goToRepositoryIssues(ISSUES);
        steps.seeIssue(NUMBER);
    }
}
