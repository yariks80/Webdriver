import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.CommandExecutor;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.concurrent.TimeUnit;

/**
 * Created by my on 01.05.2015.
 */
public class NavigationCommands {
    private static WebDriver driver = null;

    public static void main(String[] args) throws InterruptedException {
        // Create a new instance of the Firefox driver

        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://korrespondent.net/");
        System.out.println(driver.getWindowHandle());
        driver.navigate().to("http://www.gooogle.com");
        Thread.sleep(2000);
        System.out.println(driver.getWindowHandle());
        driver.navigate().forward();
        // Put an Implicit wait on driver
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //http://internetka.in.ua/selenium-webdriver-window/

    }
}
