package po;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.yandex.qatools.allure.annotations.Step;

public class PopupPage extends AbstractPage{

    private By saveAndOpenButton = By.xpath("//span[text()='Сохранить и перейти']");
    private By notSaveButton = By.xpath("//span[text()='Не сохранять']");
    private By cancelButton = By.xpath("//span[text()='Отмена']");

    @Step("Save email as draft")
    public void closeAndSaveEmail(){
        highlightElement(saveAndOpenButton);
        driver.findElement(saveAndOpenButton).click();
    }
}
