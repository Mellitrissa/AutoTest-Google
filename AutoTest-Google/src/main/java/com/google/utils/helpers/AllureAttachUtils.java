package com.google.utils.helpers;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.logging.LogType;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class AllureAttachUtils {
    public static void attachScreenshot() {
        byte[] screenshot = Selenide.screenshot(OutputType.BYTES);
        if (screenshot != null) {
            try (InputStream is = new ByteArrayInputStream(screenshot)) {
                Allure.attachment("image.png", is);
            } catch (IOException ignored) {
            }
        }
    }

    public static void attachWebDriverLogs() {
        List<String> logs = Selenide.getWebDriverLogs(LogType.BROWSER);
        Allure.addAttachment("Console logs: ", logs.toString());
    }
}
