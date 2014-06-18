package util;

import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.context.FacesContext;

public class JSFUtil {
	
	public static void addMsg(Severity severity, String summary, String msg){
		FacesMessage fm = new FacesMessage(severity, summary, msg);
		FacesContext.getCurrentInstance().addMessage(null, fm);
	}
	
	public static void addMsg(String summary, String msg){
		FacesMessage fm = new FacesMessage(summary, msg);
		FacesContext.getCurrentInstance().addMessage(null, fm);
	}
	
	public static void addMsg(String msg){
		FacesMessage fm = new FacesMessage(msg);
		FacesContext.getCurrentInstance().addMessage(null, fm);
	}
	public static void mensagemOk(String mensagem1, String mensagem2) {
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
                mensagem1, mensagem2));
    }

    public static void mensagemErros(String mensagem1, String mensagem2) {
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
                mensagem1, mensagem2));
    }
}