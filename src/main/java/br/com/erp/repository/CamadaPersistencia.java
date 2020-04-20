package br.com.erp.repository;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.br.erp.enuns.TipoEmpresa;
import com.br.erp.model.Empresa;
import com.br.erp.model.RamoAtividade;

public class CamadaPersistencia {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("CursoPU");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		
		RamoAtividades rm = new RamoAtividades(em);
		Empresas empresas = new Empresas(em);
		
		List<RamoAtividade> listaAtividades = rm.pesquisar("");
		List<Empresa> listaEmpresas = empresas.pesquisar("");
		System.out.println(listaAtividades);
		System.out.println(listaEmpresas);
		
		Empresa empresa = new Empresa();
		empresa.setNomeFantasia("Langerie sex Shop");
		empresa.setCnpj("21.123.123/00");
		empresa.setRazaoSocial("Empresa de sex shop");
		empresa.setTipo(TipoEmpresa.MEI);
		empresa.setDataFundacao(new Date());
		empresa.setRamoAtividade(listaAtividades.get(8));
		
		
		
		empresas.guardar(empresa);
		
		em.getTransaction().commit();
	
		List<Empresa> ems= empresas.pesquisar("");
		System.out.println(ems);
	}

}
