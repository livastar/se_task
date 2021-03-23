package core.configs;

import com.google.inject.Inject;
import com.google.inject.Provider;
import core.configs.driver.DriverManagerFactory;
import core.configs.driver.DriverType;
import org.openqa.selenium.WebDriver;

public class WebDriverProvider implements Provider<WebDriver> {

    final WebConfig webConfig;

    @Inject
    public WebDriverProvider(final WebConfig webConfig) {
        this.webConfig = webConfig;
    }

    @Override
    public WebDriver get() {
        return DriverManagerFactory.getManager(DriverType.get(webConfig.getDriverType())).getDriver();
    }

}
