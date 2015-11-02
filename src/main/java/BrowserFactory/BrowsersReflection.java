package BrowserFactory;

import org.openqa.selenium.WebDriver;

/**
 * Created by HOME on 03.11.2015.
 */
public class BrowsersReflection {
    public static WebDriver newBrowser(String name) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        return (WebDriver) Class.forName(name).newInstance();
    }
}
