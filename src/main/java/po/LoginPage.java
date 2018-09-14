package po;

import org.openqa.selenium.By;
import org.testng.Assert;
import ru.yandex.qatools.allure.annotations.Attachment;
import ru.yandex.qatools.allure.annotations.Step;

public class LoginPage extends AbstractPage{

    private By login = By.name("login");
    private By password = By.name("passwd");
    private By submit = By.cssSelector("span.passport-Button-Text");
    private By errorMessage = By.cssSelector("div.passport-Domik-Form-Error");

   @Attachment
   @Step("Perform login")
   public void login(String user, String pwd){
       waitForElementVisible(login);
       driver.findElement(login).sendKeys(user);
       driver.findElement(password).sendKeys(pwd);
       driver.findElement(submit).click();
   }

    public boolean isTitleRight(){
       waitForElementVisible(By.cssSelector("span.mail-User-Avatar_header.js-user-picture"));
       return driver.getTitle().contains("Входящие");
    }

    public boolean isErrorMessageCorrect(String message){
        waitForElementVisible(errorMessage);
        return driver.findElement(errorMessage).getText().equals(message);
    }

    @Step
    public void loginSuccessfullyPerfom(){
        waitForElementVisible(By.cssSelector("span.mail-User-Avatar_header.js-user-picture"));
        Assert.assertTrue(driver.getTitle().contains("Входящие"));
    }
}
