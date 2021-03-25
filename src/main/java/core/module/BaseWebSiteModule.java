package core.module;

import com.google.inject.Binder;
import com.google.inject.Module;
import core.configs.BaseWebSiteProvider;
import core.pages.BaseWebSite;

public class BaseWebSiteModule implements Module {

    @Override
    public void configure(Binder binder) {
        binder.bind(BaseWebSite.class).toProvider(BaseWebSiteProvider.class);
    }
}
