package com.google.utils.extension;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.google.utils.helpers.AllureAttachUtils;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.extension.AfterEachCallback;
import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

import static com.google.utils.config.ConfigProperties.*;

public class SelenideExtensions implements BeforeEachCallback, AfterEachCallback {
    @Override
    public void beforeEach(ExtensionContext context) {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide()
                .screenshots(true)
                .savePageSource(false)
        );
        Configuration.baseUrl = BASE_URL.getValue();
        Configuration.browser = BROWSER.getValue();
        Configuration.pageLoadStrategy = PAGE_LOAD_STRATEGY.getValue();
    }

    @Override
    public void afterEach(ExtensionContext context) {
        AllureAttachUtils.attachScreenshot();
        AllureAttachUtils.attachWebDriverLogs();
        Selenide.clearBrowserCookies();
        Selenide.clearBrowserLocalStorage();
        WebDriverRunner.clearBrowserCache();
    }
}
