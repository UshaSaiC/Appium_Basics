import io.appium.java_client.android.AndroidDriver;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

public class ScrollGesture extends Base{
    public static void main (String[] args) throws MalformedURLException {

        AndroidDriver androidDriver = desiredCapabilities();
        androidDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        androidDriver.findElementByXPath("//android.widget.TextView[@text='Views']").click();

        // In below line, we are scrolling till end of page to find the element ( as WebView3 is the last element on page)
        // androidDriver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"WebView3\"))");

        // In below line, we are scrolling till Radio Group element which is in middle of page.
        // Once the element is visible on UI, directly the scrolling gets stopped
        androidDriver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Radio Group\"))");

    }
}
