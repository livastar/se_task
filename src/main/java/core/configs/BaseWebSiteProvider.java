package core.configs;

import com.google.inject.Binder;
import com.google.inject.Inject;
import com.google.inject.Module;
import com.google.inject.Provider;
import core.pages.BaseWebSite;
import io.qameta.atlas.core.Atlas;
import io.qameta.atlas.core.context.RetryerContext;
import io.qameta.atlas.core.internal.DefaultRetryer;
import io.qameta.atlas.webdriver.WebDriverConfiguration;
import org.openqa.selenium.WebDriver;

import java.util.Collections;

public class BaseWebSiteProvider implements Module, Provider<BaseWebSite> {

    WebConfig webConfig;
    WebDriver webDriver;
    Atlas atlas;

    @Inject
    public BaseWebSiteProvider(WebDriver webDriver, WebConfig webConfig) {
        this.webDriver = webDriver;
        this.webConfig = webConfig;
    }

    @Override
    public BaseWebSite get() {
        atlas = new Atlas(new WebDriverConfiguration(webDriver, webConfig.getBaseUrl()))
                .context(new RetryerContext(new DefaultRetryer(webConfig.getTimeout(), webConfig.getPoolingTimeout(),
                        Collections.singletonList(Throwable.class))));

        return atlas.create(webDriver, BaseWebSite.class);
    }

    @Override
    public void configure(Binder binder) {
    }

}
