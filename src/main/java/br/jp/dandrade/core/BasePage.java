package br.jp.dandrade.core;

import static br.jp.dandrade.core.DriverFactory.getDriver;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;

public class BasePage {
	public WebDriverWait wait = new WebDriverWait(getDriver(), 10);

	public void escrever(By by, String texto) {

		getDriver().findElement(by).sendKeys(texto);
	}
	
	public void escreverPorElemento(MobileElement element, String texto){
		element.sendKeys(texto);
	}
	
	public void esperar() {
		try {
			Thread.sleep(5000);
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

	public void click(MobileElement element) {
		wait.until(ExpectedConditions.elementToBeClickable(element));
		element.click();
	}
	

	@SuppressWarnings("rawtypes")
	public void scroll(double inicio, double fim) {
		Dimension size = getDriver().manage().window().getSize();
		int x = size.width / 2;
		int start_y = (int) (size.height * inicio);
		int end_y = (int) (size.height * fim);

		TouchAction action = new TouchAction(getDriver());
		action.press(PointOption.point(new Point(x, start_y))).waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
				.moveTo(PointOption.point(new Point(x, end_y))).release().perform();
	}

	public void scrollUp() {
		scroll(0.7, 0.1);
	}

}
