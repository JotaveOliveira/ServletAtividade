package br.com.atividade.service;

import java.util.List;

import br.com.atividade.dao.ProdutoDAO;
import br.com.atividade.model.ProdutoModel;

/**
 * Classe responsável por conter toda a lógica do negócio
 * 
 * @author João Vitor
 * @since 23/04/2020
 *
 */
public class ProdutoService {

	private ProdutoDAO produtoDAO = new ProdutoDAO();
	
	/**
	 * Método responsável por chamar a dao para um
	 * cadastro de um produto
	 * @param produto
	 */
	public void cadastraProduto(ProdutoModel produtoModel) {
		produtoDAO.cadastrar(produtoModel);
	}

	/**
	 * Método responsável por chamar a dao para uma
	 * consulta de um produto
	 * @param codigo
	 * @return {@code - ProdutoModel} lista um produto 
	 * 								de acordo com o código.
	 */
	public ProdutoModel consultaProduto(int codigo) {
		
		return produtoDAO.consultar(codigo);	
	}

	/**
	 * Método responsável por chamar a dao para atualizar 
	 * dados de um produto de acordo com o código do produtos
	 * @param produtoModel
	 */
	public void atualizaProduto(ProdutoModel produtoModel) {
		produtoDAO.alterar(produtoModel);
	}

	/**
	 * Método responsável por chamar a dao para
	 * deletar um produto
	 * @param produtoModel
	 */
	public void deletaProduto(ProdutoModel produtoModel) {
		produtoDAO.excluir(produtoModel);
	}
	
	/**
	 * Método responsável por chamar a dao para listar todos os produtos
	 * @return {@code - List<ProdutoModel>} lista todos produtos
	 */
	public List<ProdutoModel> listaProduto() {
		
		return produtoDAO.listarProdutos();	
	}
}
