package br.jp.dandrade.test;

import org.junit.Before;
import org.junit.Test;

import br.jp.dandrade.core.BaseTest;
import br.jp.dandrade.page.InicioPage;
import br.jp.dandrade.page.LoginPage;
import br.jp.dandrade.page.ProdutoPage;

public class InicioTest extends BaseTest {
	
	LoginPage loginPage = new LoginPage();
	InicioPage inicio = new InicioPage();
	ProdutoPage produto = new ProdutoPage();
	
	@Before
	public void chegarNoInicio() {
		loginPage.realizarLogin();
	}
	
	@Test
	public void deveClicarBrahma(){
		inicio.selecionarBrahma();
		produto.clicarCincoVezesAddProduto();
	}
	

}
