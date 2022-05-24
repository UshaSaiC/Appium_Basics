import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class ChromeBase {
    public static AndroidDriver chromeDesiredCapabilities() throws MalformedURLException {

        DesiredCapabilities chromeDesiredCapabilities = new DesiredCapabilities();

        chromeDesiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "APPIUM_EMULATOR");

        // to run tests on chrome browser
        chromeDesiredCapabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");

        AndroidDriver chromeAndroidDriver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), chromeDesiredCapabilities);

        return chromeAndroidDriver;
    }
}
