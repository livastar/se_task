package core.configs.driver;

import lombok.AllArgsConstructor;
import lombok.SneakyThrows;

import static java.lang.String.format;
import static java.util.stream.Stream.of;
import static org.apache.commons.lang3.StringUtils.equalsIgnoreCase;

@AllArgsConstructor
public enum DriverType {

    REMOTE("ci"),
    CHROME("chrome"),
    FIREFOX("firefox");

    private final String name;

    @SneakyThrows
    public static synchronized DriverType get(String browserName) {
        return of(DriverType.values())
                .filter(browser -> equalsIgnoreCase(browser.name(), browserName))
                .findFirst().orElseThrow(() -> new RuntimeException(
                        format("[%s] browser does not match with any of types in the [%s] enum",
                                browserName, DriverType.class.getSimpleName())));
    }
}
