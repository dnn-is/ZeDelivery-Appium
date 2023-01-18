package br.jp.dandrade.page;

import static br.jp.dandrade.core.DriverFactory.getDriver;

import java.time.Duration;

import br.jp.dandrade.core.BasePage;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

@SuppressWarnings("rawtypes")
public class ProdutoPage extends BasePage {

	public void clicarCincoVezesAddProduto() {
		MobileElement plusButton = getDriver().findElement(MobileBy.AccessibilityId("plus-button"));
		esperar(3000);
		for (int i = 0; i < 5; i++) {
			click(plusButton);
		}
	}

	public void clicarCincoVezesSubProduto() {
		TouchAction action = new TouchAction<>(getDriver());
		MobileElement minusButton = getDriver().findElement(MobileBy.AccessibilityId("plus-button"));
		int startX = minusButton.getLocation().getX();
		int startY = minusButton.getLocation().getY();
		for (int i = 0; i < 5; i++) {
			action.tap(PointOption.point(startX, startY)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(400)))
					.perform();
		}
	}

}
