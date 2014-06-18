package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Fornecedor;
import util.Conexao;

public class FornecedorDAO {
	private Connection con = Conexao.getConnection();
	
	public void inserir(Fornecedor fornec){
		String sql = "insert into fornecedor(nomefantasia, razaosocial, cnpj, ie, cep, endereco,"
					+ "bairro, cidade, estado, complemento, telcomercial, celular, outrotelefone,"
					+ "email) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?);";
		
		try {
			PreparedStatement preparar = con.prepareStatement(sql);
			preparar.setString(1, fornec.getNomeFantasia());
			preparar.setString(2, fornec.getRazaoSocial());
			preparar.setString(3, fornec.getCnpj());
			preparar.setString(4, fornec.getIe());
			preparar.setString(5, fornec.getCep());
			preparar.setString(6, fornec.getEndereco());
			preparar.setString(7, fornec.getBairro());
			preparar.setString(8, fornec.getCidade());
			preparar.setString(9, fornec.getEstado());
			preparar.setString(10, fornec.getComplemento());
			preparar.setString(11, fornec.getTelComercial());
			preparar.setString(12, fornec.getCelular());
			preparar.setString(13, fornec.getOutroTelefone());
			preparar.setString(14, fornec.getEmail());
			
			preparar.execute();
			preparar.close();
			
			System.out.println("DAO: Fornecedor cadastrado com sucesso");
		} catch (SQLException e) {
			System.out.println("DAO: erro ao cadastrar fornecedor"+e.getMessage());
			e.printStackTrace();
		}
	}
	
	public void atualizar(Fornecedor fornec){
		String sql = "update fornecedor set (nomefantasia=?, razaosocial=?, cnpj=?, ie=?, cep=?,"
					+"endereco=?, bairro=?, cidade=?, estado=?, complemento=?, telcomercial=?,"
					+ "celular=?, outrotelefone=?, email=?) where id=?;";
		
		try {
			PreparedStatement preparar = con.prepareStatement(sql);
			preparar.setString(1, fornec.getNomeFantasia());
			preparar.setString(2, fornec.getRazaoSocial());
			preparar.setString(3, fornec.getCnpj());
			preparar.setString(4, fornec.getIe());
			preparar.setString(5, fornec.getCep());
			preparar.setString(6, fornec.getEndereco());
			preparar.setString(7, fornec.getBairro());
			preparar.setString(8, fornec.getCidade());
			preparar.setString(9, fornec.getEstado());
			preparar.setString(10, fornec.getComplemento());
			preparar.setString(11, fornec.getTelComercial());
			preparar.setString(12, fornec.getCelular());
			preparar.setString(13, fornec.getOutroTelefone());
			preparar.setString(14, fornec.getEmail());
			preparar.setInt(15, fornec.getId());
			
			preparar.execute();
			preparar.close();
			
			System.out.println("DAO: Fornecedor atualizado com sucesso");
		} catch (SQLException e) {
			System.out.println("DAO: erro ao atualizar cliente"+e.getMessage());
			e.printStackTrace();
		}
	}
	
	public void delete(Fornecedor fornec){
		String sql = "delete from cliente where id=?;";
		
		try {
			PreparedStatement preparar = con.prepareStatement(sql);
			preparar.setInt(1, fornec.getId());
			
			preparar.execute();
			preparar.close();
			
			System.out.println("DAO: Fornecedor deletado com sucesso");
		} catch (SQLException e) {
			System.out.println("DAO: Erro ao deletar fornecedor"+e.getMessage());
			e.printStackTrace();
		}
	}
	
	public List<Fornecedor> buscarTodos(){
		String sql = "select * from fornecedor;";
		
		List<Fornecedor> lstFornec = new ArrayList<Fornecedor>();
		
		try {
			PreparedStatement preparar = con.prepareStatement(sql);
			
			ResultSet resultado = preparar.executeQuery();
			
			while(resultado.next()){
				//criando objeto
				Fornecedor fornec = new Fornecedor();
				//populando objeto
				fornec.setId(resultado.getInt("id"));
				fornec.setNomeFantasia(resultado.getString("nomefantasia"));
				fornec.setRazaoSocial(resultado.getString("razaosocial"));
				fornec.setCnpj(resultado.getString("cnpj"));
				fornec.setIe(resultado.getString("ie"));
				fornec.setCep(resultado.getString("cep"));
				fornec.setEndereco(resultado.getString("endereco"));
				fornec.setBairro(resultado.getString("bairro"));
				fornec.setCidade(resultado.getString("cidade"));
				fornec.setEstado(resultado.getString("estado"));
				fornec.setComplemento(resultado.getString("complemento"));
				fornec.setTelComercial(resultado.getString("telcomercial"));
				fornec.setCelular(resultado.getString("celular"));
				fornec.setOutroTelefone(resultado.getString("outrotelefone"));
				fornec.setEmail(resultado.getString("email"));
				//adicionando objeto populado na lista
				lstFornec.add(fornec);
			}
		} catch (SQLException e) {
			System.out.println("DAO: Erro ao selecionar fornecedor"+e.getMessage());
			e.printStackTrace();
		}
		
		return lstFornec;
	}

}
