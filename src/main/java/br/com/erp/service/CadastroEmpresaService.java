package br.com.erp.service;

import java.io.Serializable;

import javax.inject.Inject;

import com.br.erp.model.Empresa;

import br.com.erp.repository.Empresas;
import br.com.erp.util.Transactional;

public class CadastroEmpresaService implements Serializable{

	private static final long serialVersionUID = 1L;

	@Inject
	private Empresas empresas;
	
	@Transactional
	public void salvar(Empresa empresa) {
		empresas.guardar(empresa);
	}
	
	@Transactional
	public void excluir(Empresa empresa) {
		empresas.remover(empresa);
	}
}
