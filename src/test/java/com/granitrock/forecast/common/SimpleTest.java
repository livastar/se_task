package com.granitrock.forecast.common;

import core.module.WebDriverModule;
import name.falgout.jeffrey.testing.junit.guice.GuiceExtension;
import name.falgout.jeffrey.testing.junit.guice.IncludeModule;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;

import javax.inject.Inject;

@IncludeModule(WebDriverModule.class)
@ExtendWith(GuiceExtension.class)
public class SimpleTest {

    @Inject
    private WebDriver driver;

    @Test
    public void testGoogle() {
        driver.get("https://google.com");
    }

    @AfterEach
    public void stopDriver() {
        driver.close();
        driver.quit();
    }

}
