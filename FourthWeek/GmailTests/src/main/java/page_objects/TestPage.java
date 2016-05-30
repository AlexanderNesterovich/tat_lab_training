package page_objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Alexander Nesterovich on 30.05.2016.
 */
public class TestPage extends BasePage{


    WebDriver driver;
    private final String URL = "https://mail.google.com/";

    @FindBy(id = "Email")
    private WebElement emailField;
    @FindBy(id = "Passwd")
    private WebElement passwordField;
    @FindBy(id = "next")
    private WebElement nextButton;
    @FindBy(id = "signIn")
    private WebElement signInButton;
    @FindBy(id = "PersistentCookie")
    private WebElement loggedInCheckBox;

    public TestPage(WebDriver driver) {
        super(driver);
    }

    public void openPage() {
        driver.get(URL);
    }

    public void setUserName(String s) {
        emailField.sendKeys(s);
    }

    public void clickNext() {
        nextButton.click();
    }

    public void setPasswordField(String s) {
        passwordField.sendKeys(s);
    }

    public TestPage2 clickSignIn() {
        signInButton.click();
        return new TestPage2(driver);
    }

    public void uncheckStayLogged() {
        loggedInCheckBox.click();
    }
}
