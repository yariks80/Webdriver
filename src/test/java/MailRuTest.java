import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

/**
 * Created by my on 01.05.2015.
 */
public class MailRuTest {
    private static final String PASSWORD = "Pa$$word";
    private static final String DOMAIN_PART = "@mail.ua";
    private static final String LOGIN = "ert_a";
    private static final String START_URL = "http://mail.ua";

    private static final String LETTER_SUBJECT = "Demo sending via WebDriver";
    private static final String LETTER_BODY = "New email.";
    private WebDriver driver;

    @BeforeClass(description = "Start browser")
    public void startBrowser() {
        driver = new FirefoxDriver();
        driver.get(START_URL);
    }

    @BeforeClass(dependsOnMethods = "startBrowser", description = "Add implicitly")
    public void addImplicitly() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test(description = "Login to Mail.ru")
    public void loginToMailRu() {
        doLogin(LOGIN, DOMAIN_PART, PASSWORD);
        Assert.assertTrue(isElementPresent(By.id("PH_logoutLink")));
    }

    @Test(description = "Begin new letter creation", dependsOnMethods = { "loginToMailRu" })
    public void beginCreationOfLetter() {
        driver.findElement(By.xpath("//a[@data-name='compose']")).click();
        Assert.assertTrue(driver.getCurrentUrl().contains("compose"));
    }

    @Test(description = "Send new letter", dependsOnMethods = { "beginCreationOfLetter" })
    public void sendNewLetter() {
        sendLetter(LOGIN + DOMAIN_PART, LETTER_SUBJECT, LETTER_BODY);
        Assert.assertTrue(isElementPresent(By.xpath("//div[@class='message-sent__title']")));
    }

    @AfterClass(description = "Stop Browser")
    public void stopBrowser() {
        driver.quit();
    }

    private boolean isElementPresent(By by) {
        return !driver.findElements(by).isEmpty();
    }

    private void doLogin(String login, String domainPart, String password) {

        WebElement loginInput = driver.findElement(By.id("mailbox__login"));
        loginInput.clear();
        loginInput.sendKeys(login);

        Select domainPartSelect = new Select(driver.findElement(By.xpath("//*[@id='mailbox__login__domain']")));
        domainPartSelect.selectByVisibleText(domainPart);

        WebElement passwordInput = driver.findElement(By.id("mailbox__password"));
        passwordInput.clear();
        passwordInput.sendKeys(password);

        driver.findElement(By.id("mailbox__auth__button")).click();
    }

    private void sendLetter(String to, String subject, String body) {
        driver.findElement(By.xpath("//input[@data-original-name='To']")).sendKeys(to);
        driver.findElement(By.name("Subject")).sendKeys(subject);

        // doesn't work ???
         driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@id='compose_330_composeEditor_ifr']")));

        driver.switchTo().frame(3); // WTF Magic!?

        WebElement bodyInput = driver.findElement(By.id("tinymce"));
        bodyInput.clear();
        bodyInput.sendKeys(body);

        driver.switchTo().defaultContent();
        driver.findElement(By.xpath("//div[@data-name='send']/span")).click();
    }

}
