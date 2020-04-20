package br.com.erp.util;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class FacesMessages implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private void add(String msg,FacesMessage.Severity s) {
		FacesMessage mensagem = new FacesMessage(msg);
		mensagem.setSeverity(s);
		FacesContext.getCurrentInstance().addMessage(null, mensagem);
	}
	
	public void info(String msg) {
		add(msg,FacesMessage.SEVERITY_INFO);
	}
}
