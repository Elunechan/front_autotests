package pages

import com.codeborne.selenide.Condition
import com.codeborne.selenide.Selenide.`$$`

open class LoginPage {
    val enter = `$$`("button") //Использую $$ для поиска по тексту в конкретном классе
        .findBy(Condition.text("Войти"))
}