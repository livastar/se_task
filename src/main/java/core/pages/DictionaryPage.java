package core.pages;

import io.qameta.atlas.webdriver.AtlasWebElement;
import io.qameta.atlas.webdriver.WebPage;
import io.qameta.atlas.webdriver.extension.FindBy;
import io.qameta.atlas.webdriver.extension.Name;
import io.qameta.atlas.webdriver.extension.Selector;

public interface DictionaryPage extends WebPage {

    @Name("Tutoring comment")
    @FindBy(value = ".tutoring_comment > div h5", selector = Selector.CSS)
    AtlasWebElement tutoringCmtTxt();

}