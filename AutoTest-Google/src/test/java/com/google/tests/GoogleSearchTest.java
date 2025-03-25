package com.google.tests;

import com.google.pages.MainPage;
import com.google.pages.PicturesPage;
import com.google.pages.SearchResultPage;
import com.google.pages.SecondResultPage;
import com.google.tests.base.BaseUITest;
import com.google.utils.extension.SelenideExtensions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(SelenideExtensions.class)
public class GoogleSearchTest extends BaseUITest {
    @Test
    @DisplayName("Проверка поиска в Google")
    public void testGoogleSearch() {
        MainPage.of().search("Selenide Java");
        SearchResultPage.of().checkPageVisibility();
        SearchResultPage.of().checkTenResultTitle("Selenide");
    }

    @Test
    @DisplayName("Проверка пагинации")
    public void testPagination() {
        MainPage.of().search("Selenide Java");
        SearchResultPage.of().clickSecondPage();
        SecondResultPage.of().checkNumberPage("2");
        SecondResultPage.of().checkResult();
    }

    @Test
    @DisplayName("Проверка изображений на странице поиска")
    public void testPictures() {
        MainPage.of().search("Selenide Java");
        SearchResultPage.of().clickPicturesPage();
        PicturesPage.of().checkPicture();
        PicturesPage.of().checkZoomPicture();
    }

    @Test
    @DisplayName("Проверка отображения других элементов на странице")
    public void testDisplayOtherElements() {
        MainPage.of().checkSettings();
        MainPage.of().clickSettings();
        MainPage.of().checkSettingsList();
        MainPage.of().search("Selenide Java");
        SearchResultPage.of().checkSearchInput();
        SearchResultPage.of().checkButtonInput();
        SearchResultPage.of().checkNavigationPage();
    }
}
