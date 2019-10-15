import com.automation.remarks.kirk.KElement
import com.automation.remarks.kirk.Kirk.Companion.browser
import com.automation.remarks.kirk.conditions.cssClass
import com.automation.remarks.kirk.conditions.visible
import org.openqa.selenium.By
import org.openqa.selenium.firefox.FirefoxDriver
import java.util.logging.Level

class GrabTheInfo {

    private val eventTabXpath = "//div[contains(@class,'ip-ControlBar_BBarItem')][contains(text(),'Event View')]"
    private val neededLineForPrintXpath = "//*[contains(text(),'{###}')]//..//..//div[@class='gll-MarketGroupContainer ']"
    private val homePage = "https://www.bet365.com/#/IP/"
    private val timeout = 5000
    private val section: String = System.getProperty("section")
//    private val browser = Browser(FirefoxDriver(FirefoxOptions().apply {
//        addArguments("--headless")
//    }))

    private fun element(selector: By): KElement = browser.element(selector)

    private fun openHomePage() {
        browser.open(homePage)
        val englishLanguage = element(By.xpath("//a[@href='/en/']")).waitUntil(visible, timeout)
        englishLanguage.click()
        browser.open(homePage)
    }

    private fun selectEventViewTab() {
        val eventTab = element(By.xpath(eventTabXpath)).waitUntil(visible, timeout)
        eventTab.click()
        eventTab.shouldHave(cssClass("lul-ButtonBar_Selected"))
    }

    private fun printInfoLineForSection(sectionName: String = "Fulltime Result") {
        val neededLineForPrint = element(By.xpath(neededLineForPrintXpath.replace("{###}", sectionName))).waitUntil(visible, timeout)
        println(neededLineForPrint.text)
    }

    private fun disableLogging() {
        System.setProperty(FirefoxDriver.SystemProperty.DRIVER_USE_MARIONETTE, "true")
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "/dev/null")
        java.util.logging.Logger.getLogger("org.openqa.selenium").level = Level.OFF
    }

    fun testCanLogin() {
        disableLogging()
        openHomePage()
        selectEventViewTab()
        println("<><><><><><><><><><><><> Showing info for: $section section: <><><><><><><><><><><><>")
        printInfoLineForSection(section)
        println("<><><><><><><><><><><><><><><><><><><><><><><><>")
        browser.quit()
    }

}

fun main(args: Array<String>) {
    val test = GrabTheInfo()
    test.testCanLogin()
}