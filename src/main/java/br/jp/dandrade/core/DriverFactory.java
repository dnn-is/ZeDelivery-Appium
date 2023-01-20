package br.jp.dandrade.core;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.offset.PointOption;

public class DriverFactory {

	private static AndroidDriver<MobileElement> driver;
	 

	public static AndroidDriver<MobileElement> getDriver() {
		if (driver == null) {
			createDriver();
		}
		return driver;
	}

	public static void killDriver() {
		if (driver != null) {
			driver.quit();
			driver = null;
		}
	}

	private static void createDriver() {

		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
		desiredCapabilities.setCapability("platformName", "Android");
		desiredCapabilities.setCapability("deviceName", "emulator-5554");
		desiredCapabilities.setCapability("automationName", "uiautomator2");
		desiredCapabilities.setCapability("appPackage", "com.cerveceriamodelo.modelonow");
		desiredCapabilities.setCapability("appActivity", "com.cerveceriamodelo.modelonow.MainActivity");
		desiredCapabilities.setCapability("ensureWebviewsHavePages", true);

		try {
			driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), desiredCapabilities);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver, 50);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//android.widget.RelativeLayout//android.widget.ImageView"))));
		new TouchAction<>(driver).tap(PointOption.point(new Point(537, 971))).perform();
		
		MobileElement time = (MobileElement) driver.findElement(MobileBy.AndroidUIAutomator(
		        "new UiScrollable(new UiSelector().scrollable(true))" +
		         ".scrollIntoView(new UiSelector().text(\"Fluminense\"))"));
		time.click();
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//android.widget.RelativeLayout//android.widget.ImageView"))));
		new TouchAction<>(driver).tap(PointOption.point(new Point(525, 1114))).perform();
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("com.android.permissioncontroller:id/permission_deny_button"))));
		driver.findElement(By.id("com.android.permissioncontroller:id/permission_deny_button")).click();
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//android.widget.TextView[@text='ENTENDI']"))));
		driver.findElement(By.xpath("//android.widget.TextView[@text='ENTENDI']")).click();

	}

}
