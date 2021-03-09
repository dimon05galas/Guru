package Tests;

import com.codeborne.selenide.*;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class SelenideGitHubWiki {

    @Test

    void SelenideGitHubWikiTest() {
        //Открыть GitHub
        open("https://github.com");
        //Перейти на страницу Selenide
        $("[name=q]").setValue("Selenide/Selenide").pressEnter();
        $$("ul.repo-list li").first().$("a").click();
        //Убедиться что мы на нужной странице
        $("h1").shouldHave(Condition.text("selenide / selenide"));
        //Перейти на Wiki страницу
        $(byText("Wiki")).click();
        //Убедится, что в списке страниц есть страница SoftAssertions
        $("#wiki-pages-box").shouldHave(Condition.text("SoftAssertions"));
        //Открыть страницу SoftAssertions
        $(byText("SoftAssertions")).click();
        // проверить что внутри есть пример кода для JUnit5
        $("#wiki-body").shouldHave(Condition.text("Using JUnit5 extend test class:"));





    }
}
