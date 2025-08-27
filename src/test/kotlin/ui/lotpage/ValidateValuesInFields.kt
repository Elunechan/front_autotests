package ui.ui.lotpage

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.params.ParameterizedTest
import ui.config.Routes
import com.codeborne.selenide.Selenide.open
import ui.BaseTest
import org.junit.jupiter.params.provider.ValueSource


@DisplayName("Проверка ввода символов в поля ввода")
class ValidateValuesInFields() : BaseTest() {

    @ParameterizedTest
    @ValueSource(
        strings = ["-1",
            "500",
            "999999999999999112", // Больше, чем есть у продавца
            "!№;,+_)(:;'",
            "Qwerty",
            "Тест"
        ]
    )
    @DisplayName("Проверка ввода различных символов в поле 'Получу'")
    fun validateValuesInGetGold(value: String) {
        open(Routes.LOT_PAGE)
        lotPage.setPaymentMethodSbp()
        lotPage.fieldAmount.click()
        lotPage.fieldAmount.setValue(value)
    }

    @ParameterizedTest
    @ValueSource(
        strings = ["-1",
            "500",
            "999999999999999112", // Больше, чем есть у продавца
            "!№;,+_)(:;'",
            "Qwerty",
            "Тест"
        ]
    )
    @DisplayName("Проверка ввода различных символов в поле 'Заплачу'")
    fun validateValuesInfieldPay(value: String) {
        open(Routes.LOT_PAGE)
        lotPage.setPaymentMethodSbp()
        lotPage.fieldPay.click()
        lotPage.fieldPay.setValue(value)
    }

    @ParameterizedTest
    @ValueSource(
        strings = ["1234567890",
            "!№;,+_)(:;'",
            "Qwerty",
            "Тест",
            "   "
        ]
    )
    @DisplayName("Проверка ввода различных символов в поле ввода имени персонажа'")
    fun validateValuesInCharacterName(value: String) {
        open(Routes.LOT_PAGE)
        lotPage.fieldCharacterName.click()
        lotPage.fieldCharacterName.setValue(value)
    }
}