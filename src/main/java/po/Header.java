package po;

import org.openqa.selenium.By;


public class Header extends AbstractPage{
    private By writeNewEmailButton = By.cssSelector("span.mail-ComposeButton-Text");
    private By refreshButton = By.cssSelector("span[title='Проверить, есть ли новые письма (F9)']");


    public void openNewEmail(){
        driver.findElement(writeNewEmailButton).click();
    }
    public void refreshPage(){
        driver.findElement(refreshButton).click();
    }
}
