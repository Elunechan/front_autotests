package ui.ui.gamepage

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import ui.BaseTest
import ui.config.Routes
import com.codeborne.selenide.Selenide.*
import org.junit.jupiter.api.Assertions.assertTrue

class SortTableGold() : BaseTest() {

    @Test
    @DisplayName ("Сортируем таблицу по цене")
    fun sortForPrice() {
        open(Routes.WOW)
        val lowPrice = price.priceFromText()
        gamePage.sortByPrice.click()
        val bigPrice = price.priceFromText()
        assertTrue(lowPrice < bigPrice, "Ожидалось, что первая цена будет меньше второй")
    }
}