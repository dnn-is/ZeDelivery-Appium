package br.jp.dandrade.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.jp.dandrade.core.BaseTest;
import br.jp.dandrade.page.InicioPage;
import br.jp.dandrade.page.LoginPage;
import br.jp.dandrade.page.PerfilPage;

public class PerfilTest extends BaseTest {
	
	LoginPage loginPage = new LoginPage();
	PerfilPage perfil = new PerfilPage();
	InicioPage inicio = new InicioPage();
	
	@Before
	public void chegarInicio() {
		loginPage.realizarLogin();
	}
	
	@Test
	public void deveVerificarNome() {
		inicio.selecionarPerfil();
		Assert.assertTrue(perfil.obterNome().contains("Dennis"));
	}
	
	@Test
	public void deveVerificarEmail() {
		inicio.selecionarPerfil();
		Assert.assertTrue(perfil.obterEmail().contains("fakedennis06@gmail.com"));
	}

}
