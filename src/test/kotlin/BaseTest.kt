package uiTests

import com.codeborne.selenide.Configuration
import com.codeborne.selenide.Selenide
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeAll
import pages.LoginPage
import uiTests.pages.MainPage


//------------------------------------------
//Конфиги для запуска браузера
open class BaseTest {
    companion object {
        @BeforeAll
        @JvmStatic
        fun setUp() {
            Configuration.browser = "chrome"
            Configuration.browserSize = "2560x1440"
            Configuration.timeout = 2000
            Configuration.headless = false
        }

        //------------------------------------------
        //Константы
        const val BASE_URL = "https://funpay.com"

        //------------------------------------------
        //Доступ к Pages без инициализации классов в тесте
        val mainPage: MainPage by lazy { MainPage() }
        val loginPage: LoginPage by lazy { LoginPage() }

    }

    @AfterEach
    fun tearDown() {
        Selenide.clearBrowserCookies()
        Selenide.clearBrowserLocalStorage()
        // Если нужно ещё и драйвер закрывать:
        // Selenide.closeWebDriver()
    }
}