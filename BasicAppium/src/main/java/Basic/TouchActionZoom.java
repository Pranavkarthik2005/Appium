package Basic;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class TouchActionZoom {
	public static void main(String[] args) throws MalformedURLException {
		DesiredCapabilities dc =new DesiredCapabilities();
		dc.setCapability("appPackage", "com.the511plus.MultiTouchTester");
		dc.setCapability("appActivity", "com.the511plus.MultiTouchTester.MultiTouchTester");
		dc.setCapability("deviceName", "OnePlus 7T");
		dc.setCapability("platformName", "Android");
		dc.setCapability("automationName", "UiAutomator1");
		dc.setCapability("noReset", true);
		
		AndroidDriver<WebElement> ad =new AndroidDriver<WebElement>(new URL("http://0.0.0.0:4723/wd/hub"),dc);
		
		Dimension dim = ad.manage().window().getSize();
		
		int startX = (int) (dim.getWidth()*0.5);
		int endX = (int) (dim.getWidth()*0.5);
		
		int startY = (int) (dim.getHeight()*0.8);
		int endY = (int)(dim.getHeight()*0.2);
		
		TouchAction<?> touchAction = new TouchAction(ad).press(PointOption.point(startX, startY))
				.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(5)))
				.moveTo(PointOption.point(endX,endY))
				.release().perform();
		
	}
}

