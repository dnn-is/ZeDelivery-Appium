package br.jp.dandrade.page;

import static br.jp.dandrade.core.DriverFactory.getDriver;

import br.jp.dandrade.core.BasePage;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;

public class BuscaPage extends BasePage {
	
	public void buscarBrahma() {
		escrever(MobileBy.AccessibilityId("search-input"), "Brahma");
	}
	
	public void adicionarBrahma() {
		//product-card-1
		MobileElement brahma = (MobileElement) getDriver().findElement(MobileBy.AndroidUIAutomator(
		        "new UiScrollable(new UiSelector().scrollable(true))" +
		         ".scrollIntoView(new UiSelector().resourceIdMatches(\".*product-card-1.*\"))"));
		click(brahma);
	}
	
}
