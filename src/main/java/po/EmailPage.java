package po;

import org.openqa.selenium.By;

public class EmailPage extends AbstractPage{

    private By recipient = By.cssSelector("div.js-compose-field.mail-Bubbles");
    private By subject = By.cssSelector("input.mail-Compose-Field-Input-Controller.js-compose-field.js-editor-tabfocus-prev");
    private By email = By.cssSelector("textarea.cke_editable_themed.cke_contents_ltr");
    private By closeButton = By.xpath("//div[@title='Закрыть']");
    private By sentButton = By.xpath("//span[text() = 'Отправить']");

    public EmailPage writeEmail(String address, String sub, String text){
        driver.findElement(recipient).sendKeys(address);
        driver.findElement(subject).sendKeys(sub);
        driver.findElement(email).sendKeys(text);
        return this;
    }

    public EmailPopup closeEmail(){
        waitForElementVisible(closeButton);
        driver.findElements(closeButton).get(0).click();
        return new EmailPopup();
    }

    public void sentEmail(){
        waitForElementVisible(sentButton);
        driver.findElements(sentButton).get(0).click();
    }

}
