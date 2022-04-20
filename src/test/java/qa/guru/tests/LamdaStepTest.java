package qa.guru.tests;

import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Allure;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.nio.charset.StandardCharsets;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;
import static org.openqa.selenium.By.partialLinkText;

public class LamdaStepTest {


        private static final String REPOSITORY = "Forik1232/Homework5";
        private static final int ISSUE_NUMBER = 4;

        @Test
        public void testGithubIssue() {
                SelenideLogger.addListener("allure", new AllureSelenide());
                step("Открываем главную страницу", () -> {
                        open("https://github.com");
                });
                step("Ищем реопзиторий " + REPOSITORY, () -> {
                        $(".header-search-input").click();
                        $(".header-search-input").sendKeys(REPOSITORY);
                        $(".header-search-input").submit();
                });
                step("Переходим по ссылке репозитория " + REPOSITORY, () -> {
                        $(linkText(REPOSITORY)).click();
                });
                step("Кликаем на таб Issues", () -> {
                        $(partialLinkText("Issues")).click();
                });
                step("Проверяем что существует Issue с номером " + ISSUE_NUMBER, () -> {
                        $(withText("#4")).click();
                        Allure.getLifecycle().addAttachment(
                                "Исходники страницы",
                                "text/html",
                                "html",
                                WebDriverRunner.getWebDriver().getPageSource().getBytes(StandardCharsets.UTF_8)
                        );
                });
        }

}