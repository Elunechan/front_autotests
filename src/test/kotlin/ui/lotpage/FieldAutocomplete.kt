package ui.ui.lotpage

import com.codeborne.selenide.Condition.value
import com.codeborne.selenide.Selenide.open
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import ui.BaseTest
import ui.config.Routes



@DisplayName("Проверка автозаполнения поля при выборе значения в соседнем поле 'Получу/Заплачу'")
class FieldAutocomplete() : BaseTest() {

    @Test
    @DisplayName("Автозаполнения поля 'Заплачу' при вводе значения в поле 'Получу'")
    fun priceAutocomplete() {
        open(Routes.LOT_PAGE)
        lotPage.setPaymentMethodSbp()
        lotPage.fieldAmount.value = lotPage.testPrice
        lotPage.fieldPay.shouldHave(value(lotPage.buyerWillPay))
    }

    @Test
    @DisplayName("Автозаполнения поля 'Получу' при вводе значения в поле 'Заплачу'")
    fun amountAutocomplete() {
        open(Routes.LOT_PAGE)
        lotPage.setPaymentMethodSbp()
        lotPage.fieldPay.value = lotPage.testPrice
        lotPage.fieldAmount.shouldHave(value(lotPage.testGetGold))
    }
}