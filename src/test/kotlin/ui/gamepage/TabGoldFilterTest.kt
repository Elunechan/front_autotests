package ui.ui.gamepage

import com.codeborne.selenide.CollectionCondition.sizeGreaterThan
import com.codeborne.selenide.Condition.visible
import com.codeborne.selenide.Selenide.*
import com.codeborne.selenide.WebDriverConditions.url
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import ui.BaseTest
import ui.config.Routes
import ui.lists.ListGold
import com.codeborne.selenide.CollectionCondition.size



class TabGoldFilterTest() : BaseTest() {

    @Test
    @DisplayName("Проверка фильтра 'Сервер'")
    fun checkFilterServer() {
        open(Routes.WOW)
        gamePage.serverDropdown.click()
        selectFilter.searchForTextInFilter(text = "Галакронд", filterName = "server")
        gridTable.checkTable(columnCss = ".tc-server.hidden-xxs", expected = "Галакронд", anyText = "Любой")

    }

    @Test
    @DisplayName("Проверка значений в фильтре 'Сторона'")
    fun checkFilterSides() {
        open(Routes.WOW)
        gamePage.sideDropdown.shouldBe(visible).click()
        val actual = selectFilter.getList("side")
        assertEquals(ListGold.sides.sorted(), actual.sorted())
    }

    @Test
    @DisplayName("Проверка кнопки 'Продать игровую валюту' если пользователь не авторизован")
    fun cherButtonSellGold() {
        open(Routes.WOW)
        gamePage.saleButton.shouldBe(visible).click()
        webdriver().shouldHave(url(Routes.LOGIN_PAGE))
    }

    @Test
    @DisplayName("Проверка флага 'Только продавцы онлайн'")
    fun checkUserOnline() {
        open(Routes.WOW)
        gamePage.toBeOnlineRadioButton.click()
        gamePage.onlineAvatars.filter(visible).shouldHave(sizeGreaterThan(0))
        gamePage.offlineAvatars.filter(visible).shouldHave(size(0))
    }
}




