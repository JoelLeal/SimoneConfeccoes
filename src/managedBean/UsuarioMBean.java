package managedBean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import model.Usuario;

@ManagedBean(name = "UsuarioMBean")
@RequestScoped
public class UsuarioMBean {
	private Usuario usuario;

	public UsuarioMBean(){
		//teste
		System.out.println("### Criando UsuarioMBean ###");
		usuario = new Usuario();
		usuario.setLogin("UsuarioMBeanJoelTeste");
		usuario.setSenha("123");
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}
