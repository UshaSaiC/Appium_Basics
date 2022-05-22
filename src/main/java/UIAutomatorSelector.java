import io.appium.java_client.android.AndroidDriver;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

public class UIAutomatorSelector extends Base{
    public static void main (String[] args) throws MalformedURLException {

        AndroidDriver androidDriver = desiredCapabilities();
        androidDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        // UIAUTOMATOR
        // Syntax : attribute("value")

        androidDriver.findElementByAndroidUIAutomator("text(\"Views\")").click();

        // validating clickable feature for all the options
        // clickable is a property not an attribute
        // Syntax : new UiSelector().property(value)

        int numberOfOptionsInViews = androidDriver.findElementsByAndroidUIAutomator("new UiSelector().clickable(false)").size();
        System.out.println("Number of elements clickable in Views page are : " + numberOfOptionsInViews);

    }
}

