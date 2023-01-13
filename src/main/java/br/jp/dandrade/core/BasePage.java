package br.jp.dandrade.core;

import static br.jp.dandrade.core.DriverFactory.getDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;


public class BasePage {
	private WebDriverWait wait = new WebDriverWait(getDriver(), 10);

	public void escrever(By by, String texto) {
		
		getDriver().findElement(by).sendKeys(texto);
	}

	public void tap(int x, int y) {
		new TouchAction<>(getDriver()).tap(TapOptions.tapOptions().withPosition(PointOption.point(new Point(x, y)))).perform();
	}
	
	public void tapElement(MobileElement element) {
		wait.until(ExpectedConditions.visibilityOf(element));
		new TouchAction<>(getDriver()).tap(TapOptions.tapOptions().withElement(ElementOption.element(element))).perform();
	}
	
	public void click(MobileElement element) {
		wait.until(ExpectedConditions.visibilityOf(element));
		element.click();
	}

}
