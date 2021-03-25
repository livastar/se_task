package com.rock.cast.common;

import core.configs.WebConfig;
import core.module.WebDriverModule;
import io.qameta.atlas.core.Atlas;
import io.qameta.atlas.webdriver.WebDriverConfiguration;
import name.falgout.jeffrey.testing.junit.guice.GuiceExtension;
import name.falgout.jeffrey.testing.junit.guice.IncludeModule;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;

import javax.inject.Inject;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import static org.junit.jupiter.api.TestInstance.Lifecycle;

@IncludeModule(WebDriverModule.class)
@ExtendWith(GuiceExtension.class)
@TestInstance(Lifecycle.PER_CLASS)
public class BaseTest {

    private Atlas atlas;
    public static final WebConfig config = ConfigFactory.create(WebConfig.class);

    @Inject
    private WebDriver driver;

    @BeforeEach
    public void startDriver() {
        atlas = new Atlas(new WebDriverConfiguration(driver, config.getBaseUrl()))
//                .context(new RetryerContext(new DefaultRetryer(config.getTimeout(), config.getPoolingTimeout()
//                        Collections.singletonList(Throwable.class)
                ;
    }

    @AfterEach
    public void stopDriver() {
        driver.close();
        driver.quit();
    }

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

}
