package com.demoqa.webform.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.demoqa.webform.config.CredentialsConfig;
import com.demoqa.webform.helper.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.remote.DesiredCapabilities;

import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.closeWebDriver;

public class TestBase {
    @BeforeEach
     void setUp() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        CredentialsConfig config = ConfigFactory.create(CredentialsConfig.class);

        String login = config.login();
        String password = config.password();
        String browser = System.getProperty("browser", "Chrome");
        String version = System.getProperty("version", "100");
        String baseUrl = System.getProperty("url", "https://demoqa.com");
        String browserSize = System.getProperty("browserSize", "1920x1080");
        String selenoid = System.getProperty("selenoid","selenoid.autotests.cloud/wd/hub");


        Configuration.baseUrl = baseUrl;
        Configuration.browserSize = browserSize;
        Configuration.browserVersion = version;
        Configuration.remote = "https://" + config.login() + ":" + config.password() + "@" + selenoid;
        //Configuration.remote = "https://user1:1234@selenoid.autotests.cloud/wd/hub";


        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", true);
        Configuration.browserCapabilities = capabilities;
    }

    @AfterEach
    void addAttachments () {
        Attach.screenshotAs("Test screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
        closeWebDriver();
    }


}
