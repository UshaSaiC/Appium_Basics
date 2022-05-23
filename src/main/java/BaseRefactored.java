import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class BaseRefactored {
    public static AndroidDriver commonDesiredCapabilities(String device) throws MalformedURLException {

        DesiredCapabilities commonDesiredCapabilities = new DesiredCapabilities();

        if(device.equals("emulator")){
            commonDesiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "APPIUM_EMULATOR");
        }
        else {
            commonDesiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Device");
        }

        File appDirectory = new File("src");
        File app = new File(appDirectory, "ApiDemos-debug.apk");
        commonDesiredCapabilities.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());

        commonDesiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");

        AndroidDriver commonAndroidDriver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), commonDesiredCapabilities);

        return commonAndroidDriver;
    }
}