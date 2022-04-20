package qa.guru.tests;


import com.codeborne.selenide.logevents.SelenideLogger;

import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

public class AnnotatedStepTest {

        private static final String REPOSITORY = "Forik1232/Homework5";
        private static final int ISSUE_NUMBER = 4;

        @Test
        public void testGithubIssue() {
                SelenideLogger.addListener("allure", new AllureSelenide());
                WebSteps steps = new WebSteps();

                steps.openMainPage();
                steps.searchForRepository(REPOSITORY);
                steps.clickOnRepositoryLink(REPOSITORY);
                steps.openIssuesTab();
                steps.shouldSeeIssueWithNumber(ISSUE_NUMBER);
        }

}


