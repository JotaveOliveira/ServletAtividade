package br.com.atividade.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.atividade.model.ProdutoModel;
import br.com.atividade.service.ProdutoService;

/**
 * Servlet respons�vel por excluir um produto
 * 
 * @author Jo�o Vitor Oliveira
 * @since 22/04/2020
 */
@WebServlet("/excluirProduto.do")
public class ExcluiProdutoController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
      
	private final ProdutoService produtoService = new ProdutoService();
	
	/**
	 * M�todo respons�vel por deletar um produto pelo codigo
	 */
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ProdutoModel produtoModel = new ProdutoModel();
		produtoModel.setCodigo(Integer.valueOf(request.getParameter("codigo")));
		
		produtoService.deletaProduto(produtoModel);
	}
}
