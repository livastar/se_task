package core.pages;

import io.qameta.atlas.webdriver.WebSite;
import io.qameta.atlas.webdriver.extension.Page;

public interface BaseWebSite extends WebSite {

    @Page(url = "users/login")
    MainPage onMainPage();

    @Page(url = "/dictionary")
    DictionaryPage onDictionaryPage();

}