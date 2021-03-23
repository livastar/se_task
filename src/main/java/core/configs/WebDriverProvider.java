package core.configs;

import com.google.inject.Inject;
import com.google.inject.Provider;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverProvider implements Provider<WebDriver> {

    final WebConfig webConfig;

    @Inject
    public WebDriverProvider(final WebConfig webConfig) {
        this.webConfig = webConfig;
    }

    @Override
    public WebDriver get() {
        return new ChromeDriver();
    }

}
