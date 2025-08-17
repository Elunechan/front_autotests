package ui.components

import com.codeborne.selenide.Selenide.`$$`
import com.codeborne.selenide.Condition.visible
import org.junit.jupiter.api.Assertions.assertTrue

class GridTable {

    /**
     * Проверяет, что в переданной колонке у каждой видимой строки значение
     * либо равно expected (выбранному в фильтре), либо равно anyText (по умолчанию "Любая").
     * Дополнительно убеждаемся, что есть хотя бы одна строка ровно с expected.
     *
     * @param columnCss   css-селектор ячейки нужной колонки внутри строки. Пример - div.tc-server.hidden-xxs
     * @param expected    выбранное в фильтре значение
     * @param anyText     текст варианта для доп. значения (по умолчанию "Любая")
     */

    fun checkTable(
        columnCss: String,
        expected: String,
        anyText: String = "Любая"
    ) {

        val rows = `$$`("a.tc-item").filter(visible)

        var hasSelected = false

        for (row in rows) {
            val cellText = row.find(columnCss).text()
            val ok = cellText.equals(expected) ||
                    cellText.equals(anyText)

            assertTrue(
                ok,
                "В колонке '$columnCss' получили '$cellText'. Ожидали '$expected' или '$anyText'."
            )

            if (cellText.equals(expected, ignoreCase = true)) {
                hasSelected = true
            }
        }

        assertTrue(
            hasSelected,
            "Нет ни одной строки именно с '$expected' (только '$anyText')."
        )
    }
}