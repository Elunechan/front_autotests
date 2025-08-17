package pages

import com.codeborne.selenide.Selenide.`$$`
import com.codeborne.selenide.Condition
import com.codeborne.selenide.Condition.visible
import com.codeborne.selenide.Selenide.`$`


open class GamePage {
    // --- Вкладки  ---

    val pvp = `$$`(".counter-list-pills")
        .findBy(Condition.text("PvP"))
    val items = `$$`(".counter-list-pills")
        .findBy(Condition.text("Предметы"))

    // --- Золото ---
    val serverDropdown = `$`(".form-control.showcase-filter-input[name='server']")
    val sideDropdown = `$`(".form-control.showcase-filter-input[name='side']").shouldBe(visible)
    val saleButton = `$`(".col-sm-4.hidden-xs")
    val toBeOnlineRadioButton = `$`(".form-control-box.switch")
    val sortByPrice = `$`(".tc-price.text-right.sort.ascending")

    // --- Статус онлайн/оффлайн у продавцов ---
    val onlineAvatars = `$$`(".media-user.style-circle.online .avatar-photo")
    val offlineAvatars = `$$`(".media-user.style-circle:not(.online) .avatar-photo")
}