package Basic;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;

public class WhatsAppMsg {
	
	public static void main(String[] args) throws MalformedURLException, InterruptedException{
		
		DesiredCapabilities dc =new DesiredCapabilities();
		dc.setCapability("appPackage", "com.whatsapp");
		dc.setCapability("appActivity", "com.whatsapp.HomeActivity");
		dc.setCapability("deviceName", "OnePlus 7T");
		dc.setCapability("platformName", "Android");
		dc.setCapability("automationName", "UiAutomator1");
		dc.setCapability("noReset", true);
		
		AndroidDriver<WebElement> ad =new AndroidDriver<WebElement>(new URL("http://0.0.0.0:4723/wd/hub"),dc);
		
		ad.findElementByAccessibilityId("Search").click();
		
		Thread.sleep(2000);
		
		ad.findElementById("com.whatsapp:id/search_src_text").clear();
		
		ad.findElementById("com.whatsapp:id/search_src_text").sendKeys("APPIUM APRIL WD 2020");
		
		Thread.sleep(2000);
		
		ad.findElementById("com.whatsapp:id/contact_row_container").click();
		
		ad.findElementById("com.whatsapp:id/entry").sendKeys("done");
		
		ad.findElementById("com.whatsapp:id/send").click();
		
	}

}
