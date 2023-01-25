package br.jp.dandrade.page;

import static br.jp.dandrade.core.DriverFactory.getDriver;

import org.openqa.selenium.By;

import br.jp.dandrade.core.BasePage;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;

public class InicioPage extends BasePage {

	
	public void selecionarPerfil() {
		click(getDriver().findElement(By.xpath("//android.widget.TextView[@text='Perfil']")));
	}
	
	public void selecionarBusca() {
		click(getDriver().findElement(MobileBy.AccessibilityId("Busca")));
	}
	
	
	public void selecionarBrahma() {
		MobileElement brahma = (MobileElement) getDriver().findElement(MobileBy.AndroidUIAutomator(
		        "new UiScrollable(new UiSelector().scrollable(true))" +
		         ".scrollIntoView(new UiSelector().text(\"Brahma Duplo Malte 350ml\"))"));
		click(brahma);
	}
	

}
