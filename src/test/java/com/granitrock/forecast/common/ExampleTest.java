package com.granitrock.forecast.common;

import core.helpers.User;
import io.qameta.allure.*;
import io.qameta.atlas.webdriver.extension.Name;
import org.junit.jupiter.api.Test;


@Epic("LearnThat")
@Feature("Client UI")
@Severity(SeverityLevel.NORMAL)
//@IncludeModule(BaseWebSiteProvider.class)
//@IncludeModule(WebDriverProvider.class)
public class ExampleTest extends BaseTest {

    User oldUser = new User(config.getUserName(), config.getPassword());

    @Test()
    @TmsLink("FOR-255")
    @Story("Portal UI")
    @Name("This test demonstrates how to use Selenide, JUnit5, Allure...")
    public void passedTest() {
        getWebSite().onMainPage().loginWith(oldUser);
//        onWebSite.onMainPage().pageTitle().should("User is not found",
//                Matchers.containsInAnyOrder("Student Portal"));
    }

//    @Test
//    @TmsLink("FOR-255")
//    @Story("Portal UI")
//    @DisplayName("This test demonstrates how to use Selenide, JUnit5, Allure...")
//    void passedTestOld() {
//        baseSteps.loginSteps.login();
//        baseSteps.generalSteps();
//        portalPage = open("/users/login", LoginPageSelenide.class)
//                .login("cnegrila@graniterock.com", "grcconsultant");
//        portalPage.verifyDashboardTitle("Student Portal");
//    }

//    @Test
//    @Story("Portal UI")
//    @Description("This test demonstrates how to use Selenide, JUnit5, Allure...")
//    void failedTest() {
//        this.portalPage.verifyDashboardTitle("Teacher Portal");
//    }
//
//    @Test
//    @Story("Portal UI")
//    @Description("This test demonstrates how to use Selenide, JUnit5, Allure...")
//    void brokenTest() {
//        this.portalPage.verifyLastQuizMenu();
//    }
}
