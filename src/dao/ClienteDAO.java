package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import util.Conexao;
import util.Datas;
import model.Cliente;

public class ClienteDAO {
	
	private Connection con = Conexao.getConnection();
	
	public void inserir(Cliente cli){
		
		String sql = "insert into cliente (nomefantasia, razaosocial, cpfcnpj, rgie, cep,"
					+"endereco, bairro, cidade, complemento, datanascimento, telresidencial,"
					+ "celular, outrotelefone, email, estado) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);";
		
		try {
			PreparedStatement preparar = con.prepareStatement(sql);
			preparar.setString(1, cli.getNomeFantasia());
			preparar.setString(2, cli.getRazaoSocial());
			preparar.setString(3, cli.getCpfCnpj());
			preparar.setString(4, cli.getRgIe());
			preparar.setString(5, cli.getCep());
			preparar.setString(6, cli.getEndereco());
			preparar.setString(7, cli.getBairro());
			preparar.setString(8, cli.getCidade());
			preparar.setString(9, cli.getComplemento());
			
			java.sql.Date dataSQL = Datas.javaDateParaSqlDate(cli.getDataNascimento());
			
			preparar.setDate(10, dataSQL);
			
			preparar.setString(11, cli.getTelResidencial());
			preparar.setString(12, cli.getCelular());
			preparar.setString(13, cli.getOutroTelefone());
			preparar.setString(14, cli.getEmail());
			preparar.setString(15, cli.getEstado());
			
			preparar.execute();
			preparar.close();
				
			System.out.println("DAO: Cliente cadastrado com Sucesso");
			
		} catch (SQLException e) {
			System.out.println("DAO: Erro ao cadastrar: "+e.getMessage());
			e.printStackTrace();
		}
		
	}
	
	public void atualizar(Cliente cli){
		String sql = "update cliente set (nomefantasia=?, razaosocial=?, cpfcnpj=?, rgie=?, cep=?,"
					+"endereco=?, bairro=?, cidade=?, complemento=?, datanascimento=?, telresidencial=?,"
					+ "celular=?, outrotelefone=?, email=?, estado=?) where id=?;";
		try {
			PreparedStatement preparar = con.prepareStatement(sql);
			preparar.setString(1, cli.getNomeFantasia());
			preparar.setString(2, cli.getRazaoSocial());
			preparar.setString(3, cli.getCpfCnpj());
			preparar.setString(4, cli.getRgIe());
			preparar.setString(5, cli.getCep());
			preparar.setString(6, cli.getEndereco());
			preparar.setString(7, cli.getBairro());
			preparar.setString(8, cli.getCidade());
			preparar.setString(9, cli.getComplemento());
			java.sql.Date dataSQL = Datas.javaDateParaSqlDate(cli.getDataNascimento());
			preparar.setDate(10, dataSQL);
			preparar.setString(11, cli.getTelResidencial());
			preparar.setString(12, cli.getCelular());
			preparar.setString(13, cli.getOutroTelefone());
			preparar.setString(14, cli.getEmail());
			preparar.setString(15, cli.getEstado());
			preparar.setInt(16, cli.getId());
			
			preparar.execute();
			preparar.close();
			System.out.println("DAO: Cliente atualizado com sucesso");
		} catch (SQLException e) {
			System.out.println("DAO: Falha ao atualizar: "+e.getMessage());
			e.printStackTrace();
		}
	}
	
	public void delete(Cliente cli){
		String sql = "delete from cliente where id=?;";
		
		try {
			PreparedStatement preparar = con.prepareStatement(sql);
			
			preparar.setInt(1, cli.getId());
			
			preparar.execute();
			preparar.close();
			
			System.out.println("DAO: Cliente deletado com sucesso");
		} catch (SQLException e) {
			System.out.println("DAO: Erro ao deletar Cliente: "+e.getMessage());
			e.printStackTrace();
		}
	}
	
	//lista java.util.List
	public List<Cliente> buscarTodos(){
		String sql = "select * from cliente;";
		
		List<Cliente> lstCli = new ArrayList<Cliente>();
		
		try {
			PreparedStatement preparar = con.prepareStatement(sql);
			
			//executeQuery é apenas para realizar consulta, quando trazemos dados do BD
			//apenas execute é quando não tem retorno
			//ResultSet é da classe java.sql e retorna todos os dados da consulta
			ResultSet resultado = preparar.executeQuery();
			
			while(resultado.next()){
				//criando objeto
				Cliente cli = new Cliente();
				//populando objeto
				cli.setId(resultado.getInt("id"));
				cli.setNomeFantasia(resultado.getString("nomefantasia"));
				cli.setRazaoSocial(resultado.getString("razaosocial"));
				cli.setCpfCnpj(resultado.getString("cpfcnpj"));
				cli.setRgIe(resultado.getString("rgie"));
				cli.setCep(resultado.getString("cep"));
				cli.setEndereco(resultado.getString("endereco"));
				cli.setBairro(resultado.getString("bairro"));
				cli.setCidade(resultado.getString("cidade"));
				cli.setComplemento(resultado.getString("complemento"));
				cli.setDataNascimento(resultado.getDate("datanascimento"));
				cli.setTelResidencial(resultado.getString("telresidencial"));
				cli.setCelular(resultado.getString("celular"));
				cli.setOutroTelefone(resultado.getString("outrotelefone"));
				cli.setEmail(resultado.getString("email"));
				cli.setEstado(resultado.getString("estado"));
				
				lstCli.add(cli);
				
			}
		} catch (SQLException e) {
			System.out.println("DAO: erro ao selecionar cliente"+e.getMessage());
			e.printStackTrace();
		}
		return lstCli;
	}

}
