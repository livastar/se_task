package core.configs;

import org.aeonbits.owner.Config;

@Config.Sources("classpath:dev.properties")
public interface WebConfig extends Config {

    @Key("remote.driver.host")
    String getRemoteDriverHost();

    @Key("remote.driver.name")
    String getRemoteDriverName();

    @Key("remote.browser.enable.video")
    @DefaultValue("false")
    boolean isVideoEnabled();

    @Key("remote.enable.vnc")
    @DefaultValue("true")
    boolean isVncEnabled();

    @Key("driver.headless")
    @DefaultValue("false")
    boolean isHeadless();

    @Key("driver.type")
    @DefaultValue("chrome")
    String getDriverType();

    @Key("base.url")
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
