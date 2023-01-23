package br.jp.dandrade.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.jp.dandrade.core.BaseTest;
import br.jp.dandrade.page.LoginPage;
import br.jp.dandrade.page.PagamentoPage;
import br.jp.dandrade.page.SacolaPage;

public class PagamentoTest extends BaseTest {
	
	LoginPage loginPage = new LoginPage();
	InicioTest inicio = new InicioTest();
	SacolaPage sacola = new SacolaPage();
	PagamentoPage pagamento = new PagamentoPage();
	
	@Before
	public void chegarSacola() {
		loginPage.realizarLogin();
		inicio.deveVerificarQuantidadeAdicionada();
	}

	@Test
	public void deveVerificarFinalizarCompraNaoClicavel() {
		sacola.clicarVerSacola();
		sacola.selecionarFormaPagamento();
		Assert.assertFalse(pagamento.finalizarCompraStatus());
	}
	
	@Test
	public void deveVerificarFinalizarCompraClicavel() {
		sacola.clicarVerSacola();
		sacola.selecionarFormaPagamento();
		pagamento.selecionarCartaoCreditoDebito();
		Assert.assertTrue(pagamento.finalizarCompraStatus());
	}
	
	
}
