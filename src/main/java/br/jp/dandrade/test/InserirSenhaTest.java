package br.jp.dandrade.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.jp.dandrade.core.BaseTest;
import br.jp.dandrade.page.InserirSenhaPage;
import br.jp.dandrade.page.LoginPage;

public class InserirSenhaTest extends BaseTest {
	LoginPage loginPage = new LoginPage();
	InserirSenhaPage senhaPage = new InserirSenhaPage();
	
	@Before
	public void chegarCampoSenha() {
		loginPage.chegarCampoSenha();
	}
	
	@Test
	public void deveVerificarSenhaVazia() {
		senhaPage.clicarCampoSenha();
		senhaPage.tap(551, 375);
		Assert.assertTrue(senhaPage.obterMensagemCampoSenhaVazio().equalsIgnoreCase("Opa, precisamos da sua senha"));
	}
	
	@Test
	public void deveVerificarSenhaIncorreta() {
		senhaPage.fornecerSenhaIncorreta();
		Assert.assertTrue(senhaPage.mensagemSenhaIncorreta());
		
	}

}
