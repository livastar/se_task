package core.configs;

import com.google.inject.Provider;
import org.aeonbits.owner.ConfigFactory;

public class WebConfigProvider implements Provider<WebConfig> {

    @Override
    public WebConfig get() {
        return ConfigFactory.create(WebConfig.class, System.getProperties());
    }

}
