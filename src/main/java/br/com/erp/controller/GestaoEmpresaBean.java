package br.com.erp.controller;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import com.br.erp.enuns.TipoEmpresa;
import com.br.erp.model.Empresa;

@Named
@ViewScoped
public class GestaoEmpresaBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	public void salvar() {
		System.out.println("Empresa "+empresa.getNomeFantasia()+" Razão Social "+empresa.getRazaoSocial()+""
				+ " Tipo "+empresa.getTipo());
	}
	
	private Empresa empresa = new Empresa();
	
	public Empresa getEmpresa() {
		return empresa;
	}
	
	public TipoEmpresa[] getTipoEmpresa() {
		return TipoEmpresa.values();
	}
	
	public String ajuda() {
		return "AjudaGestaoEmpresas?faces-redirect=true";
	}
}
