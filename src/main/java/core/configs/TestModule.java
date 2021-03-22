package core.configs;

import com.google.inject.AbstractModule;
import io.qameta.atlas.webdriver.WebSite;
import org.openqa.selenium.WebDriver;

public class TestModule extends AbstractModule {

    @Override
    public void configure() {
        bind(WebConfig.class).toProvider(WebConfigProvider.class);
        bind(WebDriver.class).toProvider(WebDriverProvider.class);
        bind(WebSite.class).toProvider(BaseWebSiteProvider.class);
    }
}
