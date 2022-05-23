import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static java.time.Duration.ofSeconds;

public class SwipeGesture extends Base{
    public static void main (String[] args) throws MalformedURLException {

        AndroidDriver androidDriver = desiredCapabilities();
        androidDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        androidDriver.findElementByXPath("//android.widget.TextView[@text='Views']").click();
        androidDriver.findElementByXPath("//android.widget.TextView[@text='Date Widgets']").click();
        androidDriver.findElementByAndroidUIAutomator("text(\"2. Inline\")").click();

        // abc$xyz --> if className has $ or any special characters in it... it can't be sued as tagName in Xpath
        // Eg : android.widget.RadialTimePickerView$RadialPickerTouchHelper
        // In Xpath, we can skip tagName part or even the attribute-value pair
        androidDriver.findElementByXPath("//*[@content-desc='6']").click();

        TouchAction touchAction = new TouchAction(androidDriver);

        // Swipe --> long press on an element, for a second or two... the move to another specific element

        WebElement firstElement = androidDriver.findElementByXPath("//*[@content-desc='15']");
        WebElement secondElement = androidDriver.findElementByXPath("//*[@content-desc='45']");
        touchAction.longPress(longPressOptions().withElement(element(firstElement)).withDuration(ofSeconds(2))).moveTo(element(secondElement)).release().perform();

        // As part of above code.. time gets changed from 6:15 to 6:45 on radial clock

    }
}
