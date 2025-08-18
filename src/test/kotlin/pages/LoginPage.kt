package pages


import com.codeborne.selenide.Selenide.`$`
import com.codeborne.selenide.Condition
import com.codeborne.selenide.Selenide.`$$`


open class LoginPage {
    val enter = `$$`("button")
        .findBy(Condition.text("Войти"))
    val login = `$`("[placeholder='Имя или почта']")
    val pass = `$`("[placeholder='Пароль'")
}


