package BrowserFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

/**
 * Created by HOME on 03.11.2015.
 */
public enum Browsers {
    CHROME {
        public WebDriver create(){
            return new ChromeDriver();
        }
    },
    IE {
        public WebDriver create(){
            return new InternetExplorerDriver();
        }
    },
    FIREFOX {
        public WebDriver create() {
            return new FirefoxDriver();
        }
    };

    public WebDriver create(){
        return null;
    }
}

class Test {
    public static void main(String[] args) {
        WebDriver driver = Browsers.FIREFOX.create();
    }
}
