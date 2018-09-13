package po;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.*;

/**
 * Created by X240 on 8/8/2018.
 */
public class CenterPart extends AbstractPage{

    private By checkboxes = By.cssSelector("label.nb-checkbox._nb-small-checkbox-checkbox._init");
    private By deleteButton = By.xpath("//span[text()='Удалить']");
    By email = By.cssSelector("span.js-message-snippet-body");


    private By listOfEmailsInFolder = By.cssSelector("div.mail-MessageSnippet-Content");

    public int countOfDrafts() {
        return driver.findElements(listOfEmailsInFolder).size();
    }

    public void openEmail(){
        driver.findElement(email).click();
    }
    public void openDraftEmail(){
        driver.findElement(listOfEmailsInFolder).click();
    }

    public void deleteAllDraftsFromFolder(){
        List<WebElement> checks = driver.findElements(checkboxes);
        if (!(checks).isEmpty()) {
            for (WebElement check : checks) {
                check.click();
            }
            driver.findElement(deleteButton).click();
        }
    }

}
