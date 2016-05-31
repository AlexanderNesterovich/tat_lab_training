package page_object;
import custom_element.selophane.widget.CheckBox;
import custom_element.selophane.widget.TextInput;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Aliaksandr_Nestsiarovich on 5/26/2016.
 */
public class LoginPage extends BasePage{

    private final String URL = "https://mail.google.com/";

    @FindBy(id = "Email")
    private TextInput emailField;
    @FindBy(id = "Passwd")
    private TextInput passwordField;
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
    }

    public void setUserName(String s) {
        emailField.set(s);
    }

    public void clickNext() {
        nextButton.click();
    }

    public void setPasswordField(String s) {
        passwordField.set(s);
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
