package ui.pages

import com.codeborne.selenide.Condition.text
import com.codeborne.selenide.Selenide.`$`
import com.codeborne.selenide.Selenide.`$$`

open class LotPage {

    val headerLotPage = `$`(".collapse.navbar-collapse.no-transition")
    val footerLotPage = `$`(".footer-block.footer-block-strings")
    val chat = `$`(".chat.chat-float.mb35.a-affix")
    val fieldCharacterName = `$`(".form-control[name='player']")
    val backToList = `$`(".fa.fa-chevron-left")
    val buyButton = `$`(".btn.btn-primary.btn-block")

    val fieldAmount = `$`("[name='amount']")
    val fieldPay = `$`(".form-control[name='sum']")
    val paymentMethod = `$`(".filter-option .payment")
    val sbp = `$$`(".payment-title").findBy(text("СБП"))


    fun setPaymentMethodSbp() {
        paymentMethod.click()
        sbp.click()
    }
}