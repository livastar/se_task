package core.configs;

import com.google.inject.AbstractModule;
import com.google.inject.Scopes;
import core.pages.BaseWebSite;
import org.openqa.selenium.WebDriver;

public class TestModule extends AbstractModule {

    @Override
    public void configure() {
        bind(WebConfig.class).toProvider(WebConfigProvider.class);
        bind(WebDriver.class).toProvider(WebDriverProvider.class).in(Scopes.SINGLETON);
        bind(BaseWebSite.class).toProvider(BaseWebSiteProvider.class);
    }

}
