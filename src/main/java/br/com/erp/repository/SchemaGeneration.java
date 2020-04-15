package br.com.erp.repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.br.erp.model.Empresa;

public class SchemaGeneration {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("CursoPU");
		EntityManager em = emf.createEntityManager();
		java.util.List<Empresa> empresas = em.createQuery("from Empresa", Empresa.class).getResultList();
		System.out.println(empresas);
		em.close();
		emf.close();
	}
}
