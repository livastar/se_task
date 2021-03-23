package core.configs;

import com.google.inject.Module;
import com.google.inject.*;
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
        return DriverManagerFactory.getManager(DriverType.get(webConfig.getDriverType())).getDriver();
    }

    @Override
    public void configure(Binder binder) {
        binder.bind(WebDriver.class).toProvider(WebDriverProvider.class).in(Scopes.SINGLETON);
    }
}
