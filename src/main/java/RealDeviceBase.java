import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class RealDeviceBase {
    public static AndroidDriver realDeviceDesiredCapabilities() throws MalformedURLException {

        DesiredCapabilities realDeviceDesiredCapabilities = new DesiredCapabilities();

        // if we want to do automation on real physical device... we just need to pass device name as Android Device
        realDeviceDesiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Device");

        File appDirectory = new File("src");
        File app = new File(appDirectory, "ApiDemos-debug.apk");
        realDeviceDesiredCapabilities.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());

        realDeviceDesiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");

        AndroidDriver realDeviceAndroidDriver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), realDeviceDesiredCapabilities);

        return realDeviceAndroidDriver;
    }
}
