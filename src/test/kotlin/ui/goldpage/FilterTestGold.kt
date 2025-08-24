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
import ui.lists.ListSide
import com.codeborne.selenide.CollectionCondition.size


@DisplayName ("Проверка фильтрации в разделе 'Золото'")
class FilterTestGold() : BaseTest() {

    @Test
    @DisplayName("Проверка фильтра 'Сервер' и сортировка таблицы по выбранному в фильтре значению")
    fun checkFilterServer() {
        open(Routes.WOW)
        gamePage.serverDropdown.click()
        selectFilter.searchForTextInFilter(dropdown = gamePage.serverDropdown, text = "Галакронд")
        gridTable.searchingValueInTable(columnName = gamePage.goldTableSelectorServer, searchingName = "Галакронд", anyText = "Любой")

    }

    @Test
    @DisplayName("Проверка значений в фильтре 'Сторона' и соответствия пунктов в выпадающем списке")
    fun checkFilterSides() {
        open(Routes.WOW)
        gamePage.sideDropdown.shouldBe(visible).click()
        val actual = selectFilter.valuesToList(gamePage.sideDropdown)
        assertEquals(ListSide.sides.sorted(), actual.sorted())
    }

    @Test
    @DisplayName("Проверка кнопки 'Продать игровую валюту' если пользователь не авторизован")
    fun checkButtonSellGold() {
        open(Routes.WOW)
        gamePage.saleButton.shouldBe(visible).click()
        webdriver().shouldHave(url(Routes.LOGIN_PAGE))
    }

    @Test
    @DisplayName("Проверка флага 'Только продавцы онлайн' и отображение в таблице")
    fun checkUserOnline() {
        open(Routes.WOW)
        gamePage.toBeOnlineRadioButton.click()
        gamePage.onlineAvatars.filter(visible).shouldHave(sizeGreaterThan(0))
        gamePage.offlineAvatars.filter(visible).shouldHave(size(0))
    }
}