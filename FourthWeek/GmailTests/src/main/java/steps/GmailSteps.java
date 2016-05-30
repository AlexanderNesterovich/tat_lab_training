package steps;

import objects.Letter;
import objects.User;
import org.openqa.selenium.WebDriver;
import page_objects.LoginPage;
import page_objects.MainPage;

/**
 * Created by Aliaksandr_Nestsiarovich on 5/25/2016.
 */
public class GmailSteps {

    private WebDriver driver;
    private LoginPage loginPage;
    private MainPage mainPage;

    public GmailSteps(WebDriver driver) {
        this.driver = driver;
    }

    public void login(User firstUser) {
        loginPage.setUserName(firstUser.getUserName());
        loginPage.clickNext();
        loginPage.uncheckStayLogged();
        loginPage.setPasswordField(firstUser.getPassword());
        mainPage = loginPage.clickSignIn();
    }

    public void logout() {
        mainPage.clickLogout();
    }

    public void openLoginPage() {
        loginPage = new LoginPage(driver);
        loginPage.openPage();
    }

    public void sendLetter(Letter letter) {
        mainPage.clickCompose();
        mainPage.setTo(letter.getTo().getUserName());
        mainPage.setSubject(letter.getSubject());
        mainPage.setMessage(letter.getBody());
        mainPage.clickSend();
    }

    public void closeBrowser() {


    }

    public void moveToSpam(Letter letter) {
        mainPage.checkLetter(letter.getSubject(), letter.getBody(), letter.getFrom().getUserName());
        mainPage.markAsSpam();
    }

    public boolean isLetterInSpam(Letter letter) {
        mainPage.openSpamFolder();
        return mainPage.isLetterPresent(letter.getFrom().getUserName(), letter.getSubject(), letter.getBody());
    }
}
