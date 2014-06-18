package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Venda;
import util.Conexao;
import util.Datas;

public class VendaDAO {
	Connection con = Conexao.getConnection();
	
	public Integer inserir(Venda vend){
		String sql = "insert into venda (idcliente, datavenda) values (?,?) returning \"id\";";
		
		Integer id=null;
		
		try {
			PreparedStatement preparar = con.prepareStatement(sql);
			
			preparar.setInt(1, vend.getIdCliente());

			Date dataSql = Datas.javaDateParaSqlDate(vend.getDataVenda());
			preparar.setDate(2, dataSql);
			
			ResultSet resultado = preparar.executeQuery();
			
			while(resultado.next()){
				id = resultado.getInt("id");
			}
			preparar.close();
		} catch (SQLException e) {
			System.out.println("DAO: Erro ao inserir venda");
			e.printStackTrace();
		}
		return id;
	}
	
	public void atualizarTotal(Integer codigo){
		String sql1 = "select sum(valortotal) as total from vendadetalhe where idvenda=?;";
		String sql2 = "update venda set valortotal=? where id=?;";
		float total=0;
		
		try {
			PreparedStatement preparar = con.prepareStatement(sql1);
			preparar.setInt(1, codigo);
			
			ResultSet resultado = preparar.executeQuery();
			
			while(resultado.next()){
				total=resultado.getFloat("total");
			}
			preparar.close();
		} catch (SQLException e) {
			System.out.println("DAO: Erro ao pegar soma dos valores da venda detalhe");
			e.printStackTrace();
		}
		
		
		try {
			PreparedStatement preparar = con.prepareStatement(sql2);
			
			preparar.setFloat(1, total);
			preparar.setInt(2, codigo);
			
			preparar.execute();
			preparar.close();
		} catch (SQLException e) {
			System.out.println("DAO: Erro ao atualizar valor da venda");
			e.printStackTrace();
		}
	}
	
	public List<Venda> buscarTodos(){
		String sql = "select * from venda;";
		
		List<Venda> lstVnd = new ArrayList<Venda>();
		
		try {
			PreparedStatement preparar = con.prepareStatement(sql);
			
			ResultSet resultado = preparar.executeQuery();
			
			while(resultado.next()){
				Venda vnd = new Venda();
				vnd.setId(resultado.getInt("id"));
				vnd.setIdCliente(resultado.getInt("idcliente"));
				vnd.setDataVenda(resultado.getDate("datavenda"));
				vnd.setValorTotal(resultado.getFloat("valortotal"));
				
				lstVnd.add(vnd);
			}
		} catch (SQLException e) {
			System.out.println("DAO: Erro ao selecionar todas as vendas");
			e.printStackTrace();
		}
		return lstVnd;
	}
}
