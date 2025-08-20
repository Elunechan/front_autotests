package ui

import com.codeborne.selenide.Configuration
import com.codeborne.selenide.Selenide
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeAll
import pages.GamePage
import ui.components.GridTable
import ui.components.SelectFilter
import ui.lists.ListClass
import ui.pages.MainPage
import ui.utils.StringIntConverter


open class BaseTest {

    companion object {
        @BeforeAll
        @JvmStatic
        fun setUp() {
            Configuration.browser = "chrome"
            Configuration.browserSize = "1600x900"
            Configuration.timeout = 2000
            Configuration.headless = false
        }
    }

    @AfterEach
    fun tearDown() {
        Selenide.clearBrowserCookies()
        Selenide.clearBrowserLocalStorage()
        Selenide.closeWebDriver()
    }


    val mainPage: MainPage by lazy { MainPage() }
    val gamePage: GamePage by lazy { GamePage() }
    val selectFilter: SelectFilter by lazy { SelectFilter() }
    val gridTable: GridTable by lazy { GridTable() }
    val converter: StringIntConverter by lazy { StringIntConverter() }
    val listClass: ListClass by lazy { ListClass() }
}