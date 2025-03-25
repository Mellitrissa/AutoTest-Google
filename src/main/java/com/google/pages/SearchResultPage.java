package com.google.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class SearchResultPage {
    private final SelenideElement rootElement = $("#search");
    private final ElementsCollection resultHeaders = rootElement.$$("a h3");
    private final SelenideElement linkSecondPage = $x("//td[@class = 'NKTSme']/a[contains(text(),'2')]");
    private final SelenideElement linkPicturesPage = $x("//div[contains(text(),'Картинки')]");
    private final SelenideElement searchInput = $("#tsf");
    private final SelenideElement buttonInput = $(".HZVG1b.Tg7LZd");
    private final SelenideElement navigationPage = $("div[ role = navigation] .AaVjTc");

    public static SearchResultPage of() {
        return new SearchResultPage();
    }

    @Step("Проверка видимости страницы с результатами поиска")
    public void checkPageVisibility() {
        rootElement.shouldBe(visible);
    }

    @Step("Проверка, что заголовки первых 10 результатов содержат слово \"Selenide\".")
    public void checkTenResultTitle(String str) {
        resultHeaders.stream()
                .limit(10)
                .forEach(result -> result.shouldHave(text(str)));
    }

    @Step("Переход на вторую страницу поиска")
    public void clickSecondPage() {
        linkSecondPage.click();
    }

    @Step("Переход на страницу с картинками")
    public void clickPicturesPage() {
        linkPicturesPage.click();
    }

    @Step("Проверка отображения поля ввода запроса")
    public void checkSearchInput() {
        searchInput.shouldBe(visible);
    }

    @Step("Проверка отображения кнопки ввода запроса")
    public void checkButtonInput() {
        buttonInput.shouldBe(clickable);
    }

    @Step("Проверка отображения внизу страницы элементов навигации по страницам")
    public void checkNavigationPage() {
        navigationPage.shouldBe(visible);
    }
}
