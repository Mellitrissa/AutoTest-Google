package com.google.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class SecondResultPage {
    private final SelenideElement currentPage = $(".YyVfkd");
    private final SelenideElement rootElement = $("#search");
    private final ElementsCollection results = rootElement.$$("a h3");

    public static SecondResultPage of() {
        return new SecondResultPage();
    }

    @Step("Проверка номера страницы")
    public void checkNumberPage(String str) {
        currentPage.shouldHave(text(str));
    }

    @Step("Проверка видимости результатов поиска")
    public void checkResult() {
        results.stream()
                .forEach(result -> result.shouldBe(visible));
    }
}
