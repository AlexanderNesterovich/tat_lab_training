import objects.User;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import page_objects.TestPage;
import page_objects.TestPage2;
import webdriver_stuff.Configuration;

import java.util.concurrent.TimeUnit;

/**
 * Created by Alexander Nesterovich on 30.05.2016.
 */
public class GmailTestTest {

    private User firstUser = new User("potato.labs.first@gmail.com", "nicepotato");
    public static WebDriver driver;
    public static WebDriverWait wait;
    @Test
    public void loginLogout() {
        wait = new WebDriverWait(driver, 3);
        System.setProperty("webdriver.chrome.driver", "C:/tmp/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        TestPage tp = new TestPage(driver);
        tp.openPage();
        tp.setUserName(firstUser.getUserName());
        tp.clickNext();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        tp.uncheckStayLogged();
        tp.setPasswordField(firstUser.getPassword());
        TestPage2 tp2 = tp.clickSignIn();
        tp2.logout();
        tp.openPage();
        tp.setUserName(firstUser.getUserName());
        tp.clickNext();
        tp.setPasswordField(firstUser.getPassword());

    }

}
