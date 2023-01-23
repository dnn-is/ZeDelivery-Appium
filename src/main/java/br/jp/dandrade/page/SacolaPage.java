package br.jp.dandrade.page;

import static br.jp.dandrade.core.DriverFactory.getDriver;

import br.jp.dandrade.core.BasePage;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;

public class SacolaPage extends BasePage {
	
	public void clicarVerSacola() {
		click(getDriver().findElement(MobileBy.AccessibilityId("place-an-order")));
	}
	
	public void selecionarFormaPagamento() {
		waiToBeVisible(getDriver().findElement(MobileBy.AccessibilityId("delete-product")));
		MobileElement formaDePagamento = (MobileElement) getDriver().findElement(MobileBy.AndroidUIAutomator(
		        "new UiScrollable(new UiSelector().scrollable(true))" +
		         ".scrollIntoView(new UiSelector().resourceIdMatches(\".*checkout-action-button.*\"))"));
		click(formaDePagamento);
	}

}
