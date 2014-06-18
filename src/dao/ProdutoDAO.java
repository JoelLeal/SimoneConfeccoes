package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Produto;
import util.Conexao;

public class ProdutoDAO {
	private Connection con = Conexao.getConnection();
	
	public String inserir(Produto prod){
		String sql = "insert into produto (idmateriaprima, descricao, qtde, valor, pesoprod)"
					+ "values (?,?,?,?,?) returning \"id\";";
		String id = null;
		
		try {
			PreparedStatement preparar = con.prepareStatement(sql);
			preparar.setInt(1, prod.getIdMateriaPrima());
			preparar.setString(2, prod.getDescricao());
			preparar.setInt(3, prod.getQtde());
			preparar.setFloat(4, prod.getValor());
			preparar.setFloat(5, prod.getPesoProd());
			
			ResultSet resultado = preparar.executeQuery();
			
			while(resultado.next()){
				id = resultado.getString("id");
			}
			
			preparar.close();
		} catch (SQLException e) {
			System.out.println("DAO: Erro ao inserir Produto");
			e.printStackTrace();
		}
		
		return id;
	}
	
	public List<Produto> buscarTodos(){
		String sql = "select * from produto;";
		
		List<Produto> lstProd = new ArrayList<Produto>();
		
		try {
			PreparedStatement preparar = con.prepareStatement(sql);
			ResultSet resultado = preparar.executeQuery();
			
			while(resultado.next()){
				Produto prod = new Produto();
				prod.setId(resultado.getInt("id"));
				prod.setIdMateriaPrima(resultado.getInt("idmateriaprima"));
				prod.setDescricao(resultado.getString("descricao"));
				prod.setQtde(resultado.getInt("qtde"));
				prod.setValor(resultado.getFloat("valor"));
				prod.setPesoProd(resultado.getFloat("pesoprod"));
				
				lstProd.add(prod);
			}
		} catch (SQLException e) {
			System.out.println("DAO: Erro ao buscar todos produtos");
			e.printStackTrace();
		}
		
		return lstProd;
	}
	
	public void atualizarQtde(int idProduto, int idQtde){
		String sql = "update produto set qtde=(qtde-?) where id=?;";
		
		try {
			PreparedStatement preparar = con.prepareStatement(sql);
			
			preparar.setInt(1, idQtde);
			preparar.setInt(2, idProduto);
			
			preparar.execute();
			preparar.close();
		} catch (SQLException e) {
			System.out.println("DAO: Erro ao atualizar qtde do produto");
			e.printStackTrace();
		}
		
	}
}
