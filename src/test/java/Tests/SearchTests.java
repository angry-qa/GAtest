package Tests;

import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byClassName;
import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.open;

public class SearchTests extends TestBase {

    @Test
    void selenideSearchTest() {
        open("https://www.google.com/");
        $(byName("q")).setValue("Selenide").pressEnter();
        $("#search").shouldHave(text("selenide.org"));
        System.out.println($$(byClassName("logo")).size());
    }
    @Test

    void selenideSearchTest2() {
        open("https://www.google.com/");
        $(byName("q")).setValue("Selenide").pressEnter();
        $("#search").shouldHave(text("selenide.org"));
        System.out.println($$(byClassName("logo")).size());
    }

    void selenideSearchTest3() {
        open("https://www.google.com/");
        $(byName("q")).setValue("Selenide").pressEnter();
        $("#search").shouldHave(text("selenide1.org"));
        System.out.println($$(byClassName("logo")).size());
    }
}
