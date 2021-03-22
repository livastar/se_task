package core.helpers;

import io.qameta.atlas.webdriver.extension.Selector;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface FindByCss {

    String value();

    Selector selector() default Selector.CSS;

}
