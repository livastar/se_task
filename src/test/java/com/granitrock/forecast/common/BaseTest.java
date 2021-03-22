package com.granitrock.forecast.common;

import com.google.inject.Inject;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.openqa.selenium.WebDriver;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class BaseTest {

    @Inject
    WebDriver driver;


//    @BeforeAll
//    static void startDriver() {
//        driver = DriverManagerFactory.getManager(DriverType.get(config.getDriverType())).getDriver();
//        atlas = new Atlas(new WebDriverConfiguration(driver, config.getBaseUrl()))
//                .context(new RetryerContext(new DefaultRetryer(config.getTimeout(), config.getPoolingTimeout(),
//                        Collections.singletonList(Throwable.class))));
//        onWebSite = atlas.create(driver, BaseWebSite.class);
//    }

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
