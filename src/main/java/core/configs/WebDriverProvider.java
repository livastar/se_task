package core.configs;

import com.google.inject.Inject;
import com.google.inject.Provider;
import lombok.SneakyThrows;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URI;

public class WebDriverProvider implements Provider<WebDriver> {

    final WebConfig webConfig;

    @Inject
    public WebDriverProvider(final WebConfig webConfig) {
        this.webConfig = webConfig;
    }

    @SneakyThrows
    @Override
    public WebDriver get() {
        WebDriver webDriver;
        switch (DriverType.get(webConfig.getDriverType())) {
            case FIREFOX:
                webDriver = new FirefoxDriver();
                break;
            case REMOTE:
                webDriver = createNewRemoteWebDriver();
                break;
            case CHROME:
            default:
                webDriver = createNewChromeWebDriver();
                break;
        }
        return webDriver;
    }

    public WebDriver createNewRemoteWebDriver() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setBrowserName(webConfig.getRemoteDriverName());
        capabilities.setCapability("enableVNC", webConfig.isVncEnabled());
        if (webConfig.isVideoEnabled()) {
            capabilities.setCapability("enableVideo", webConfig.isVideoEnabled());
        }
        RemoteWebDriver remoteWebDriver =
                new RemoteWebDriver(URI.create(webConfig.getRemoteDriverHost() + "/wd/hub").toURL(), capabilities);
        return remoteWebDriver;
    }

    //check for more options https://source.chromium.org/search?q=file:switches.cc&ss=chromium%2Fchromium%2Fsrc
    public WebDriver createNewChromeWebDriver() {
        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        ChromeOptions options = new ChromeOptions();
        if (webConfig.isHeadless()) {
            options.addArguments("headless");
        }
        capabilities.setCapability(ChromeOptions.CAPABILITY, options);
        return new ChromeDriver(options);
    }
}
