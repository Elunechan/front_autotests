package ui.ui.lotpage

import com.codeborne.selenide.Condition.visible
import com.codeborne.selenide.Selenide.open
import com.codeborne.selenide.Selenide.webdriver
import com.codeborne.selenide.WebDriverConditions.url
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import ui.BaseTest
import ui.config.Routes


@DisplayName("Проверка отображения основных элементов на странице с лотами")
class ElementsIsVisible() : BaseTest() {

    @Test
    @DisplayName("Проверка наличия хедера на странице с лотами")
    fun lotHeaderIsVisible() {
        open(Routes.LOT_PAGE)
        lotPage.headerLotPage.shouldBe(visible)
    }

    @Test
    @DisplayName("Проверка наличия футера на странице с лотами")
    fun lotFooterIsVisible() {
        open(Routes.LOT_PAGE)
        lotPage.footerLotPage.shouldBe(visible)
    }

    @Test
    @DisplayName("Проверка отображения блока с чатом")
    fun chatIsVisible() {
        open(Routes.LOT_PAGE)
        lotPage.chat.shouldBe(visible)
    }

    @Test
    @DisplayName("Проверка клика на хлебные крошки")
    fun clickInBackToGamesList() {
        open(Routes.LOT_PAGE)
        lotPage.backToList.click()
        webdriver().shouldHave(url(Routes.WOW))
    }

    @Test
    @DisplayName("Проверка  кнопки 'Купить' без авторизации")
    fun clickInBuyButtonWithotAuth() {
        open(Routes.LOT_PAGE)
        lotPage.buyButton.click()
        webdriver().shouldHave(url(Routes.REGISTER))
    }
}