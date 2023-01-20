package Appium;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class Appium03 {

    @Test
    public void test() throws MalformedURLException {

        DesiredCapabilities capabilities = new DesiredCapabilities();

        //capabilities.setCapability("platformName","Android");
        //capabilities.setCapability(CapabilityType.PLATFORM_NAME,"Andrid");

        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "13");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554"); // deviceName Andrid'te onemli degil
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME,"UiAutomator2");
        //capabilities.setCapability(MobileCapabilityType.APP, "C:\\Users\\ahmee\\IdeaProjects\\Mobile_Testing_Appium\\src\\Apps\\gestureTool.apk");
        capabilities.setCapability("appPackage","com.davemac327.gesture.tool");
        capabilities.setCapability("appActivity","com.davemac327.gesture.tool.GestureBuilderActivity");
        capabilities.setCapability(MobileCapabilityType.NO_RESET, true);

        capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "60");

        AndroidDriver<MobileElement> driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

        System.out.println("App yuklendi");

        MobileElement homePageTitle = driver.findElementById("android:id/title");
        Assert.assertEquals(homePageTitle.getText(),"Gesture Tool");
        System.out.println("Ana sayfa acildi");

        MobileElement testButton = driver.findElementById("com.davemac327.gesture.tool:id/testButton");
        testButton.click();
        System.out.println("Test Butonu calisiyor");

        MobileElement gestureTitle = driver.findElementById("android:id/title");
        //Assert.assertEquals(gestureTitle.getText(),"Test a gesture");

        System.out.println("Test screen acildi...");

    }
}
