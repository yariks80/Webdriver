import com.thoughtworks.selenium.webdriven.Windows;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.concurrent.TimeUnit;

/**
 * Created by my on 30.04.2015.
 */
public class Main {

    private static WebDriver driver = null;
    public static void main(String[] args) throws InterruptedException {

//-------------------------------------------------------------------------------------------------
        //Selenium will not support single slash, so we are providing double slash in path.

         //System.setProperty("webdriver.ie.driver", "Libdrivers\IEDriverServer32.exe");
         //System.setProperty("webdriver.ie.driver", "Libdrivers\IEDriverServer64.exe");
         //System.setProperty("webdriver.chrome.driver", "Libdrivers\\chromedriver.exe");
         System.setProperty("webdriver.opera.driver", "Libdrivers\\operadriver32.exe");
//---------------------------------------------------------------------------------------------------
         //driver = new FirefoxDriver();
        // driver = new InternetExplorerDriver();
        //driver = new ChromeDriver();
         //driver = new HtmlUnitDriver();
        driver = new OperaDriver();
//----------------------------------------------------------------------------------------------------
        //Put a Implicit wait, this means that any search for elements on the page could take the time the implicit wait is set for before throwing exception

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
// ---------------------------------------------------------------------------------------------------
       //The URL to load. It is best to use a fully qualified URL

        driver.get("http://www.google.com");
        Thread.sleep(2000);

 //----------------------------------------------------------------------------------------------------
       // This command is use to get the source of the last loaded page
        //String PageSource=driver.getPageSource();
        //System.out.println("-------------------------------------------------------------------------");
        //System.out.println("Page PageSource is: "+PageSource);

//----------------------------------------------------------------------------------------------------
// Refresh comman
        //driver.navigate().refresh();
        //driver.findElement(By.name("q")).sendKeys(Keys.F5);
       // driver.get(driver.getCurrentUrl());
       // driver.navigate().to(driver.getCurrentUrl());
       // driver.findElement(By.name("q")).sendKeys("\uE035");

//-----------------------------------------------------------------------------------------------------
        //This command is use to get the title of the current page
        String title = driver.getTitle();
        System.out.println("-------------------------------------------------------------------------");
        System.out.println("Page title is: "+title);

//-----------------------------------------------------------------------------------------------------
        //This command is use to get the URL of the page currently loaded in the browser.
        String CurrentUrl = driver.getCurrentUrl();
        System.out.println("-------------------------------------------------------------------------");
        System.out.println("Page CurrentUrl is: "+CurrentUrl);
//------------------------------------------------------------------------------------------------------
        Thread.sleep(2000);  // Let the user actually see something!
        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys("Hello!");
        searchBox.submit();
        Thread.sleep(2000);  // Let the user actually see something!
        //System.out.println("Page title is: " + driver.getTitle());  //HtmlUnitDriver
//-----------------------------------------------------------------------------------------------------
         //This command is use to close the current window of the browser, if it’s the last window it will close the browser.
        driver.close();
//------------------------------------------------------------------------------------------------------
        //This command is use to quit the browser and all the opened windows in the browser.
        driver.quit();
    }
}
