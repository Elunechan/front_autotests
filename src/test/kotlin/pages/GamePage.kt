package pages

import com.codeborne.selenide.Condition.visible
import com.codeborne.selenide.Selenide.*
import com.codeborne.selenide.SelenideElement


open class GamePage {

    // --- Золото ---
    val serverDropdown = `$`(".form-control.showcase-filter-input[name='server']")
    val sideDropdown = `$`(".form-control.showcase-filter-input[name='side']")
    val saleButton = `$`(".col-sm-4.hidden-xs")
    val toBeOnlineRadioButton = `$`(".form-control-box.switch")
    val sortByPrice = `$`(".tc-price.text-right.sort.ascending")

    // --- Статус онлайн/оффлайн у продавцов ---
    val onlineAvatars = `$$`(".media-user.style-circle.online .avatar-photo")
    val offlineAvatars = `$$`(".media-user.style-circle:not(.online) .avatar-photo")

    // --- Аккаунты ---
    val classesDropdown = `$`(".form-control.lot-field-input[name='f-class']")
    val raceDropdown = `$`(".form-control.lot-field-input[name='f-race']")
    val sellAccountButton = `$`(".btn.btn-default.btn-wide[href='https://funpay.com/lots/13/trade']")
    val textFieldFind = `$x`("//*[@id='content']/div/div[3]/div/div[2]/div[1]/div[2]/div[1]/div/form/div[5]/input")
    val noOffersText = `$x`("//*[@id='content']/div/div[3]/div/div[2]/p")
    val tttest = `$`(".tc-server.hidden-xxs")

    // --- Функции ---

    /** Функция находит поле ввода по локатору, и вводит значение
     * @param "fieldName" - поле ввода
     * @param "query" - значение которое нужно ввести
     */
    fun searchField(fieldName: SelenideElement, query: String): GamePage {
        fieldName.setValue(query)
        return this
    }

    /** Проверка на то, что лоты отображаются
     * @param "noSeeLots" - подсказка о том, что лоты не найдены
     */
    fun lotsBeVisible(noSeeLots: SelenideElement) {
        noSeeLots.shouldNotBe(visible)
    }

    /** Проверка на то, что лоты НЕ отображаются
     * @param "noSeeLots" - подсказка о том, что лоты не найдены
     */
    fun lotsNotVisible(noSeeLots: SelenideElement) {
        noSeeLots.shouldBe(visible)
    }
}