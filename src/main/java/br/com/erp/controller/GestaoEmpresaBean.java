package br.com.erp.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.convert.Converter;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.br.erp.enuns.TipoEmpresa;
import com.br.erp.model.Empresa;
import com.br.erp.model.RamoAtividade;

import br.com.erp.repository.Empresas;
import br.com.erp.repository.RamoAtividades;
import br.com.erp.service.CadastroEmpresaService;
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
	
	@Inject
	private RamoAtividades ramoAtividades;
	
	@Inject
	private CadastroEmpresaService cadastroEmpresaService;
	
	private Empresa empresa;
	
	private String termoPesquisa;
	
	private Converter ramoAtividadeConverter;
	
	public void prepararNovaEmpresa() {
		empresa = new Empresa();
	}
	
	public void salvar() {
		cadastroEmpresaService.salvar(empresa);
		if(jaHouvePesquia()) {
			pesquisar();
		}
		mensagens.info("Empresa cadastrada com sucesso!");
	}
	
	public String getTermoPesquisa() {
		return termoPesquisa;
	}
	
	private boolean jaHouvePesquia() {
		return termoPesquisa != null && !"".equals(termoPesquisa); 
	}
	
	public void setTermoPesquisa(String termoPesquisa) {
		this.termoPesquisa = termoPesquisa;
	}
	
	public void todasEmpresas() {
		listaDeEmpresas = empresas.findAll();
	}
	
	public List<RamoAtividade> completarRamoAtividades(String termo){
		List<RamoAtividade> listaRamoAtividade = ramoAtividades.pesquisar(termo);
		ramoAtividadeConverter = new RamoAtividadeConverter(listaRamoAtividade);
		return listaRamoAtividade;
	}
	
	public void pesquisar() {	
		listaDeEmpresas = empresas.pesquisar(termoPesquisa);
		if(listaDeEmpresas.isEmpty()) {
			mensagens.info("A consulta não retornou resultados");
		}
	}
	
	public TipoEmpresa[] getTipoEmpresa() {
		return TipoEmpresa.values();
	}
	
	public List<Empresa> getListaDeEmpresas() {
		return listaDeEmpresas;
	}
	
	public Converter getRamoAtividadeConverter() {
		return ramoAtividadeConverter;
	}
	
	public Empresa getEmpresa() {
		return empresa;
	}
	
	
}
