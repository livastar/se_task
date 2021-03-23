package core.module;

import com.google.inject.Binder;
import com.google.inject.Module;
import com.google.inject.Provides;
import core.configs.WebConfig;
import core.configs.WebDriverProvider;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;

public class WebDriverModule implements Module {

    @Override
    public void configure(final Binder binder) {
        binder.bind(WebDriver.class).toProvider(WebDriverProvider.class);
    }

    @Provides
    public WebConfig provideWebConfig() {
        return ConfigFactory.create(WebConfig.class, System.getProperties());
    }

}
