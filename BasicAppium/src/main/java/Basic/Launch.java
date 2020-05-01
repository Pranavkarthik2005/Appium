package Basic;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;

public class Launch {
	
	public static void main(String[] args) throws MalformedURLException, InterruptedException{
		
		DesiredCapabilities dc =new DesiredCapabilities();
		dc.setCapability("appPackage", "com.oneplus.mms");
		dc.setCapability("appActivity", "com.android.mms.ui.ConversationList");
		dc.setCapability("deviceName", "OnePlus 7T");
		dc.setCapability("platformName", "Android");
		dc.setCapability("automationName", "UiAutomator1");
		dc.setCapability("noReset", true);
		
		AndroidDriver<WebElement> ad =new AndroidDriver<WebElement>(new URL("http://0.0.0.0:4723/wd/hub"),dc);
		
		ad.findElementByAccessibilityId("Search messages").click();
		
		Thread.sleep(2000);
		
		ad.findElementById("com.oneplus.mms:id/search_edit_frame").sendKeys("mom");
		
		ad.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ListView/android.widget.RelativeLayout[1]").click();
		
		ad.findElementById("com.oneplus.mms:id/compose_message_text").sendKeys("Hi");
		
		ad.findElementById("com.oneplus.mms:id/send_message_button").click();
		
		
	}

}
