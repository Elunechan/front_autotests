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
     * @param columnName   css-селектор ячейки нужной колонки внутри строки. Пример - div.tc-server.hidden-xxs
     * @param searchingName    выбранное в фильтре значение
     * @param anyText     текст варианта для доп. значения (по умолчанию "Любой")
     */

    fun searchingValueInTable(
        columnName: String,
        searchingName: String,
        anyText: String = "Любой"
    ) {

        val rows = gamePage.lotCell.filter(visible)

        var hasSelected = false // так как может оказаться, что лотов с таким фильтром нет

        for (row in rows) {
            val cellText = row.find(columnName).text()
            val isValidCell = cellText == searchingName ||
                    cellText == anyText

            assertTrue(
                isValidCell,
                "В колонке '$columnName' получен '$cellText'. Ожидалось '$searchingName' или '$anyText'."
            )

            if (cellText.equals(searchingName, ignoreCase = true)) {
                hasSelected = true
            }
        }

        assertTrue(
            hasSelected,
            "Нет ни одной строки именно с '$searchingName' (только '$anyText')."
        )
    }
}