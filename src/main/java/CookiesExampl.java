import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Set;

/**
 * Created by my on 01.05.2015.
 */
public class CookiesExampl {
    private static WebDriver driver = null;
    public static void main(String[] args) {
        driver = new FirefoxDriver();

        driver.get("http://www.google.com");

       Cookie cookie = new Cookie("key", "value");
        driver.manage().addCookie(cookie);

// ������� ��� ���� ��������� ��� �������� URL
        Set<Cookie> allCookies = driver.manage().getCookies();
        for (Cookie loadedCookie : allCookies) {
            System.out.println(String.format("%s -> %s", loadedCookie.getName(), loadedCookie.getValue()));
        }

// ������� ���� ����� 3 ���������
// ��������� ���
        driver.manage().deleteCookieNamed("CookieName");
// ��������� ������ Cookie
       // driver.manage().deleteCookie(loadedCookie);
// ��� ��� �����
       // driver.manage().deleteAllCookies();
        driver.quit();
    }

}
