package br.com.atividade.service;

import java.util.List;

import br.com.atividade.dao.ProdutoDAO;
import br.com.atividade.model.ProdutoModel;

/**
 * Classe respons�vel por conter toda a l�gica do neg�cio
 * 
 * @author Jo�o Vitor
 * @since 23/04/2020
 *
 */
public class ProdutoService {

	private ProdutoDAO produtoDAO = new ProdutoDAO();
	
	/**
	 * M�todo respons�vel por chamar a dao para um
	 * cadastro de um produto
	 * @param produto
	 */
	public void cadastraProduto(ProdutoModel produtoModel) {
		produtoDAO.cadastrar(produtoModel);
	}

	/**
	 * M�todo respons�vel por chamar a dao para uma
	 * consulta de um produto
	 * @param codigo
	 * @return {@code - ProdutoModel} lista um produto 
	 * 								de acordo com o c�digo.
	 */
	public ProdutoModel consultaProduto(int codigo) {
		
		return produtoDAO.consultar(codigo);	
	}

	/**
	 * M�todo respons�vel por chamar a dao para atualizar 
	 * dados de um produto de acordo com o c�digo do produtos
	 * @param produtoModel
	 */
	public void atualizaProduto(ProdutoModel produtoModel) {
		produtoDAO.alterar(produtoModel);
	}

	/**
	 * M�todo respons�vel por chamar a dao para
	 * deletar um produto
	 * @param produtoModel
	 */
	public void deletaProduto(ProdutoModel produtoModel) {
		produtoDAO.excluir(produtoModel);
	}
	
	/**
	 * M�todo respons�vel por chamar a dao para listar todos os produtos
	 * @return {@code - List<ProdutoModel>} lista todos produtos
	 */
	public List<ProdutoModel> listaProduto() {
		
		return produtoDAO.listarProdutos();	
	}
}
