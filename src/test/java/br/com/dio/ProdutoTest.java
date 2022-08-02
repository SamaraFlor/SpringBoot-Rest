package br.com.dio;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.dio.entity.Produto;
import br.com.dio.exception.ProductPriceException;
import br.com.dio.service.ProdutoService;

@SpringBootTest
public class ProdutoTest {

	@Autowired
	private ProdutoService produtoService;
// anotação teste para falar que é um teste
	@Test
	public void vericicaValorNegativoNoProduto() {
		Produto produto = new Produto();

		produto.setNome("Teste");
		produto.setPreco(-10.0);
// validando se vai dar excessão
		assertThrows(ProductPriceException.class, () -> produtoService.save(produto));

	}

}
