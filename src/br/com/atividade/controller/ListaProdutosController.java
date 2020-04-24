package br.com.atividade.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.atividade.model.ProdutoModel;
import br.com.atividade.service.ProdutoService;

/**
 * Servlet responsável por listar todos os professores
 * 
 * @author João Vitor Oliveira
 * @since 12/04/2020
 */
@WebServlet("/listaProdutos.do")
public class ListaProdutosController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private final ProdutoService produtoService = new ProdutoService();  

	/**
	 * Método responsável por listar todos os professores
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<ProdutoModel> listaProduto = produtoService.listaProduto();
		
		for(ProdutoModel produto : listaProduto) {
			response.getWriter().println(
					"<table>"
							+"<tr>"
								+"<td>Matricula</td>"
								+"<td>Nome</td>"
								+"<td>CPF</td>"
								+"<td>Endereço</td>"
							+"</tr>"
							+"<tr>"
								+"<td>"+produto.getCodigo()+"</td>"
								+"<td>"+produto.getNome()+"</td>"
								+"<td>"+produto.getValor()+"</td>"
								+"<td>"+produto.getDescricao()+"</td>"
								+"<td>"+produto.getEstoque()+"</td>"
							+"</tr>"
					+"</table>");
		}
	}
}
