import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.remote.DesiredCapabilities;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SearchTests {

  @BeforeAll
    static void setup() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("enableVNC", true);
        Configuration.browserCapabilities = capabilities;
        Configuration.browser = "chrome";
        Configuration.headless = true;
  }

    @Test
    void selenideSearchTest() {
        open("https://www.google.com/");
        $(byName("q")).setValue("Selenide").pressEnter();
        $("#search").shouldHave(text("selenide.org"));
    }
}
