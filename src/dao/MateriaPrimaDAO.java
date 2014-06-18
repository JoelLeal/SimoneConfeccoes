package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.MateriaPrima;
import util.Conexao;

public class MateriaPrimaDAO {
	private Connection con = Conexao.getConnection();
	
	public String inserir(MateriaPrima mat){
		String sql = "insert into materiaprima (descricao, tipotecido, qtdekg)"
					+ "values (?,?,?) returning \"id\";";
		String id = null;
		try {
			PreparedStatement preparar = con.prepareStatement(sql);
			preparar.setString(1, mat.getDescricao());
			preparar.setBoolean(2, mat.getTipoTecido());
			preparar.setFloat(3, mat.getQtdekg());
			
			//preparar.execute();
			ResultSet resultado = preparar.executeQuery();
			while(resultado.next()){
				id = resultado.getString("id");
			}
			preparar.close();
			System.out.println("DAO: Materia prima cadastrada com sucesso");
		} catch (SQLException e) {
			System.out.println("Erro ao cadastrar matéria prima"+e.getMessage());
			e.printStackTrace();
		}
		return id;
	}
	
	public void atualizar(MateriaPrima mat){
		String sql = "update materiaprima set (descricao=?, tipotecido=?,"
					+ "qtdekg=?) where id=?;";
		try {
			PreparedStatement preparar = con.prepareStatement(sql);
			preparar.setString(1, mat.getDescricao());
			preparar.setBoolean(2, mat.getTipoTecido());
			preparar.setFloat(3, mat.getQtdekg());
			preparar.setInt(4, mat.getId());
			
			preparar.execute();
			preparar.close();
			System.out.println("DAO: materia prima atualizada com sucesso");
		} catch (SQLException e) {
			System.out.println("DAO: erro ao atualizar materia prima");
			e.printStackTrace();
		}
		
	}
	
	public void atualizarQtdeKg(float kg, int codigo){
		String sql = "update materiaprima set qtdekg=(qtdekg+?) where id=?;";
		
		try {
			PreparedStatement preparar = con.prepareStatement(sql);
			preparar.setFloat(1, kg);
			preparar.setInt(2, codigo);
			
			preparar.execute();
			preparar.close();
		} catch (SQLException e) {
			System.out.println("DAO: Erro ao somar KG na materia prima");
			e.printStackTrace();
		}
	}
	
	public void atualizarQtdeKgSubtrair(float kg, int codigo){
		String sql = "update materiaprima set qtdekg=(qtdekg-?) where id=?;";
		
		try {
			PreparedStatement preparar = con.prepareStatement(sql);
			preparar.setFloat(1, kg);
			preparar.setInt(2, codigo);
			
			preparar.execute();
			preparar.close();
		} catch (SQLException e) {
			System.out.println("DAO: Erro ao subtrair KG na materia prima");
			e.printStackTrace();
		}
	}
	
	public void deletar(MateriaPrima mat){
		String sql = "delete from materiaprima where id=?;";
		
		try {
			PreparedStatement preparar = con.prepareStatement(sql);
			preparar.setInt(1, mat.getId());
			
			preparar.execute();
			preparar.close();
			System.out.println("DAO: materia prima deletada com sucesso");
		} catch (Exception e) {
			System.out.println("DAO: erro ao deletar materia prima");
		}
	}
	
	public List<MateriaPrima> buscarTodos(){
		String sql = "select * from materiaprima order by id asc;";
		
		List<MateriaPrima> lstMat = new ArrayList<MateriaPrima>();
		
		try {
			PreparedStatement preparar = con.prepareStatement(sql);
			
			ResultSet resultado = preparar.executeQuery();
			
			while(resultado.next()){
				MateriaPrima mat = new MateriaPrima();
				mat.setDescricao(resultado.getString("descricao"));
				mat.setId(resultado.getInt("id"));
				mat.setQtdekg(resultado.getFloat("qtdekg"));
				mat.setTipoTecido(resultado.getBoolean("tipotecido"));
				
				lstMat.add(mat);
			}
		} catch (SQLException e) {
			System.out.println("DAO: Erro ao selecionar cliente");
			e.printStackTrace();
		}
		return lstMat;
	}

}
