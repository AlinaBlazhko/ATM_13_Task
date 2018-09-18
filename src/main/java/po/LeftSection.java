package po;

import org.openqa.selenium.By;
import org.testng.Assert;
import ru.yandex.qatools.allure.annotations.Step;

import static util.MyLogger.debug;
import static util.MyLogger.info;

/**
 * Created by X240 on 8/8/2018.
 */
public class LeftSection extends AbstractPage{

    private final static String CLASS = AbstractPage.class.getName();
    private By drafts = By.xpath("//span[text()='Черновики']");
    private By sents = By.xpath("//span[text()='Отправленные']");
    private By countOfEmails = By.cssSelector(".mail-NestedList-Item_current span.mail-NestedList-Item-Info-Extras");

    @Step("Open draft folder")
    public void openDraftFolder(){
        waitForElementVisible(drafts);
        highlightElement(drafts);
        driver.findElement(drafts).click();
    }

    @Step("Open sents folder")
    public void openSentFolder(){
        waitForElementVisible(sents);
        highlightElement(sents);
        driver.findElement(sents).click();
    }

    @Step("Assert that there is right count of folder")
    public void rightCountOfEmail(){
        waitForElementVisible(countOfEmails);
        debug(CLASS + ": Count of emails in folder equals: " + driver.findElement(countOfEmails).getText());
        Assert.assertEquals(driver.findElement(countOfEmails).getText(), "1");
    }
}
