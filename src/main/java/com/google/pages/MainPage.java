package com.google.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class MainPage {
    private final SelenideElement searchInput = $("div .gLFyf");
    private final SelenideElement buttonSettings = $(".ayzqOc.pHiOh");
    private final ElementsCollection settingsList = $$("#lb div g-menu-item");


    public static MainPage of() {
        return new MainPage();
    }

    @Step("Поиска в Google по запросу")
    public void search(String search) {
        searchInput.setValue(search).pressEnter();
    }

    @Step("Клик по кнопке Настройки ")
    public void clickSettings() {
        buttonSettings.click();
    }

    @Step("Проверка видимости кнопки Настройки")
    public void checkSettings() {
        buttonSettings.shouldBe(visible);
    }

    @Step("Проверка выпадающего списка Настройки")
    public void checkSettingsList() {
        settingsList.stream()
                .forEach(setting -> setting.shouldBe(visible));
    }
}
