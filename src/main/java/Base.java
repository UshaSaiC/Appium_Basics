import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class Base {
    public static void main(String[] args) throws MalformedURLException {

        // In Selenium, the process to automate -
        // Will need driver instantiated, URL (where to perform action), certain commands wrt actions and assertions

        // In Appium, the process to automate -
        //   - Will need to configure app (as there are n number of apps on device)... will need .apk file,
        //   - Device name (n number of devices can be started parallely),
        //   - Certain commands wrt actions and assertions,
        //   - Redirection to 4723 (appium server) port

        // So to set above things, we use class called Desired Capabilities

        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();

        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "APPIUM_EMULATOR"); // emulator when created, the name given to it

        File appDirectory = new File("src"); // It contains parent folder information. Later on, even if we change the folder path, we just need to update this variable
        File app = new File(appDirectory, "ApiDemos-debug.apk"); // It needs parent folders info and file name
        desiredCapabilities.setCapability(MobileCapabilityType.APP, app.getAbsolutePath()); // app to be automated... its location

        // Google invented android and alongside UIAutomator testing framework for automating android apps
        // Core engine developed from UIAutomator is uiautomator2... so when we want our automation script to work on android apps,
        // this uiautomator2 acts as middleware

        desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");

        AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), desiredCapabilities);
        // driver gets activated with all the capabilities and the URL is configured as appium server listens on 4723 port
        // so that driver can route to that port;
        //wd ---> webdriver (in URL)
    }
}
