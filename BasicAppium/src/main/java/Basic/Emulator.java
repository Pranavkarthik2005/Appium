package Basic;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;

public class Emulator {
	
	public static void main(String[] args) throws MalformedURLException, InterruptedException{
		
		DesiredCapabilities dc =new DesiredCapabilities();
		dc.setCapability("appPackage", "com.google.android.apps.messaging");
		dc.setCapability("appActivity", "com.google.android.apps.messaging.ui.ConversationListActivity");
		dc.setCapability("deviceName", "One Plus 7T");
		dc.setCapability("platformName", "Android");
		dc.setCapability("platformVersion", "9.0");
		dc.setCapability("automationName", "UiAutomator1");
		dc.setCapability("noReset", true);
		
		AndroidDriver<WebElement> ad =new AndroidDriver<WebElement>(new URL("http://0.0.0.0:4723/wd/hub"),dc);
		
		ad.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		ad.findElementById("com.google.android.apps.messaging:id/action_search").click();
		
		Thread.sleep(2000);
		
		ad.findElementById("com.google.android.apps.messaging:id/search_src_text").clear();
		
		Thread.sleep(2000);
		
		ad.findElementById("com.google.android.apps.messaging:id/search_src_text").sendKeys("APPIUM APRIL WD 2020");
	}

}
