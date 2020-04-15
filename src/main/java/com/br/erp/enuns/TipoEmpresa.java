package com.br.erp.enuns;

public enum TipoEmpresa {
	
	MEI("Microempreendedor individual"),
	EIRELI("Empresa indivídual de responsábilidade limitada"),
	LTDA("Sociedade limitada"),
	SA("Sociedade anônima");
	
	private String descricao;
	
	private TipoEmpresa(String descricao) {
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return descricao;
	}
}
