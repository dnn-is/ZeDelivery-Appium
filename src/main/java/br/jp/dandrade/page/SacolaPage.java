package br.jp.dandrade.page;

import static br.jp.dandrade.core.DriverFactory.getDriver;

import java.util.List;

import br.jp.dandrade.core.BasePage;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;

public class SacolaPage extends BasePage {

	public void clicarVerSacola() {
		click(getDriver().findElement(MobileBy.AccessibilityId("place-an-order")));
	}

	public void selecionarFormaPagamento() {
		waiToBeVisible(getDriver().findElement(MobileBy.AccessibilityId("delete-product")));
		MobileElement formaDePagamento = (MobileElement) getDriver()
				.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true))"
						+ ".scrollIntoView(new UiSelector().resourceIdMatches(\".*checkout-action-button.*\"))"));
		click(formaDePagamento);
	}

	public void alterarQuantidade() {
		waiToBeVisible(getDriver().findElement(MobileBy.AccessibilityId("delete-product")));
		for(int i = 1;i<5;i++) {
			click(getDriver().findElement(MobileBy.AccessibilityId("plus-button")));
			esperar(2500);
		}
		

	}

	public void removerProduto() {
		esperar(4000);
		click(getDriver().findElement(MobileBy.AccessibilityId("delete-product")));
		waiToBeVisible(getDriver().findElement(MobileBy.AccessibilityId("remove-product-modal-action-button")));
		click(getDriver().findElement(MobileBy.AccessibilityId("remove-product-modal-action-button")));
	}

	public boolean isSacolaVazia() {
		List<MobileElement> continuarComprando = getDriver()
				.findElements(MobileBy.AccessibilityId("button-keep-buying"));

		if (continuarComprando.size() > 0) {
			return true;
		} else {
			return false;
		}
	}

}
