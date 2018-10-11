package newpark;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class appiumtest13 {
	AppiumDriver<MobileElement> driver;
	String path;
	public void setUp()
	{
		System.out.println("Session is creating");
		
	     path=System.getProperty("user.dir");
		 DesiredCapabilities cap=new DesiredCapabilities();
		 cap.setCapability("platformName","Android");
		 cap.setCapability("platformVersion", "7.1.1");
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
	

	
	public void clickTab()
	{
		boolean flag=false;
		driver.findElementByAccessibilityId("Views").click();
		
		for(int i=0;i<=20;i++)
		{
			try
			{
				driver.manage().timeouts().implicitlyWait(1,TimeUnit.SECONDS);
				driver.findElementByAccessibilityId("Tabs").click();
				driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
				break;
			}
			catch(Exception e)
			{
				verticalSwipe();
			}
			
		}
		
		flag=driver.findElementByAccessibilityId("5. Scrollable").isDisplayed();
		if(flag)
		{
			System.out.println("passed");
		}
		else
		{
			System.out.println("failed");
		}
		driver.findElementByAccessibilityId("5. Scrollable").click();
	}
	
	public void horizontalSwipe() {
		Dimension dim=driver.manage().window().getSize();	
		int height=dim.getHeight();
		int width=dim.getWidth();
		int y=(int)(height*0.20);
		int startx=(int)(width*0.75);
		int endx=(int)(width*0.35);
		driver.swipe(startx, y, endx, y, 500);
	}
	public void verticalSwipe() {
		
		Dimension dim=driver.manage().window().getSize();
		int height=dim.getHeight();
		int width=dim.getWidth();
		int x= width/2;
		int starty=(int)(height*0.80);
		int endy=(int)(height*0.20);
		driver.swipe(x, starty, x, endy, 500);
	}
	
	public void verifyTab28()
	{
		boolean f=false;
		for(int i=1;i<=15;i++)
		{
			try
			{
				driver.manage().timeouts().implicitlyWait(1,TimeUnit.SECONDS);
				f=driver.findElementByXPath("//*[@text='TAB 26']").isDisplayed();
				break;
			}
			catch(Exception e)
			{
				horizontalSwipe();
			}
		}
		if(f)
		{
			System.out.println("Horizontal scroll is working");
		}
		else
		{
			System.out.println("failed");
		}
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		appiumtest13 obj=new appiumtest13();
		obj.setUp();
		obj.clickTab();
		obj.verifyTab28();

	}

}
