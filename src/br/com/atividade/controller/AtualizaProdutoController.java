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
 * Servlet responsável por atualizar um produto
 * 
 * @author João Vitor Oliveira
 * @since 22/04/2020
 */
@WebServlet("/atualizaProduto.do")
public class AtualizaProdutoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private final ProdutoService produtoService = new ProdutoService(); 
       
	/**
	 * Método responsável por atualizar um produto a partir de seu codigo
	 */
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ProdutoModel produtoModel = new ProdutoModel();
		produtoModel.setCodigo(Integer.valueOf(request.getParameter("codigo")));
		produtoModel.setNome(request.getParameter("nome"));
		produtoModel.setValor(Double.parseDouble(request.getParameter("valor")));
		produtoModel.setDescricao(request.getParameter("descricao"));
		produtoModel.setEstoque(Integer.valueOf(request.getParameter("estoque")));
		
		produtoService.atualizaProduto(produtoModel);
	}

}
