package com.granitrock.forecast.common;

import com.google.inject.Inject;
import core.configs.TestModule;
import core.configs.WebConfig;
import core.pages.BaseWebSite;
import name.falgout.jeffrey.testing.junit.guice.IncludeModule;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.openqa.selenium.WebDriver;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

@TestInstance(Lifecycle.PER_CLASS)
@IncludeModule(TestModule.class)
public class BaseTest {
    public static final WebConfig config = ConfigFactory.create(WebConfig.class);

    @Inject
    BaseWebSite baseWebSite;

    @Inject
    WebDriver driver;

    @AfterAll
    static void addingEnvironmentVariablesToAllureReport() throws IOException {
        Properties props = new Properties();
        String propertyFilePath = System.getProperty("allure.results.directory") + "/environment.properties";
        System.getProperties().forEach((key, val) -> {
            if (key.toString().startsWith("allure.")) {
                props.put(key.toString().split("allure\\.")[1], val.toString());
            }
        });
        props.store(new FileOutputStream(propertyFilePath), "This is a sample properties file");
    }

    @AfterEach
    protected void closeDriver() {
        driver.quit();
    }

}
