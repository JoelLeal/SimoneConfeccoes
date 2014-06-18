package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Compra;
import util.Conexao;
import util.Datas;

public class CompraDAO {
	private Connection con = Conexao.getConnection();
	
	public Integer inserir(Compra comp){
		String sql = "insert into compra (idfornecedor, datacompra) values (?,?) returning \"id\";";
		
		Integer id=null;
		try {
			PreparedStatement preparar = con.prepareStatement(sql);
			preparar.setInt(1, comp.getIdFornecedor());
			
			Date dataSql = Datas.javaDateParaSqlDate(comp.getDataCompra());
			preparar.setDate(2, dataSql);
			
			ResultSet resultado = preparar.executeQuery();
			while(resultado.next()){
				id = resultado.getInt("id");
			}
			preparar.close();
		} catch (SQLException e) {
			System.out.println("DAO: Erro ao inserir compra");
			e.printStackTrace();
		}
		return id;
	}
	
	public void atualizarTotal(int codigo){
		
		String sql1 = "select sum(valortotal) as total from compradetalhe where idcompra=?;";
		String sql2 = "update compra set valortotal=? where id=?;";
		float total = 0;
		
		try {
			PreparedStatement preparar = con.prepareStatement(sql1);
			preparar.setFloat(1, codigo);
			
			ResultSet resultado = preparar.executeQuery();
			while(resultado.next()){
				total = resultado.getFloat("total");
			}
			preparar.close();
		} catch (SQLException e) {
			System.out.println("DAO: Erro pegar valor total da compra");
			e.printStackTrace();
		}
		
		try {
			PreparedStatement preparar = con.prepareStatement(sql2);
			
			preparar.setFloat(1, total);
			preparar.setInt(2, codigo);
			
			preparar.execute();
			preparar.close();
		} catch (SQLException e) {
			System.out.println("DAO: Erro ao atualizar valor total da compra");
			e.printStackTrace();
		}
	}
	
	public List<Compra> buscarTodos(){
		String sql = "select * from compra;";
		
		List<Compra> lstComp = new ArrayList<Compra>();
		
		try {
			PreparedStatement preparar = con.prepareStatement(sql);
			
			ResultSet resultado = preparar.executeQuery();
			
			while(resultado.next()){
				Compra comp = new Compra();
				comp.setId(resultado.getInt("id"));
				comp.setIdFornecedor(resultado.getInt("idfornecedor"));
				comp.setDataCompra(resultado.getDate("datacompra"));
				comp.setValorTotal(resultado.getFloat("valortotal"));
				
				lstComp.add(comp);
			}
			
			preparar.close();
		} catch (SQLException e) {
			System.out.println("DAO: Erro do selecionar todas compras");
			e.printStackTrace();
		}
		
		return lstComp;
	}
}
