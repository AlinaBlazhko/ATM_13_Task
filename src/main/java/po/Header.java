package po;

import org.openqa.selenium.By;
import ru.yandex.qatools.allure.annotations.Step;

import static util.MyLogger.info;


public class Header extends AbstractPage{
    private final static  String CLASS = AbstractPage.class.getName();
    private By writeNewEmailButton = By.cssSelector("span.mail-ComposeButton-Text");
    private By refreshButton = By.cssSelector("span[title='Проверить, есть ли новые письма (F9)']");


    @Step("Open new email page")
    public void openNewEmail(){
        highlightElement(writeNewEmailButton);
        driver.findElement(writeNewEmailButton).click();
        info(CLASS + ":New email is opened");
    }

    @Step("Refresh page")
    public void refreshPage() {
        waitForElementEnabled(refreshButton);
        highlightElement(refreshButton);
        driver.findElement(refreshButton).click();
        info(CLASS + ": Refresh page");
    }
}
