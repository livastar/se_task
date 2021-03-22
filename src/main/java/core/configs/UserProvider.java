package core.configs;

import com.google.inject.Binder;
import com.google.inject.Inject;
import com.google.inject.Module;
import com.google.inject.Provider;
import core.helpers.User;
import core.services.UserService;

public class UserProvider implements Module, Provider<User> {

    private final WebConfig webConfig;

    @Inject
    public UserProvider(WebConfig webConfig) {
        this.webConfig = webConfig;
    }

    @Override
    public User get() {
        return UserService.createUser(webConfig.getUserEmail(), webConfig.getUserPassword());
    }

    @Override
    public void configure(Binder binder) {
    }
}
