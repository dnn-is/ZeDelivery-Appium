package br.jp.dandrade.test;

import org.junit.Assert;
import org.junit.Test;

import br.jp.dandrade.core.BaseTest;
import br.jp.dandrade.page.LoginPage;

public class LoginPageTest extends BaseTest {

	private LoginPage loginPage = new LoginPage();

	@Test
	public void SalvarEmailCheckbox() { //Os atributos não mudam, logo, não tem como confirmar se o checkboxk está ativo.
		Assert.assertEquals("true", loginPage.isSalvarEmailEnabled());
		loginPage.tapSalvarEmail();
		Assert.assertEquals("false", loginPage.isSalvarEmailEnabled());
	}

	@Test
	public void deveVerificarEmailInvalido() {
		loginPage.clicarCampoEmail();
		loginPage.preencherEmail();
		loginPage.tap(600,400);
		Assert.assertTrue(loginPage.obterMensagemEmailInvalido());
	}
	
	@Test
	public void deveVerificarEmailVazio() {
		loginPage.clicarCampoEmail();
		loginPage.tap(600,400);
		Assert.assertTrue(loginPage.obterMensagemEmailVazio());
	}
	
	@Test
	public void deveFazerLogin() {
		loginPage.realizarLogin();
	}
	
	

}
