package core.configs;

import com.google.inject.Binder;
import com.google.inject.Module;
import com.google.inject.Provider;
import org.aeonbits.owner.ConfigFactory;

public class WebConfigProvider implements Module, Provider<WebConfig> {

    @Override
    public WebConfig get() {
        return ConfigFactory.create(WebConfig.class, System.getProperties());
    }

    @Override
    public void configure(Binder binder) {
//        binder.bind(WebConfig.class).toProvider(WebConfigProvider.class);
    }
}
