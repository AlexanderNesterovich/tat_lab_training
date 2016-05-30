package page_objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Alexander Nesterovich on 30.05.2016.
 */
public class TestPage2 extends BasePage{


    WebDriver driver;

    @FindBy(xpath = "//a[contains(@href,'https://accounts.google.com/SignOutOptions')]")
    private WebElement avatarButton;
    @FindBy(xpath = "//a[contains(@href,'https://accounts.google.com/Logout')]")
    private WebElement logoutButton;

    public TestPage2(WebDriver driver) {
        super(driver);
    }

    public void logout(){
        avatarButton.click();
        logoutButton.click();
    }

}
