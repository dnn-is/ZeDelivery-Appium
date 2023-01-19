package br.jp.dandrade.page;

import static br.jp.dandrade.core.DriverFactory.getDriver;

import org.openqa.selenium.By;

import br.jp.dandrade.core.BasePage;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;


public class ProdutoPage extends BasePage {

	public void clicarCincoVezesAddProduto() {
		MobileElement plusButton = getDriver().findElement(MobileBy.AccessibilityId("plus-button"));
		esperar(3000);
		for (int i = 0; i < 5; i++) {
			click(plusButton);
		}
	}

	public void clicarCincoVezesSubProduto() {
		MobileElement minusButton = getDriver().findElement(MobileBy.AccessibilityId("minus-button"));
		esperar(3000);
		for (int i = 0; i < 5; i++) {
			click(minusButton);
		}
	}
	
	public void clicarAdd6Unidades() {
		click(getDriver().findElement(MobileBy.AccessibilityId("add-6-units-button")));
	}
	
	public void clicarAdd12Unidades() {
		click(getDriver().findElement(MobileBy.AccessibilityId("add-12-units-button")));
	}
	
	public void clicarAdd15Unidades() {
		click(getDriver().findElement(MobileBy.AccessibilityId("add-15-units-button")));
	}
	
	public String obterQuantidade() {
		MobileElement conteudo = getDriver().findElement(MobileBy.AccessibilityId("add-to-checkout"));
		return conteudo.findElement(By.xpath("//android.widget.TextView[1]")).getText();
	}
	
	public String obterPreco() {
		MobileElement conteudo = getDriver().findElement(MobileBy.AccessibilityId("add-to-checkout"));
		return conteudo.findElement(By.xpath("//android.widget.TextView[2]")).getText();
	}
	
	public void clicarAdicionar() {
		click(getDriver().findElement(MobileBy.AccessibilityId("add-to-checkout")));
	}

}
