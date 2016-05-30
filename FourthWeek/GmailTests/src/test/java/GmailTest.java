import Utils.StringRandomizer;
import objects.Letter;
import objects.User;
import org.testng.Assert;
import org.testng.annotations.Test;
import steps.GmailSteps;

/**
 * Created by Aliaksandr_Nestsiarovich on 5/24/2016.
 */
public class GmailTest extends BaseTest{

    private GmailSteps steps = new GmailSteps(driver);
    private User firstUser = new User("potato.labs.first@gmail.com", "nicepotato");
    private User secondUser = new User("tomato.labs.second@gmail.com", "nicetomato");
    private Letter firstLetter = new Letter(firstUser, secondUser, StringRandomizer.generateString(5), StringRandomizer.generateString(15));
    private Letter secondLetter = new Letter(firstUser, secondUser, StringRandomizer.generateString(5), StringRandomizer.generateString(15));
    /*@Test
    public void testGoogleSearch(){
        page.visit();
        page.search("Selenium");
        assertThat(listNthElementHasText(page.results, 0, "Then you want to use Selenium WebDriver"));
        assertThat(textIn(page.resultsStats, "26,200,000"));
    }*/


    @Test
    public void testGoogleLogin(){
        steps.openLoginPage();
        steps.login(firstUser);
        steps.sendLetter(firstLetter);
        steps.logout();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        steps.login(secondUser);
        steps.moveToSpam(firstLetter);
        steps.logout();

        steps.login(firstUser);
        steps.sendLetter(secondLetter);
        steps.logout();

        steps.login(secondUser);
        Assert.assertTrue(steps.isLetterInSpam(secondLetter));
    }

}
