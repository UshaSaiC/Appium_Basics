import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

import java.net.MalformedURLException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;

public class DragAndDropGesture extends Base{
    public static void main (String[] args) throws MalformedURLException {

        AndroidDriver androidDriver = desiredCapabilities();
        androidDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        androidDriver.findElementByXPath("//android.widget.TextView[@text='Views']").click();
        androidDriver.findElementByXPath("//android.widget.TextView[@text='Drag and Drop']").click();

        TouchAction touchAction = new TouchAction(androidDriver);

        // drag and drop --> longPress on an element... move it to destination and then release the element

        List<AndroidElement> elements = androidDriver.findElementsByClassName("android.view.View");
        AndroidElement firstElement = elements.get(0);
        AndroidElement secondElement = elements.get(1);

        // touchAction.longPress(longPressOptions().withElement(element(firstElement))).moveTo(element(secondElement)).release().perform();

        // In below line, we haven't used longPressOptions as we don't need any further functionality like wait for duration provided by longPressOptions
        // In such cases, we can directly mention the element where we want to do longPress
        touchAction.longPress(element(firstElement)).moveTo(element(secondElement)).release().perform();

    }
}
