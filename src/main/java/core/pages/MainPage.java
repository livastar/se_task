package core.pages;

import io.qameta.atlas.webdriver.AtlasWebElement;
import io.qameta.atlas.webdriver.WebPage;
import io.qameta.atlas.webdriver.extension.*;

public interface MainPage extends WebPage {

    @Name("{text} inputBtn field")
    @FindBy(value = "#{{ text }\\}", selector = Selector.CSS)
    AtlasWebElement inputBtn(@Param("text") String text);

    @Name("username input")
    @FindBy(value = "//*[@id='UserUsername']")
    AtlasWebElement userName();

    @Name("password input")
    @FindBy(value = "//*[@id='UserPassword']")
    AtlasWebElement password();

    @Name("Submit button")
    @FindBy(value = "input[type='submit'][value='Log In']", selector = Selector.CSS)
    AtlasWebElement submitBtn();

    @FindBy(value = ".student_dashboard div h1", selector = Selector.CSS)
    AtlasWebElement pageTitle();

}