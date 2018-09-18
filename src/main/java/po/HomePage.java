package po;

import org.openqa.selenium.By;
import ru.yandex.qatools.allure.annotations.Step;

import static util.MyLogger.info;

public class HomePage extends AbstractPage{
    private final static String CLASS = AbstractPage.class.getName();
    private By loginButton = By.cssSelector(".HeadBanner-ButtonsWrapper a.HeadBanner-Button-Enter");

    @Step("Open login page")
    public void openLoginPage(){
        waitForElementVisible(loginButton);
        highlightElement(loginButton);
        driver.findElement(loginButton).click();
    }

    @Step("Navigate to https://mail.yandex.ru/")
    public HomePage open() {
        info(CLASS + ": Navigate to https://mail.yandex.ru/");
        driver.get("https://mail.yandex.ru/");
        return this;
    }
}
