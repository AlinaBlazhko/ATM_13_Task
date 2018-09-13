package po;

import org.openqa.selenium.By;
import ru.yandex.qatools.allure.annotations.Step;

public class HomePage extends AbstractPage{

    private By loginButton = By.cssSelector(".HeadBanner-ButtonsWrapper a.HeadBanner-Button-Enter");

    @Step("Open login page")
    public void openLoginPage(){
        waitForElementVisible(loginButton);
        driver.findElement(loginButton).click();
    }

    public HomePage open() {
        logger.info("Navigate to https://mail.yandex.ru/");
        driver.get("https://mail.yandex.ru/");
        return this;
    }
}
