package page_objects;
import custom_elements.selophane.custom.CustomElementLocatorFactory;
import custom_elements.selophane.factory.api.ElementFactory;
import custom_elements.selophane.widget.CheckBox;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import webdriver_stuff.Configuration;

/**
 * Created by Aliaksandr_Nestsiarovich on 5/26/2016.
 */
public class LoginPage extends BasePage{

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
    private CheckBox loggedInCheckBox;

    public void openPage() {
        driver.get(URL);
    }

    public LoginPage(WebDriver driver) {
        super(driver);
        ElementFactory.initElements(
                new CustomElementLocatorFactory(driver, Configuration.TIMEOUT),
                this);
        this.driver = driver;
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

    public MainPage clickSignIn() {
        signInButton.click();
        waitForJs();
        return new MainPage(driver);
    }

    public void uncheckStayLogged() {
        loggedInCheckBox.uncheck();
    }
}
