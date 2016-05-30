import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.CollectionCondition.sizeGreaterThanOrEqual;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by Alexander Nesterovich on 26.05.2016.
 */
public class SimpleTest {


    @Test
    public void simpleTest() throws InterruptedException {
/*        System.setProperty("webdriver.chrome.driver", "C:/chromedriver.exe");
        System.setProperty("selenide.browser", "Chrome");
        open("https://mail.google.com");
        for (SelenideElement link : $$(By.id("Email"))) {
            System.out.println(link);
        }
        $(By.id("Email")).sendKeys("potato.labs.first");
        $(By.id("next")).click();
        $(By.id("Passwd")).sendKeys("nicepotato");
        $(By.id("signIn")).click();
        List<String> links = new ArrayList<>();

        System.out.println("--------------------");
        for (SelenideElement link : $$(By.xpath("//div[@data-tooltip]"))) {
            System.out.println(link);
        }
        System.out.println("--------------------");

        $(By.id("signIn")).click();*/

// navigate to each Link on the webpage

        //$(By.xpath("//*[@aria-label='Settings']")).;


        System.setProperty("webdriver.chrome.driver", "C:/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(10, TimeUnit.SECONDS);
        driver.get("https://mail.google.com");

        driver.findElement(By.id("Email")).sendKeys("potato.labs.first");
        driver.findElement(By.id("next")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("PersistentCookie")).click();
        driver.findElement(By.id("Passwd")).sendKeys("nicepotato");
        driver.findElement(By.id("signIn")).click();
        WebElement element = driver.findElement(By.xpath("//div[@title='Settings']"));
        System.out.println(element.getAttribute("innerHTML"));
        Thread.sleep(10000);
        element.click();

    }
}
