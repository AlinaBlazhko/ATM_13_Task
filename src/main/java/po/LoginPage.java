package po;

import org.openqa.selenium.By;
import org.testng.Assert;
import ru.yandex.qatools.allure.annotations.Attachment;
import ru.yandex.qatools.allure.annotations.Step;

import static util.MyLogger.debug;

public class LoginPage extends AbstractPage {

    private final static String CLASS = LoginPage.class.getName();
    private By login = By.name("login");
    private By password = By.name("passwd");
    private By submit = By.cssSelector("span.passport-Button-Text");
    private By errorMessage = By.cssSelector("div.passport-Domik-Form-Error");

    @Step("Perform login")
    public void login(String user, String pwd) {
        debug(CLASS + ": Perform login with username: " + user + " and password: " + pwd);
        waitForElementVisible(login);
        driver.findElement(login).sendKeys(user);
        driver.findElement(password).sendKeys(pwd);
        highlightElement(submit);
        driver.findElement(submit).submit();
    }

    @Step("Assert that login performed successfully")
    public void loginSuccessfullyPerfom() {
        waitForElementVisible(By.cssSelector("span.mail-User-Avatar_header.js-user-picture"));
        Assert.assertTrue(driver.getTitle().contains("Яндекс.Почта"));
    }
}
