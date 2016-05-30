package page_objects;

import custom_elements.factory.api.ElementFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

/**
 * Created by Aliaksandr_Nestsiarovich on 5/25/2016.
 */
public class MainPage extends BasePage {

    @FindBy(xpath = "//div[text()='COMPOSE']")
    private WebElement composeButton;
    @FindBy(name = "to")
    private WebElement toField;
    @FindBy(name = "subjectbox")
    private WebElement subjectField;
    @FindBy(xpath = "//div[@aria-label='Message Body']")
    private WebElement bodyField;
    @FindBy(xpath = "//div[@data-tooltip='Send \u202A(Ctrl-Enter)\u202C']")
    private WebElement sendButton;
    @FindBy(xpath = "//a[contains(@href,'https://accounts.google.com/SignOutOptions')]")
    private WebElement avatarButton;
    @FindBy(xpath = "//a[contains(@href,'https://accounts.google.com/Logout')]")
    private WebElement logoutButton;
    @FindBy(xpath = "//div[@title='Settings']")
    private WebElement settingsButton;
    @FindBy(xpath = "//div[@role='menuitem']//div[text() = 'Settings']")
    private WebElement settingsSubMenu;
    @FindBy(xpath = "//*[@title='Report spam']")
    private WebElement spamButton;
    @FindBy(xpath = "//span[.//text() = 'More'][.//@role='button']")
    private WebElement moreOptionsButton;
    @FindBy(xpath = "//a[contains(@title,'Spam')]")
    private WebElement goToSpamButton;


    public MainPage(WebDriver driver) {
        super(driver);
        ElementFactory.initElements(driver, this);
    }

    public void clickCompose() {
        composeButton.click();
    }

    public void setTo(String s) {
        toField.sendKeys(s);
    }

    public void setSubject(String s) {
        subjectField.sendKeys(s);
    }

    public void setMessage(String s) {
/*        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", bodyField);*/
        bodyField.sendKeys(s);
    }

    public void clickSend() {
        sendButton.click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()='View message']")));
    }

    public void clickLogout() {
        avatarButton.click();
        logoutButton.click();
        alertHandling();
    }

    public void clickSettings() {
        settingsButton.click();
        settingsSubMenu.click();
    }

    public void checkLetter(String subject, String message, String from) {
        //WebElement webElement = driver.findElement(By.xpath("//div[contains(text(),'" + subject + "')]/../div/span[@email='potato.labs.first@gmail.com']/../../..//div[@role='checkbox']"));
        WebElement letter = driver.findElement(By.xpath("//tr[.//text()='" + subject + "'][.//@email='" + from + "']"));
        WebElement checkBox = letter.findElement(By.xpath(".//*[@role='checkbox']"));
        //tr[.//text()='subject'][.//@email='potato.labs.first@gmail.com'][.//text()=' - message12312312']
        checkBox.click();
        //tr[.//text()=' - something something'][.//@email='potato.labs.first@gmail.com']
    }

    public void markAsSpam() {
        spamButton.click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[contains(.,'The conversation has been marked as spam.')]")));
    }

    public void openSpamFolder() {
        moreOptionsButton.click();
        goToSpamButton.click();
        waitForJs();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()='Delete all spam messages now']")));
    }

    public boolean isLetterPresent(String from, String subject, String body) {
        List<WebElement> letters = driver.findElements(By.xpath(".//div[@role='main']//tr[.//text()='" + subject + "'][.//@email='" + from + "']"));
        if(letters.size() > 0) {
            return true;
        }
        return false;
        //.//div[@role='main']//tr[.//text()='new Subject 2'][.//@email='potato.labs.first@gmail.com']
        //.//div[@role='main']//tr[.//@email='potato.labs.first@gmail.com']
    }
}
