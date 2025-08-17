package ui.pages

import com.codeborne.selenide.Selenide.`$`

open class MainPage {
    val login = `$`("[href='https://funpay.com/account/login']")
    val register = `$`("[href='https://funpay.com/account/register']")
}