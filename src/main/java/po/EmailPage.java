package po;

import bo.Email;
import org.openqa.selenium.By;
import ru.yandex.qatools.allure.annotations.Step;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import static util.MyLogger.debug;
import static util.MyLogger.info;

public class EmailPage extends AbstractPage{

    private final static String CLASS = AbstractPage.class.getName();
    private By recipient = By.cssSelector("div.js-compose-field.mail-Bubbles");
    private By subject = By.cssSelector("input.mail-Compose-Field-Input-Controller.js-compose-field.js-editor-tabfocus-prev");
    private By email = By.cssSelector("textarea.cke_editable_themed.cke_contents_ltr");
    private By closeButton = By.xpath("//div[@title='Закрыть']");
    private By sentButton = By.xpath("//span[text() = 'Отправить']");

    @Step("Write new email")
    public EmailPage writeEmail(Email content){
        info(CLASS + ": Write email with following content: recipient:" + content.getRecipient() + " , subject: " + content.getSubject() + ", " +
                "body: " + content.getBody() + "");
        driver.findElement(recipient).sendKeys(content.getRecipient());
        driver.findElement(subject).sendKeys(content.getSubject());
        driver.findElement(email).sendKeys(content.getBody());
        return this;
    }

    @Step("Close email")
    public PopupPage closeEmail(){
        driver.findElements(closeButton).get(0).click();
        return new PopupPage();
    }

    @Step("Assert that email content is right")
    public void checkEmailContent(){
        debug(CLASS + ": recipient is " + driver.findElement(By.cssSelector("span.mail-Bubble-Block_text")).getText());
        assertTrue(driver.findElement(By.cssSelector("span.mail-Bubble-Block_text")).getText().equals("alinaBlazhko") || driver.findElement(recipient).getText().equals("alinaBlazhko@yandex.ru"));
        debug(CLASS + ": subject is " + driver.findElement(subject).getAttribute("value"));
        assertEquals(driver.findElement(subject).getAttribute("value"), "Email for test");
        debug(CLASS + ": body is " + driver.findElement(email).getAttribute("value"));
//        assertEquals(driver.findElement(email).getText(), "Hello Mr. Smith!\n");
    }

    @Step("Send email")
    public void sentEmail(){
        waitForElementVisible(sentButton);
        highlightElement(sentButton);
        driver.findElements(sentButton).get(0).click();
    }

}
