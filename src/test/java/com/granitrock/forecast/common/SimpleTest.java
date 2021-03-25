package com.granitrock.forecast.common;

import core.configs.WebConfig;
import core.helpers.User;
import core.module.WebDriverModule;
import core.pages.BaseWebSite;
import core.pages.MainPage;
import io.qameta.atlas.core.Atlas;
import io.qameta.atlas.core.context.RetryerContext;
import io.qameta.atlas.core.internal.DefaultRetryer;
import io.qameta.atlas.webdriver.WebDriverConfiguration;
import io.qameta.atlas.webdriver.WebPage;
import name.falgout.jeffrey.testing.junit.guice.GuiceExtension;
import name.falgout.jeffrey.testing.junit.guice.IncludeModule;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;

import javax.inject.Inject;
import java.util.Collections;

import static org.junit.jupiter.api.TestInstance.Lifecycle;

@IncludeModule(WebDriverModule.class)
@ExtendWith(GuiceExtension.class)
@TestInstance(Lifecycle.PER_CLASS)
public class SimpleTest {

    User oldUser = new User(config.getUserName(), config.getPassword());
    private Atlas atlas;
    public static final WebConfig config = ConfigFactory.create(WebConfig.class);

    @Inject
    private WebDriver driver;

    @BeforeEach
    public void startDriver() {
        atlas = new Atlas(new WebDriverConfiguration(driver, config.getBaseUrl()))
                .context(new RetryerContext(new DefaultRetryer(config.getTimeout(), config.getPoolingTimeout(),
                        Collections.singletonList(Throwable.class))));
    }

    public BaseWebSite onSite() {
        return atlas.create(driver, BaseWebSite.class);
    }

    public <T extends WebPage> T onPage(Class<T> page) {
        return atlas.create(driver, page);
    }

    public MainPage onMainPage() {
        return onPage(MainPage.class);
    }

    @Test
    public void testAnotherPage() {
        onSite().onMainPage().open("https://www.learnthat.org");
        onSite().onMainPage().userName().sendKeys(oldUser.getEmail());
        onSite().onMainPage().password().sendKeys(oldUser.getPassword());
        onSite().onMainPage().submitBtn().click();
    }

    @AfterEach
    public void stopDriver() {
        driver.close();
        driver.quit();
    }

}
