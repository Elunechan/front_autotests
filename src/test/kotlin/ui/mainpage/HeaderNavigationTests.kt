package ui.ui.mainpage

import com.codeborne.selenide.Selenide.*
import com.codeborne.selenide.WebDriverConditions.url
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import ui.BaseTest
import ui.config.Routes

class HeaderNavigationTests : BaseTest() {

    @Test
    @DisplayName("Проверка нажатия кнопки 'Войти'")
    fun openAuth() {
        open(Routes.BASE_URL)
        mainPage.login.click()
        webdriver().shouldHave(url(Routes.LOGIN_PAGE))
    }


    @Test
    @DisplayName("Проверка нажатия кнопки 'Зарегистрироваться'")
    fun openReg() {
        open(Routes.BASE_URL)
        mainPage.register.click()
        webdriver().shouldHave(url(Routes.REGISTER))
    }
}