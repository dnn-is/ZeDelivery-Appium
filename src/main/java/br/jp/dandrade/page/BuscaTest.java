package br.jp.dandrade.page;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.jp.dandrade.core.BaseTest;

public class BuscaTest extends BaseTest {
	
	LoginPage loginPage = new LoginPage();
	BuscaPage busca = new BuscaPage();
	InicioPage inicio = new InicioPage();
	ProdutoPage produto = new ProdutoPage();
	SacolaPage sacola = new SacolaPage();
	
	@Before
	public void deveSelecionarBusca() {
		loginPage.realizarLogin();
		inicio.selecionarBusca();
	}
	
	@Test
	public void deveadicionarERemoverBrahma() {
		busca.buscarBrahma();
		busca.adicionarBrahma();
		produto.clicarAdicionar();
		sacola.clicarVerSacola();
		sacola.alterarQuantidade();
		sacola.removerProduto();
		Assert.assertTrue(sacola.isSacolaVazia());
		
	}

}
