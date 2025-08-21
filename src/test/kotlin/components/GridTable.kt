package ui.components

import com.codeborne.selenide.Condition.visible
import org.junit.jupiter.api.Assertions.assertTrue
import ui.BaseTest

class GridTable : BaseTest() {

    /**
     * Проверяет, что в переданном столбце у каждой строки значение
     * либо равно expected (т.е в выбранному в фильтре), либо равно anyText (по умолчанию "Любой").
     * Дополнительно проверяем, что есть хотя бы одна строка ровно с expected.
     *
     * @param columnCss   css-селектор ячейки нужной колонки внутри строки. Пример - div.tc-server.hidden-xxs
     * @param expected    выбранное в фильтре значение
     * @param anyText     текст варианта для доп. значения (по умолчанию "Любой")
     */

    fun searchingValueInTable(
        columnCss: String,
        expected: String,
        anyText: String = "Любой"
    ) {

        val rows = gamePage.lotCell.filter(visible)

        var hasSelected = false

        for (row in rows) {
            val cellText = row.find(columnCss).text()
            val isValidCell = cellText == expected ||
                    cellText == anyText

            assertTrue(
                isValidCell,
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