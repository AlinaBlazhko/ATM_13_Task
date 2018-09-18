import bo.Email;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import po.*;
import util.AllureAttachmentListener;

import static util.WebDriverSingleton.kill;

@Listeners(AllureAttachmentListener.class)
public class SimpleTest {

    private HomePage homePage;
    private LoginPage loginPage;
    private Header header;
    private EmailPage emailPage;
    private PopupPage popupPage;
    private LeftSection leftSection;
    private CenterPart centerPart;

    @BeforeTest
    public void setUp(){
        homePage = new HomePage();
        loginPage = new LoginPage();
        header = new Header();
        emailPage = new EmailPage();
        popupPage = new PopupPage();
        leftSection = new LeftSection();
        centerPart = new CenterPart();
    }

    @Test
    public void loginTest(){
        homePage.open().openLoginPage();
        loginPage.login("alinaBlazhko@yandex.ru", "gfhjkmkzntcnf");
        loginPage.loginSuccessfullyPerfom();
    }
    @Test(dependsOnMethods = "loginTest")
    public void writeNewEmailTestAndSaveAsDraft() {
        header.openNewEmail();
        emailPage.writeEmail(new Email("alinaBlazhko@yandex.ru", "Email for test", "Hello Mr. Smith!"));
        emailPage.closeEmail();
        popupPage.closeAndSaveEmail();

        leftSection.openDraftFolder();
        header.refreshPage();
        leftSection.rightCountOfEmail();
    }

    @Test(dependsOnMethods = "writeNewEmailTestAndSaveAsDraft")
    public void sentEmailAndVerifyThatEmailIsSent() {
        centerPart.openEmail();
        emailPage.checkEmailContent();
    }


    @Test(dependsOnMethods = "sentEmailAndVerifyThatEmailIsSent")
    public void sendingEmailFromDraft(){
        emailPage.sentEmail();
        leftSection.openSentFolder();
        header.refreshPage();
        leftSection.rightCountOfEmail();
    }

    @AfterTest
    public void after(){
        centerPart.deleteAllFromFolder();
        leftSection.openDraftFolder();
        centerPart.deleteAllFromFolder();
        kill();
    }
}
