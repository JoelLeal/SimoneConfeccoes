package teste;

//import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import dao.ClienteDAO;
import model.Cliente;
import util.Datas;

public class TesteClienteDAO {
	
	public static void main(String args[]){
		//testeCadastarCliente();
		//testeAtualizarCliente();
		testeSelecionar();
	}
	
	//definindo o formato da data
	private static SimpleDateFormat fmt = new SimpleDateFormat("dd/MM/yyyy");
	
	private static void testeCadastarCliente(){
		//criando a string da data segundo o fornato
		String dataNasc = "05/11/1993"; 
		
		try {
		java.util.Date d = fmt.parse(dataNasc);
		
		Cliente cli = new Cliente();
		
		cli.setNomeFantasia("Alexandre Santana da Silva");
		cli.setRazaoSocial("");
		cli.setCpfCnpj("430.792.288-39");
		cli.setRgIe("48.796.612-0");
		cli.setCep("19.816-305");
		cli.setEndereco("Rua Lourival Servilha, 91");
		cli.setBairro("Jardim América");
		cli.setCidade("Quatá");
		cli.setEstado("SP");
		cli.setComplemento("");
		
		cli.setDataNascimento(Datas.javaDateParaSqlDate(d));
		
		cli.setTelResidencial("18-3324-6805");
		cli.setCelular("18-99726-2442");
		cli.setOutroTelefone("18-3324-5403");
		cli.setEmail("joel_19lakers@hotmail.com");
		
		
		ClienteDAO cliDAO = new ClienteDAO();
		
		cliDAO.inserir(cli);
		} catch (Exception e) {
			System.out.println("Erro TesteClienteDAO");
			e.printStackTrace();
		}
	}
	
	public static void testeAtualizarCliente(){
		String dataNasc = "27/12/1948";
		
		try {
			java.util.Date d = fmt.parse(dataNasc);
			
			Cliente cli = new Cliente();
			
			cli.setId(5);
			cli.setNomeFantasia("Alexandre Santana da Silva");
			cli.setRazaoSocial("");
			cli.setCpfCnpj("430.792.288-39");
			cli.setRgIe("48.796.612-0");
			cli.setCep("19.816-305");
			cli.setEndereco("Rua Lourival Servilha, 91");
			cli.setBairro("Jardim América");
			cli.setCidade("Quatá");
			cli.setEstado("SP");
			cli.setComplemento("");
			
			cli.setDataNascimento(Datas.javaDateParaSqlDate(d));
			
			cli.setTelResidencial("18-3324-6805");
			cli.setCelular("18-99726-2442");
			cli.setOutroTelefone("18-3324-5403");
			cli.setEmail("joel_19lakers@hotmail.com");
			
			ClienteDAO cliDAO = new ClienteDAO();
			cliDAO.atualizar(cli);
			
		} catch (ParseException e) {
			System.out.println("Teste. Erro ao atualizar: "+e.getMessage());
			e.printStackTrace();
		}
	}
	
	public static void testeSelecionar(){
		ClienteDAO cliDAO = new ClienteDAO();
		List<Cliente> lista = cliDAO.buscarTodos();
		
		for(Cliente c: lista){
			System.out.println(c.getNomeFantasia());
		}
	}
}
