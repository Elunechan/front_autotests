package ui.components

import com.codeborne.selenide.Condition.visible
import com.codeborne.selenide.SelenideElement
import pages.GamePage

class SelectFilter : GamePage() {

    /** Функция для поиска элемента в фильтре по названию
     */
    fun searchForTextInFilter(dropdown: SelenideElement, text: String) {
        dropdown.shouldBe(visible).selectOption(text)
    }

    /** Функция для получения значений из фильтра в формате списка
     */
    fun valuesToList(dropdown: SelenideElement): List<String> {
        val select = dropdown.shouldBe(visible)
        return select.`$$`("option").texts()
    }
}
