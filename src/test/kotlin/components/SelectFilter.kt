package ui.components

import com.codeborne.selenide.Condition.visible
import com.codeborne.selenide.Selenide.`$`

class SelectFilter {

    /** Функция для поиска элемента в фильтре по названию
     */
    fun searchForTextInFilter(text: String, filterName: String) {
        `$`("select.form-control.showcase-filter-input[name='$filterName']").selectOption(text)
    }

    /** Функция для получения значений из фильтра в формате списка
     */
    fun getList(filterName: String): List<String> {
        val select = `$`("select.form-control.showcase-filter-input[name='$filterName']").shouldBe(visible)
        return select.`$$`("option").texts()
    }
}
