import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.WebElement;

import java.net.MalformedURLException;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Basics extends Base{
    public static void main (String[] args) throws MalformedURLException {
        AndroidDriver androidDriver = desiredCapabilities();

        androidDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        // In android, we can find elements mostly from id, className, xpath, androidUIAutomator.. remaining locators also works but aren't consistent

        // XPATH
        // all the code is written in XML, xpath can read the XML and point to specific location
        // Syntax : //tagName[@attribute='value']
        // attribute - on UIautomator view, when an element is selected we see index, text resource-id, etc., all these fields are attributes
        // index, text resource-id, class, package ---> core-attributes
        // In web, tagNames are <someValue>.. someValue enclosed in angular brackets
        // In Android, class name is tagName

        androidDriver.findElementByXPath("//android.widget.TextView[@text='Preference']").click();

        // When xpath has n elements returned for the specified location... then 1st element would be returned. So argument should be uniquely identified

        androidDriver.findElementByXPath("//android.widget.TextView[@text='3. Preference dependencies']").click();
        // androidDriver.findElementByXPath("//android.widget.CheckBox").click(); // if tagName is unique in itself, no need of attributes in xpath
        androidDriver.findElementById("android:id/checkbox").click(); // using resource id to find the element
        // androidDriver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        androidDriver.findElementByXPath("(//android.widget.RelativeLayout)[2]").click(); // if particular xpath returns n elements,
        // we can enclose it in brackets followed by the index number... stating to select particular nth element not the 1 (first) default value.
        // Element index starts from 1
        // androidDriver.findElementByXPath("//android.widget.EditText").sendKeys("Usha Sai");
        // androidDriver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        androidDriver.findElementByClassName("android.widget.EditText").sendKeys("Usha Sai"); // finding element by className directly (FYI, className ~== tagName)
        // androidDriver.findElementByXPath("//android.widget.Button[@text='OK']").click();
        List<AndroidElement> buttonElement = androidDriver.findElementsByClassName("android.widget.Button");
        buttonElement.get(1).click(); // multiple elements returned from a class name, then we can get the required element by get of index
        // List of elements index start from 0 (zero)

    }
}
