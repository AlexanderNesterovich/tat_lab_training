import beans.Letter;
import beans.User;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import step.GmailSteps;
import util.StringRandomizer;
import static org.testng.Assert.*;

/**
 * Created by Aliaksandr_Nestsiarovich on 5/24/2016.
 */
public class GmailTest extends BaseTest{

    private GmailSteps gmailSteps;
    private User firstUser = new User("potato.labs.first@gmail.com", "nicepotato");
    private User secondUser = new User("tomato.labs.second@gmail.com", "nicetomato");
    private Letter firstLetter = new Letter(firstUser, secondUser, StringRandomizer.generateString(5), StringRandomizer.generateString(15));
    private Letter secondLetter = new Letter(firstUser, secondUser, StringRandomizer.generateString(5), StringRandomizer.generateString(15));

    @BeforeClass
    public void stepsInitialize() {
       gmailSteps = new GmailSteps(driver);
    }

    @Test
    public void testGoogleLogin(){
        gmailSteps.openLoginPage();

        gmailSteps.login(firstUser);
        gmailSteps.sendLetter(firstLetter);
        gmailSteps.logout();

        gmailSteps.login(secondUser);
        gmailSteps.moveToSpam(firstLetter);
        gmailSteps.logout();

        gmailSteps.login(firstUser);
        gmailSteps.sendLetter(secondLetter);
        gmailSteps.logout();

        gmailSteps.login(secondUser);
        assertTrue(gmailSteps.isLetterInSpam(secondLetter));
    }

}
