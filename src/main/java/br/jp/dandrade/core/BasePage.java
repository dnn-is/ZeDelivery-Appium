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
	public WebDriverWait wait = new WebDriverWait(getDriver(), 10);

	public void escrever(By by, String texto) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(by));
		getDriver().findElement(by).sendKeys(texto);
	}
	
	public void escreverPorElemento(MobileElement element, String texto){
		element.sendKeys(texto);
	}
	
	public void esperar(int tempo) {
		try {
			Thread.sleep(tempo);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void tap(int x, int y) {
		new TouchAction<>(getDriver()).tap(TapOptions.tapOptions().withPosition(PointOption.point(new Point(x, y))))
				.perform();
	}

	public void tapElement(MobileElement element) {
		wait.until(ExpectedConditions.visibilityOf(element));
		new TouchAction<>(getDriver()).tap(TapOptions.tapOptions().withElement(ElementOption.element(element)))
				.perform();
	}
	
	public void waitToBeCliackable(MobileElement element) {
		wait.until(ExpectedConditions.attributeContains(element, "clickable", "true"));
	}
	
	public void waiToBeVisible(MobileElement element) {
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public void click(MobileElement element) {
		wait.until(ExpectedConditions.elementToBeClickable(element));
		element.click();
	}
	



}
