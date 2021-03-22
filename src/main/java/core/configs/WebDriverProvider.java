package core.configs;

import com.google.inject.Binder;
import com.google.inject.Inject;
import com.google.inject.Module;
import com.google.inject.Provider;
import core.configs.driver.DriverManagerFactory;
import core.configs.driver.DriverType;
import org.openqa.selenium.WebDriver;

public class WebDriverProvider implements Module, Provider<WebDriver> {

    WebConfig webConfig;

    @Inject
    public WebDriverProvider(WebConfig webConfig) {
        this.webConfig = webConfig;
    }

    @Override
    public WebDriver get() {
//        return new WebDriver(webConfig);
        return DriverManagerFactory.getManager(DriverType.get(webConfig.getDriverType())).getDriver();
    }

    @Override
    public void configure(Binder binder) {
//        binder.bind(WebDriver.class).toProvider(WebDriverProvider.class);
    }
}
