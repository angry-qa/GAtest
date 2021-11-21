package Tests;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.logevents.SelenideLogger.addListener;
import static helpers.AttachmentHelper.*;
import static helpers.AttachmentHelper.attachAsText;
import static helpers.AttachmentHelper.attachPageSource;
import static helpers.AttachmentHelper.attachScreenshot;
import static helpers.AttachmentHelper.attachVideo;
import static helpers.AttachmentHelper.getConsoleLogs;

import com.codeborne.selenide.Configuration;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;


public class TestBase {

    @BeforeAll
    static void setup() {
        addListener("AllureSelenide", new AllureSelenide());
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", true);

        Configuration.browserCapabilities = capabilities;
        Configuration.browser = "chrome";
        Configuration.headless = true;

        // Configuration.browser = ownerConfig.getWebDriverBrowser();
        // Configuration.browserVersion = ownerConfig.getWebDriverBrowserVersion();
        Configuration.startMaximized = true;


//        if(ownerConfig.isRemote()) {
//        Configuration.remote = String.format("https://%s:%s@%s/wd/hub/",
//                credentialConfig.remoteWebUser(),
//                credentialConfig.remoteWebPassword(),
//                credentialConfig.getSelenoidURL());
//        }

        //open(LOGIN_PAGE_URL);
        //vkLoginPage.loginVK(credentialConfig.vkUserLogin(), credentialConfig.vkUserPassword());
    }

    @AfterAll
    static void afterAll() {
        closeWebDriver();
    }

    @AfterEach
    void afterEach() {
        attachScreenshot("Last screenshot");
        attachPageSource();
        attachAsText("Browser console logs", getConsoleLogs());
        if(System.getProperty("video.storage") != null)
            attachVideo();
    }
}