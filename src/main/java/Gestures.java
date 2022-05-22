import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;

import java.net.MalformedURLException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;

public class Gestures extends Base{
    public static void main (String[] args) throws MalformedURLException {

        AndroidDriver androidDriver = desiredCapabilities();
        androidDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        androidDriver.findElementByXPath("//android.widget.TextView[@text='Views']").click();

        // Tap --> just a basic touch. Done on actual android device
        // Click --> little press and hold. Done on virtual android device (emulator), where we click via mouse
        // end result of click and tap is same

        TouchAction touchAction = new TouchAction(androidDriver);

        // TapOptions --> used when we want to tap on an element based on the locator
        // PointOption --> used when we want to tap on an element based on the co-ordinates

        WebElement expandableLists = androidDriver.findElementByXPath("//android.widget.TextView[@text='Expandable Lists']");
        touchAction.tap(tapOptions().withElement(element(expandableLists))).perform();
        // after any touch action...  perform() must be called
        // perform is basically used to chain multiple touch action like swipe, long press, double tap... etc all on a go
        // at the end of perform() call only the action command is sent to mobile driver

        // below command is used on tap on an element at a specific co-ordinate position
        // touchAction.tap(tapOptions().withElement(element(expandableLists)).withPosition(positionCoordination));

        androidDriver.findElementByXPath("//android.widget.TextView[@text='1. Custom Adapter']").click();

        WebElement peopleNames = androidDriver.findElementByXPath("//android.widget.TextView[@text='People Names']");
        touchAction.longPress(longPressOptions().withElement(element(peopleNames)).withDuration(Duration.ofSeconds(2))).release().perform();

        androidDriver.findElementByXPath("//android.widget.TextView[@text='Sample menu']").isDisplayed();
        androidDriver.findElementByXPath("//android.widget.TextView[@text='Sample action']").isDisplayed();

    }
}
