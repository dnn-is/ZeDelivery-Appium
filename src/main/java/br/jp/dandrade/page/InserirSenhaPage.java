package br.jp.dandrade.page;

import static br.jp.dandrade.core.DriverFactory.getDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.jp.dandrade.core.BasePage;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;

public class InserirSenhaPage extends BasePage {

	public String obterMensagemCampoSenhaVazio() {
		MobileElement campoSenha = getDriver().findElement(By.xpath(
				"//android.widget.EditText//following-sibling::android.view.ViewGroup//android.widget.TextView[1]"));
		return campoSenha.getText();
	}

	public boolean mensagemSenhaIncorreta() {
		WebDriverWait wait = new WebDriverWait(getDriver(), 10);

		try {
			wait.until(ExpectedConditions.visibilityOf(
					getDriver().findElement(By.xpath("//android.widget.TextView[@text='Senha incorreta']"))));
		} catch (NoSuchElementException e) {
			return false;
		}

		return true;
	}

	public void clicarCampoSenha() {
		tapElement(getDriver().findElement(MobileBy.AccessibilityId("Senha")));
		click(getDriver().findElement(MobileBy.AccessibilityId("Senha")));
	}

	public void fornecerSenhaIncorreta() {
		String senha = "qualquer";
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.EditText")));
		escrever(By.xpath("//android.widget.EditText"), senha);
		click(getDriver().findElement(By.xpath("//android.widget.TextView[@text='ENTRAR NA CONTA']")));
	}

	// Senha incorreta

}
