package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.CompraDetalhe;
import util.Conexao;

public class CompraDetalheDAO {
	private Connection con = Conexao.getConnection();
	
	public void inserir(CompraDetalhe compDet){
		String sql = "insert into compradetalhe (idmateriaprima, idcompra,"
					+ "qtdekg, valorkg, valortotal) values (?,?,?,?,?);";
		
		try {
			PreparedStatement preparar = con.prepareStatement(sql);
			
			preparar.setInt(1, compDet.getIdMateriaPrima());
			preparar.setInt(2, compDet.getIdCompra());
			preparar.setFloat(3, compDet.getQtdekg());
			preparar.setFloat(4, compDet.getValorkg());
			preparar.setFloat(5, compDet.getValorTotal());
			
			preparar.execute();
			preparar.close();
		} catch (SQLException e) {
			System.out.println("DAO: Erro ao inserir compra detalhe");
			e.printStackTrace();
		}
	}
	
	public List<CompraDetalhe> buscarTodos(){
		String sql = "select * from compradetalhe order by idcompra;";
		
		List<CompraDetalhe> lstComp = new ArrayList<CompraDetalhe>();
		
		try {
			PreparedStatement preparar = con.prepareStatement(sql);
			
			ResultSet resultado = preparar.executeQuery();
			
			while(resultado.next()){
				CompraDetalhe compDet = new CompraDetalhe();
				compDet.setIdCompra(resultado.getInt("idcompra"));
				compDet.setIdMateriaPrima(resultado.getInt("idmateriaprima"));
				compDet.setQtdekg(resultado.getFloat("qtdekg"));
				compDet.setValorkg(resultado.getFloat("valorkg"));
				compDet.setValorTotal(resultado.getFloat("valortotal"));
				
				lstComp.add(compDet);
			}
			
			preparar.close();
		} catch (SQLException e) {
			System.out.println("DAO: Erro ao selecionar todas compras detalhada");
			e.printStackTrace();
		}
		
		return lstComp;
	}
}
