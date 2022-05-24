import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

import java.net.MalformedURLException;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Browse extends ChromeBase{
    public static void main (String[] args) throws MalformedURLException {
        AndroidDriver chromeDriver = chromeDesiredCapabilities();

        chromeDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        chromeDriver.get("http://facebook.com");

        chromeDriver.findElementByXPath("//*[@id='u_0_1']/div[1]/div/input").sendKeys("qwerty");
        chromeDriver.findElementByName("pass").sendKeys("12345");
        chromeDriver.findElementByXPath("//button[@value='Log In']").click();

    }
}