package br.com.atividade.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.atividade.factory.ConnectionFactory;
import br.com.atividade.model.ProdutoModel;

import java.sql.ResultSet;

public class ProdutoDAO {
	
	private Connection conexao;
	
	public ProdutoDAO() {
		this.conexao = ConnectionFactory.conectar();
	}

	public void cadastrar(ProdutoModel produto) {
			
		String inserir = "INSERT INTO produto "
				+ " (codigo, nome, descricao, valor, estoque) "
				+ " VALUES (?, ?, ?, ?, ?) ";
		
		try ( PreparedStatement pst = 
				conexao.prepareStatement(inserir) ) {
			
			pst.setInt(1, produto.getCodigo());
			pst.setString(2, produto.getNome());
			pst.setString(3, produto.getDescricao());
			pst.setDouble(4, produto.getValor());
			pst.setInt(5, produto.getEstoque());
			
			pst.execute();
			
		} catch (SQLException ex) {
			
			System.err.println("N�o foi poss�vel manipular "
					+ "a tabela Produto.");
			ex.printStackTrace();
			
		}
	}
	
	public void alterar(ProdutoModel produto) {
		
		String alterar = "UPDATE produto "
				+ "SET nome = ?, descricao = ?, valor = ?, estoque = ? "
				+ " WHERE codigo = ? ";
		
		try ( PreparedStatement pst = 
				conexao.prepareStatement(alterar) ) {
			
			pst.setString(1, produto.getNome());
			pst.setString(2, produto.getDescricao());
			pst.setDouble(3, produto.getValor());
			pst.setInt(4, produto.getEstoque());
			pst.setInt(5, produto.getCodigo());
			
			pst.execute();
			
		} catch (SQLException ex) {
			
			System.err.println("N�o foi poss�vel manipular "
					+ "a tabela Produto.");
			ex.printStackTrace();
			
		}
	}
	
	public void excluir(ProdutoModel produto) {
		
		String excluir = "DELETE FROM produto "
				+ " WHERE codigo = ? ";
		
		try ( PreparedStatement pst = 
				conexao.prepareStatement(excluir) ) {
			
			pst.setInt(1, produto.getCodigo());
			
			pst.execute();
			
		} catch (SQLException ex) {
			
			System.err.println("N�o foi poss�vel manipular "
					+ "a tabela Produto.");
			ex.printStackTrace();
		}
	}
	
	public ProdutoModel consultar(int codigo) {
		
		String consultar = "SELECT * FROM produto "
				+ " WHERE codigo = ? ";
		
		try ( PreparedStatement pst = 
				conexao.prepareStatement(consultar) ) {
			
			pst.setInt(1, codigo);
			ResultSet resultado = pst.executeQuery();
			
			ProdutoModel p = new ProdutoModel();
			if (resultado.next()) {
				p.setCodigo(codigo);
				p.setDescricao(resultado.getString("descricao"));
				p.setNome(resultado.getString("nome"));
				p.setValor(resultado.getDouble("valor"));
				p.setEstoque(resultado.getInt("estoque"));
			}
			return p;
			
			
		} catch (SQLException ex) {
			
			System.err.println("N�o foi poss�vel manipular "
					+ "a tabela Produto.");
			ex.printStackTrace();
			
			return null;
		}
	}

	
	public ArrayList<ProdutoModel> listarProdutos() {
		
		String consultar = "SELECT * FROM produto";
		
		try ( PreparedStatement pst = 
				conexao.prepareStatement(consultar) ) {
			
			ResultSet resultado = pst.executeQuery();
			
			ArrayList<ProdutoModel> lista = new ArrayList<>();
			while (resultado.next()) {
				ProdutoModel p = new ProdutoModel();
				p.setCodigo(resultado.getInt("codigo"));
				p.setDescricao(resultado.getString("descricao"));
				p.setNome(resultado.getString("nome"));
				p.setValor(resultado.getDouble("valor"));
				p.setEstoque(resultado.getInt("estoque"));
				lista.add(p);
			}
			return lista;
			
		} catch (SQLException ex) {
			
			System.err.println("N�o foi poss�vel manipular "
					+ "a tabela Produto.");
			ex.printStackTrace();
			
			return null;
		}
	}

}
