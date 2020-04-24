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
 * Servlet responsável por listar um produto
 * pelo codigo
 * 
 * @author João Vitor Oliveira
 * @since 22/04/2020
 */
@WebServlet("/listaProduto.do")
public class ListaProdutoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private final ProdutoService produtoService = new ProdutoService(); 
       
	/**
	 * Método responsável por buscar um produto por seu codigo
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		int codigo = Integer.parseInt(request.getParameter("codigo"));
		ProdutoModel produto = produtoService.consultaProduto(codigo);
		
		response.getWriter().print(
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
