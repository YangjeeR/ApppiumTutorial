package newpark;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.StartsActivity;

public class appiumtest17 {
	AppiumDriver<MobileElement> driver;
	String path;
	public void setUp()
	{
		System.out.println("Session is creating");
	
    path=System.getProperty("user.dir");
	 DesiredCapabilities cap=new DesiredCapabilities();
	 cap.setCapability("platformName","Android");
	 cap.setCapability("deviceName","192.168.188.101:5555");
	 cap.setCapability("app",path+"\\app\\ApiDemos.apk");
	 //cap.setCapability("app","C:\\Users\\Acer\\eclipse-workspace\\Appium\\app");
	 try
	 {
	 driver= new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"),cap);
	 
	 }
	 catch(MalformedURLException e)
	 {
		 e.printStackTrace();
	 }
	 driver.manage().timeouts().implicitlyWait(100,TimeUnit.SECONDS);
	 System.out.println("Session is created");
	
}

	public void verifyOTP()
	{
		driver.findElementByAccessibilityId("OS").click();
		driver.findElementByAccessibilityId("SMS Messaging").click();
		driver.findElement(By.id("io.appium.android.apis:id/sms_recipient")).sendKeys("04456");
		driver.findElement(By.id("io.appium.android.apis:id/sms_content")).sendKeys("DEMO OTP: 6549");
		driver.findElement(By.id("io.appium.android.apis:id/sms_send_message")).click();
		String otpvalue=getOTP();
		System.out.println("OPT value:"+otpvalue);
	}
	
	public String getOTP()
	{
		
		((StartsActivity) driver).startActivity("com.android.mms","com.android.mms.ui.ConversationList");
		String getOTPvalue=driver.findElementById("com.android.mms:id/subject").getText().split(":")[1].trim();
		return getOTPvalue;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		appiumtest17 obj=new appiumtest17();
		obj.setUp();
		obj.verifyOTP();

	}

}
