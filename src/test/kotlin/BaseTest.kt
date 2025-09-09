package ui

import com.codeborne.selenide.Configuration
import com.codeborne.selenide.Selenide
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeAll
import pages.GamePage
import ui.components.GridTable
import ui.components.SelectFilter
import ui.pages.LotPage
import ui.pages.MainPage
import ui.utils.StringIntConverter

// toDo: Декомпозировать

open class BaseTest {

    companion object {
        @BeforeAll
        @JvmStatic
        fun setUp() {
            Configuration.browser = "chrome"
            Configuration.browserSize = "1600x900"
            Configuration.timeout = 2000
            Configuration.headless = true
        }
    }

    @AfterEach
    fun tearDown() {
        Selenide.clearBrowserCookies()
        Selenide.clearBrowserLocalStorage()
        Selenide.closeWebDriver()
    }


    val mainPage = MainPage()
    val gamePage = GamePage()
    val selectFilter = SelectFilter()
    val gridTable = GridTable()
    val converter = StringIntConverter()
    val lotPage = LotPage()
}