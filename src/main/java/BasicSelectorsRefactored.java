import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

import java.net.MalformedURLException;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class BasicSelectorsRefactored extends BaseRefactored{
    public static void main (String[] args) throws MalformedURLException {
        AndroidDriver commonAndroidDriver = commonDesiredCapabilities("real"); // operations gets executed on real physical device
        // AndroidDriver commonAndroidDriver = commonDesiredCapabilities("emulator"); // operations gets executed on emulator

        commonAndroidDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        commonAndroidDriver.findElementByXPath("//android.widget.TextView[@text='Preference']").click();

        commonAndroidDriver.findElementByXPath("//android.widget.TextView[@text='3. Preference dependencies']").click();
        commonAndroidDriver.findElementById("android:id/checkbox").click();
        commonAndroidDriver.findElementByXPath("(//android.widget.RelativeLayout)[2]").click();
        commonAndroidDriver.findElementByClassName("android.widget.EditText").sendKeys("Usha Sai");
        List<AndroidElement> buttonElement = commonAndroidDriver.findElementsByClassName("android.widget.Button");
        buttonElement.get(1).click();

    }
}