package core.pages;

import core.helpers.User;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import io.qameta.atlas.webdriver.AtlasWebElement;
import io.qameta.atlas.webdriver.WebPage;
import io.qameta.atlas.webdriver.extension.FindBy;
import io.qameta.atlas.webdriver.extension.Name;
import io.qameta.atlas.webdriver.extension.Param;
import io.qameta.atlas.webdriver.extension.Selector;

public interface MainPage extends WebPage {

    @Name("{text} inputBtn field")
    @FindBy(value = "#{{ text }}", selector = Selector.CSS)
    AtlasWebElement inputBtn(@Param("text") String text);

    @Name("Submit button")
    @FindBy(value = "inputBtn[type='submit'][value='Log In']", selector = Selector.CSS)
    AtlasWebElement submitBtn();

    @FindBy(value = ".student_dashboard div h1", selector = Selector.CSS)
    AtlasWebElement pageTitlej();

    @Description("Login with {username}/{password}")
    default void login(String userName, String password) {
        inputBtn("UserUsername").sendKeys(userName);
        inputBtn("UserPassword").sendKeys(password);
        submitBtn().click();
    }

    @Step("Login with credentials for user with email {user.email}")
    default void loginWith(User user) {
        inputBtn("UserUsername").sendKeys(user.getEmail());
        inputBtn("UserPassword").sendKeys(user.getPassword());
        submitBtn().click();
    }


}