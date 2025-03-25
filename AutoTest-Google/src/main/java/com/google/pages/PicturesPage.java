package com.google.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class PicturesPage {
    private final ElementsCollection pictures = $$(".GMCzAd");
    private final SelenideElement searchPictures = $("#search");
    private final SelenideElement zoomPicture = $("#Sva75c .iPVvYb");

    public static PicturesPage of() {
        return new PicturesPage();
    }

    @Step("Проверка видимости картинок на странице")
    public void checkPicture() {
        searchPictures.shouldBe(visible);
    }

    @Step("Проверка увеличения картинки при нажатии на нее")
    public void checkZoomPicture() {
        SelenideElement firstPicture = pictures.first();
        int originalWidth = firstPicture.$("img").getSize().getWidth();
        int originalHeight = firstPicture.$("img").getSize().getHeight();
        firstPicture.click();
        zoomPicture.shouldBe(visible);
        int enlargedWidth = zoomPicture.getSize().getWidth();
        int enlargedHeight = zoomPicture.getSize().getHeight();
        Assertions.assertTrue(enlargedWidth > originalWidth);
        Assertions.assertTrue(enlargedHeight > originalHeight);
    }

}
