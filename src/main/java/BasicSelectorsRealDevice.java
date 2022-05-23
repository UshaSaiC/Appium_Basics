import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

import java.net.MalformedURLException;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class BasicSelectorsRealDevice extends RealDeviceBase{
    public static void main (String[] args) throws MalformedURLException {
        AndroidDriver realDeviceAndroidDriver = realDeviceDesiredCapabilities();

        realDeviceAndroidDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        realDeviceAndroidDriver.findElementByXPath("//android.widget.TextView[@text='Preference']").click();

        realDeviceAndroidDriver.findElementByXPath("//android.widget.TextView[@text='3. Preference dependencies']").click();
        realDeviceAndroidDriver.findElementById("android:id/checkbox").click();
        realDeviceAndroidDriver.findElementByXPath("(//android.widget.RelativeLayout)[2]").click();
        realDeviceAndroidDriver.findElementByClassName("android.widget.EditText").sendKeys("Usha Sai");
        List<AndroidElement> buttonElement = realDeviceAndroidDriver.findElementsByClassName("android.widget.Button");
        buttonElement.get(1).click();

    }
}
