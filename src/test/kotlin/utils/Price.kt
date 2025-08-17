package ui.utils

import com.codeborne.selenide.CollectionCondition.sizeGreaterThan
import com.codeborne.selenide.Condition.visible
import com.codeborne.selenide.Selenide.`$$`

/** Функция принимает значение в формате строки, убирает все лишнее и возвращает Double
 */
class Price {
    fun priceFromText(): Double {
        val rows = `$$`("a.tc-item").filter(visible).shouldHave(sizeGreaterThan(0))
        val text = rows.first().find(".tc-price").text().trim()

        // Убираем лишнее
        val cleaned = text.replace(Regex("[^0-9,\\.]"), "")
            .replace(",", ".")

        return cleaned.toDouble()
    }
}
