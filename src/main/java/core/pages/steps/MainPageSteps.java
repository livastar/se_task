package core.pages.steps;

import core.helpers.User;
import core.pages.MainPage;
import io.qameta.allure.Step;

public class MainPageSteps {

    MainPage onMainPage;

    @Step("Login with {user}")
    public MainPageSteps loginWith(User user) {
        onMainPage.userName().sendKeys(user.getEmail());
        onMainPage.password().sendKeys(user.getPassword());
        onMainPage.submitBtn().click();
        return this;
    }

}
