package core.configs;

import org.aeonbits.owner.Config;

@Config.Sources("classpath:dev.properties")
public interface WebConfig extends Config {

    @Key("remote")
    boolean isRemote();

    @Key("driverType")
    String getDriverType();

    @Key("baseUrl")
    String getBaseUrl();

    @Key("timeout")
    Long getTimeout();

    @Key("pooling")
    Long getPoolingTimeout();

    @Key("user.email")
    String getUserEmail();

    @Key("user.password")
    String getUserPassword();

    @Key("username")
    String getUserName();

    @Key("password")
    String getPassword();

}
