import atexit
import sys
from selenium import webdriver
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.common.by import By
from selenium.webdriver.support import expected_conditions as EC


class PythonOrgSearch:
    language_section = "//a[@href='/en/']"
    home_page = "https://www.bet365.com/#/IP/"
    event_tab = "//div[contains(@class,'ip-ControlBar_BBarItem')][contains(text(),'Event View')]"
    needed_line_for_print = "//*[contains(text(),'{###}')]//..//..//div[@class='gll-MarketGroupContainer ']"

    def __init__(self):
        self.driver = webdriver.Firefox()
        self.wait = WebDriverWait(self.driver, 10000)
        self.driver.get(self.home_page)
        atexit.register(self.exit_handler)

    def wait_for_element(self, byElement):
        return self.wait.until(EC.visibility_of_element_located((By.XPATH, byElement)))

    def choose_language(self):
        language_el = self.wait_for_element(self.language_section)
        language_el.click()
        self.driver.get(self.home_page)

    def select_event_tab(self):
        select_event = self.wait_for_element(self.event_tab)
        select_event.click()

    def print_info_line_for_section(self, section_name):
        print("<><><><><><><><><><><><> Showing info for: '{}' section: <><><><><><><><><><><><>".format(section_name))
        print(self.wait_for_element(
            self.needed_line_for_print.replace('{###}', section_name)).text)
        print("<><><><><><><><><><><><><><><><><><><><><><><><>")

    def exit_handler(self):
        self.driver.quit()


if __name__ == "__main__":
    bet365 = PythonOrgSearch()
    bet365.choose_language()
    bet365.select_event_tab()
    bet365.print_info_line_for_section(sys.argv[1])
