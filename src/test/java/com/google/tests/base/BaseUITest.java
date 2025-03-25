package com.google.tests.base;

import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class BaseUITest {
    @BeforeEach
    public void setUp() {
        Selenide.open("/");
        getWebDriver().manage().window().maximize();
    }
}
