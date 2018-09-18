package util;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriverException;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;
import ru.yandex.qatools.allure.annotations.Attachment;

import static util.MyLogger.error;
import static util.MyLogger.info;


public class AllureAttachmentListener extends TestListenerAdapter{

    private final static String CLASS = AllureAttachmentListener.class.getName();

    @Attachment(value = "Attachment: {0}", type = "image/png")
    public byte[] makeScreenshot() {
        byte[] array = {1};
        try {
            return ((TakesScreenshot)WebDriverSingleton.getWebDriverInstance()).getScreenshotAs(OutputType.BYTES);
        } catch (WebDriverException e){
            error(CLASS + ": Screenshot was not created" , e);
            e.printStackTrace();
        }
        return array;
    }

    @Override
    public void onTestFailure(ITestResult tr) {
        error(CLASS + ": Test failed :( Please look at screenshot in /target/allure-results/ package");
        makeScreenshot();
    }


    @Override
    public void onTestSuccess(ITestResult tr){
        info(CLASS + ": Test finished success :)");
    }
}