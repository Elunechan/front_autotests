package ui.ui.gamepage

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import ui.BaseTest
import ui.config.Routes
import com.codeborne.selenide.Selenide.*
import org.junit.jupiter.api.Assertions.assertTrue


@DisplayName ("Сортировка таблицы по кликам на столбцы в разделе 'Золото'")
class SortTableGold() : BaseTest() {

    @Test
    @DisplayName("Сортировка таблицы по убыванию цены")
    fun sortForPrice() {
        open(Routes.WOW)
        val lowPrice = converter.stringToInt()
        gamePage.sortByPrice.click()
        val bigPrice = converter.stringToInt()
        assertTrue(lowPrice < bigPrice, "Ожидалось, что первая цена будет меньше второй")
    }
}