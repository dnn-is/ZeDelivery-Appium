package br.jp.dandrade.page;

import static br.jp.dandrade.core.DriverFactory.getDriver;

import java.util.List;

import org.openqa.selenium.By;

import br.jp.dandrade.core.BasePage;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;

public class LoginPage extends BasePage {

	public String isSalvarEmailEnabled() {
		return getDriver().findElement(By.xpath("//android.widget.CheckBox//android.view.ViewGroup"))
				.getAttribute("enabled");
	}

	public void clicarCampoEmail() {
		tapElement(getDriver().findElement(MobileBy.AccessibilityId("E-mail")));
		click(getDriver().findElement(MobileBy.AccessibilityId("E-mail")));
	}

	
	public void preencherEmail() {
		escrever(MobileBy.AccessibilityId("E-mail"), "qualquer");
		
	}

	public void tapSalvarEmail() {
		tapElement(getDriver().findElement(By.xpath("//android.widget.CheckBox//android.view.ViewGroup")));
	}

	public void tapBoasVindas() {
		tapElement(getDriver().findElement(
				By.xpath(("//android.widget.TextView[contains(text(),'Que bom que você está aqui!')]"))));
	}

	public boolean obterMensagemEmailInvalido() {
		List<MobileElement> elementos = getDriver()
				.findElements(By.xpath("//android.widget.TextView[@text='Eita, esse e-mail não parece correto']"));
		if (elementos.size() > 0) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean obterMensagemEmailVazio() {
		List<MobileElement> elementos = getDriver()
				.findElements(By.xpath("//android.widget.TextView[@text='Email não pode ficar vazio']"));
		if (elementos.size() > 0) {
			return true;
		} else {
			return false;
		}
	}


}
