package uiTests

import com.codeborne.selenide.Selenide.*
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class HeaderNavigationTests() : BaseTest() {

    @Test
    @DisplayName("Открываем сайт, переходим на страницу авторизации и кликаем 'Войти'")
    fun openSite() {
        open(BASE_URL) //Для прозрачности решила использовать переменную вместо "/"
        mainPage.login.click()
        loginPage.enter.click()
    }
}