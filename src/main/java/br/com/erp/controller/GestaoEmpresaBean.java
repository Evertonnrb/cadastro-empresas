package br.com.erp.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.br.erp.model.Empresa;

import br.com.erp.repository.Empresas;
import br.com.erp.util.FacesMessages;

@Named
@ViewScoped
public class GestaoEmpresaBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private List<Empresa> listaDeEmpresas;
	
	@Inject
	private Empresas empresas;	
	
	@Inject
	private FacesMessages mensagens;
	
	private String termoPesquisa;
	
	public String getTermoPesquisa() {
		return termoPesquisa;
	}
	
	public void setTermoPesquisa(String termoPesquisa) {
		this.termoPesquisa = termoPesquisa;
	}
	
	public void todasEmpresas() {
		listaDeEmpresas = empresas.findAll();
	}
	
	public void pesquisar() {	
		listaDeEmpresas = empresas.pesquisar(termoPesquisa);
		if(listaDeEmpresas.isEmpty()) {
			mensagens.info("A consulta não retornou resultados");
		}
	}
	
	public List<Empresa> getListaDeEmpresas() {
		return listaDeEmpresas;
	}
}
