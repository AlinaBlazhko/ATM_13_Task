import org.testng.annotations.AfterTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import po.HomePage;
import po.LoginPage;
import util.AllureAttachmentListener;

import static util.WebDriverSingleton.kill;

@Listeners(AllureAttachmentListener.class)
public class SimpleTest {

    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();

    @Test
    public void loginTest(){
        homePage.open().openLoginPage();
        loginPage.login("alinaBlazhko@yandex.ru", "gfhjkmkzntcnf");
        loginPage.loginSuccessfullyPerfom();
    }

    @AfterTest
    public void after(){
        kill();
    }

}
