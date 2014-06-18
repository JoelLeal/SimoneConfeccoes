package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.VendaDetalhe;
import util.Conexao;

public class VendaDetalheDAO {
	Connection con = Conexao.getConnection();
	
	public void inserir(VendaDetalhe vndDet){
		String sql = "insert into vendadetalhe (idvenda, idproduto, qtde, "
					+ "valorunitario, valortotal) values (?,?,?,?,?);";
		try {
			PreparedStatement preparar = con.prepareStatement(sql);
			preparar.setInt(1, vndDet.getIdVena());
			preparar.setInt(2, vndDet.getIdProduto());
			preparar.setInt(3, vndDet.getQtde());
			preparar.setFloat(4, vndDet.getValorUnitario());
			preparar.setFloat(5, vndDet.getValorTotal());
			
			preparar.execute();
			preparar.close();
		} catch (SQLException e) {
			System.out.println("DAO: Erro ao inserir venda detalhe");
			e.printStackTrace();
		}
	}
	
	public List<VendaDetalhe> buscarTodos(){
		String sql = "select * from vendadetalhe order by idvenda;";
		List<VendaDetalhe> lstVnd = new ArrayList<VendaDetalhe>();
		
		try {
			PreparedStatement preparar = con.prepareStatement(sql);
			
			ResultSet resultado = preparar.executeQuery();
			
			while(resultado.next()){
				VendaDetalhe vndDet = new VendaDetalhe();
				vndDet.setIdVena(resultado.getInt("idvenda"));
				vndDet.setIdProduto(resultado.getInt("idproduto"));
				vndDet.setQtde(resultado.getInt("qtde"));
				vndDet.setValorUnitario(resultado.getFloat("valorunitario"));
				vndDet.setValorTotal(resultado.getFloat("valortotal"));
				
				lstVnd.add(vndDet);
			}
		} catch (SQLException e) {
			System.out.println("DAO: Erro ao selecionar venda detalhe");
			e.printStackTrace();
		}
		return lstVnd;
	}
}
