package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Pedido;
import util.Conexao;
import util.Datas;

public class PedidoDAO {
	private Connection con = Conexao.getConnection();
	
	public String inserir(Pedido ped){
		String sql = "insert into pedido (idcliente, descricao, datapedido, dataprevisao,"
					+ "datapronto, valorprevisto, valorfinal) values(?,?,?,?,?,?,?) returning \"idpedido\";";
		String id = null;
		try {
			PreparedStatement preparar = con.prepareStatement(sql);
			preparar.setInt(1, ped.getIdCliente());
			preparar.setString(2, ped.getDescricao());
			
			java.sql.Date dataSql = Datas.javaDateParaSqlDate(ped.getDataPedido());
			preparar.setDate(3, dataSql);
			
			dataSql = Datas.javaDateParaSqlDate(ped.getDataPrevisao());
			preparar.setDate(4, dataSql);			
			
			dataSql = Datas.javaDateParaSqlDate(ped.getDataPronto());
			preparar.setDate(5, dataSql);
			
			preparar.setFloat(6, ped.getValorPrevisto());
			preparar.setFloat(7, ped.getValorFinal());
			
			//preparar.execute();
			ResultSet resultado = preparar.executeQuery();
			
			while(resultado.next()){
				id = resultado.getString("idpedido");
			}
			preparar.close();
			
			System.out.println("DAO: Pedido cadastrado com sucesso");
		} catch (SQLException e) {
			System.out.println("DAO: Erro ao inserir pedido");
			e.printStackTrace();
		}
		return id;
	}
	
	public List<Pedido> buscarTodos(){
		String sql = "select * from pedido;";
		
		List<Pedido> lstPed = new ArrayList<Pedido>();

		try {
			PreparedStatement preparar;
			preparar = con.prepareStatement(sql);
			ResultSet resultado = preparar.executeQuery();
			
			while(resultado.next()){
				Pedido ped = new Pedido();
				ped.setId(resultado.getInt("idpedido"));
				ped.setIdCliente(resultado.getInt("idcliente"));
				ped.setDescricao(resultado.getString("descricao"));
				
				java.sql.Date dataSql = resultado.getDate("datapedido");
				ped.setDataPedido(Datas.sqlDateParaJavaDate(dataSql));
				
				dataSql = resultado.getDate("dataprevisao");
				ped.setDataPrevisao(Datas.sqlDateParaJavaDate(dataSql));
				
				dataSql = resultado.getDate("datapronto");
				ped.setDataPronto(Datas.sqlDateParaJavaDate(dataSql));
				
				ped.setValorPrevisto(resultado.getFloat("valorprevisto"));
				ped.setValorFinal(resultado.getFloat("valorfinal"));
				
				lstPed.add(ped);
			}
		} catch (SQLException e) {
			System.out.println("DAO: Erro ao selecionar todos os pedidos");
			e.printStackTrace();
		}
		return lstPed;
		
	}
}
