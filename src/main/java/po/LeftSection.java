package po;

import org.openqa.selenium.By;

/**
 * Created by X240 on 8/8/2018.
 */
public class LeftSection extends AbstractPage{

    private By drafts = By.xpath("//span[text()='Черновики']");
    private By sents = By.xpath("//span[text()='Отправленные']");
    private By countOfEmails = By.cssSelector(".mail-NestedList-Item_current span.mail-NestedList-Item-Info-Extras");

    public void openDraftFolder(){
        waitForElementVisible(drafts);
        driver.findElement(drafts).click();
    }
    public void openSentFolder(){
        waitForElementVisible(sents);
        driver.findElement(sents).click();
    }

    public boolean rightCountOfEmail(){
        waitForElementVisible(countOfEmails);
        return driver.findElement(countOfEmails).getText().equals("1");
    }
}
