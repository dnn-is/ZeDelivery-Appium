package br.jp.dandrade.test;

import org.junit.Before;
import org.junit.Test;

import br.jp.dandrade.core.BaseTest;
import br.jp.dandrade.page.InicioPage;
import br.jp.dandrade.page.LoginPage;

public class InicioTest extends BaseTest {
	InicioPage inicio = new InicioPage();
	LoginPage loginPage = new LoginPage();
	
	@Before
	public void chegarInicio() {
		loginPage.realizarLogin();
	}
	
	@Test
	public void deveSelecionarPerfil() {
		inicio.selecionarPerfil();
	}
}
