package br.jp.dandrade.test;

import org.junit.Before;
import org.junit.Test;

import br.jp.dandrade.core.BaseTest;
import br.jp.dandrade.page.LoginPage;
import br.jp.dandrade.page.SacolaPage;

public class SacolaTest extends BaseTest {
	
	LoginPage loginPage = new LoginPage();
	InicioTest inicio = new InicioTest();
	SacolaPage sacola = new SacolaPage();
	
	@Before
	public void chegarSacola() {
		loginPage.realizarLogin();
		inicio.deveVerificarQuantidadeAdicionada();
	}
	
	@Test
	public void chegarNoCarriho() {
		sacola.clicarVerSacola();
		sacola.selecionarFormaPagamento();
	}

}
