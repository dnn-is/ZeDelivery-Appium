package br.jp.dandrade.page;

import static br.jp.dandrade.core.DriverFactory.getDriver;

import java.util.List;

import br.jp.dandrade.core.BasePage;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;

public class PagamentoPage extends BasePage {
	
	public void selecionarCartaoCreditoDebito() {
		waitToBeCliackable(getDriver().findElement(MobileBy.AccessibilityId("payment-method-CREDIT_CARD")));
		click(getDriver().findElement(MobileBy.AccessibilityId("payment-method-CREDIT_CARD")));
		tapElement(getDriver().findElement(MobileBy.AccessibilityId("payment-method-CREDIT_CARD")));
	}
	
	public void selecionarDinheiro() {
		click(getDriver().findElement(MobileBy.AccessibilityId("payment-method-CASH")));
	}
	
	public boolean isCampoTrocoVisible() {
		List<MobileElement> campoTroco = getDriver().findElements(MobileBy.AccessibilityId("change-input"));
		if(campoTroco.size()>0) {
			return true;
		} else {
			return false;
		}
	}
	
	public void selecionarPagamentoOnline() {
		click(getDriver().findElement(MobileBy.AccessibilityId("payment-method-ONLINE_PAYMENT")));
	}
	
	public void selecionarFinalizarCompra() {
		MobileElement finalizarCompra = (MobileElement) getDriver().findElement(MobileBy.AndroidUIAutomator(
		        "new UiScrollable(new UiSelector().scrollable(true))" +
		         ".scrollIntoView(new UiSelector().text(\"FINALIZAR COMPRA\"))"));
		click(finalizarCompra);
	}
	
	public boolean finalizarCompraStatus() {
		MobileElement finalizarCompra = (MobileElement) getDriver().findElement(MobileBy.AndroidUIAutomator(
		        "new UiScrollable(new UiSelector().scrollable(true))" +
		         ".scrollIntoView(new UiSelector().resourceIdMatches(\".*checkout-payment-action-button.*\"))"));


		
		if(finalizarCompra.getAttribute("enabled").equalsIgnoreCase("true")) {
			return true;
		}else {
			return false;
		}
		
		
	}
}
