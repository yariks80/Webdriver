package LoggerEventWebDriver;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;

/**
 * Created by HOME on 02.11.2015.
 */
public class EventHandler implements WebDriverEventListener {
    static final Logger  LOGGER = LogManager.getLogger(EventHandler.class.getName());

    public void beforeNavigateTo(String s, WebDriver webDriver) {

    }

    public void afterNavigateTo(String url, WebDriver webDriver) {
        LOGGER.info("WebDriver navigated to '" + url + "'");

    }

    public void beforeNavigateBack(WebDriver webDriver) {

    }

    public void afterNavigateBack(WebDriver webDriver) {

    }

    public void beforeNavigateForward(WebDriver webDriver) {

    }

    public void afterNavigateForward(WebDriver webDriver) {

    }

    public void beforeFindBy(By by, WebElement webElement, WebDriver webDriver) {

    }

    public void afterFindBy(By by, WebElement webElement, WebDriver webDriver) {

    }

    public void beforeClickOn(WebElement webElement, WebDriver webDriver) {


    }

    public void afterClickOn(WebElement webElement, WebDriver webDriver) {

    }

    public void beforeChangeValueOf(WebElement webElement, WebDriver webDriver) {

    }

    public void afterChangeValueOf(WebElement webElement, WebDriver webDriver) {

    }

    public void beforeScript(String s, WebDriver webDriver) {

    }

    public void afterScript(String s, WebDriver webDriver) {

    }

    public void onException(Throwable throwable, WebDriver webDriver) {

    }
}
