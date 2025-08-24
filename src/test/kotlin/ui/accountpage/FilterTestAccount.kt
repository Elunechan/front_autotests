package ui.ui.accountpage

import com.codeborne.selenide.CollectionCondition.size
import com.codeborne.selenide.CollectionCondition.sizeGreaterThan
import com.codeborne.selenide.Condition.visible
import com.codeborne.selenide.Selenide.open
import com.codeborne.selenide.Selenide.webdriver
import com.codeborne.selenide.WebDriverConditions.url
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import ui.BaseTest
import ui.config.Routes
import ui.lists.ListClass
import ui.lists.ListRace
import ui.lists.ListSide

@DisplayName("Проверка фильтрации в разделе 'Аккаунты'")
class FilterTestAccount() : BaseTest() {

    @Test
    @DisplayName("Проверка фильтра 'Сервер' и сортировка таблицы по выбранному в фильтре значению")
    fun checkFilterServer() {
        open(Routes.ACCOUNT)
        gamePage.serverDropdown.click()
        selectFilter.searchForTextInFilter(dropdown = gamePage.serverDropdown, text = "Галакронд")
        gridTable.searchingValueInTable(
            columnName = gamePage.accountTableSelectorServer,
            searchingName = "Галакронд",
            anyText = "Любой"
        )

    }

    @Test
    @DisplayName("Проверка фильтра 'Сторона' и соответствие пунктов в выпадающем списке")
    fun checkFilterSides() {
        open(Routes.ACCOUNT)
        gamePage.sideDropdown.shouldBe(visible).click()
        val actual = selectFilter.valuesToList(gamePage.sideDropdown)
        assertEquals(ListSide.sides.sorted(), actual.sorted())
    }

    @Test
    @DisplayName("Проверка значений в фильтре 'Класс' на соответствие с ожидаемым списком")
    fun checkFilterClasses() {
        open(Routes.ACCOUNT)
        gamePage.classesDropdown.shouldBe(visible).click()
        val actual = selectFilter.valuesToList(gamePage.classesDropdown)
        assertEquals(ListClass.classes.sorted(), actual.sorted())
    }

    @Test
    @DisplayName("Проверка значений в фильтре 'Расы' на соответствие с ожидаемым списком")
    fun checkFilterRace() {
        open(Routes.ACCOUNT)
        gamePage.raceDropdown.shouldBe(visible).click()
        val actualRace = selectFilter.valuesToList(gamePage.raceDropdown)
        assertEquals(ListRace.races.sorted(), actualRace.sorted())
    }

    @Test
    @DisplayName("Проверка кнопки 'Продать аккаунт' без авторизации")
    fun checkClickSellButton() {
        open(Routes.ACCOUNT)
        gamePage.sellAccountButton.shouldBe(visible).click()
        webdriver().shouldHave(url(Routes.LOGIN_PAGE))
    }

    @Test
    @DisplayName("Проверка флага 'Только продавцы онлайн' и отображение в таблице")
    fun checkUserOnline() {
        open(Routes.ACCOUNT)
        gamePage.toBeOnlineRadioButton.click()
        gamePage.onlineAvatars.filter(visible).shouldHave(sizeGreaterThan(0))
        gamePage.offlineAvatars.filter(visible).shouldHave(size(0))
    }


    @ParameterizedTest()
    @DisplayName(
        "Параметризированный тест на ввод символов в поле 'Поиск по описанию'. " +
                "Проверка ввода букв, цифр, а так же значения которого нет в списке лотов, чтобы проверить отображающийся блок с текстом"
    )
    @CsvSource(
        "within,false",
        "30,false",
        "-_'/.@#\\$!'\",false",
        "гараж,true"
    )
    fun checkFieldSearchByDescription(query: String, expectNoLots: Boolean) {
        open(Routes.ACCOUNT)

        gamePage.searchField(gamePage.textFieldFind.shouldBe(visible), query)
        assertEquals(query, gamePage.textFieldFind.getValue())

        if (expectNoLots) {
            gamePage.lotsNotVisible(gamePage.noOffersText)
        } else {
            gamePage.lotsBeVisible(gamePage.noOffersText)
        }
    }
}