package br.jp.dandrade.page;

import static br.jp.dandrade.core.DriverFactory.getDriver;

import org.openqa.selenium.By;

import br.jp.dandrade.core.BasePage;

public class InicioPage extends BasePage {

	
	public void selecionarPerfil() {
		click(getDriver().findElement(By.xpath("//android.widget.TextView[@text='Perfil']")));
	}

}
