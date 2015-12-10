package br.univel.test;

import static org.junit.Assert.assertEquals;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

import org.junit.Test;

import br.univel.model.Marca;
import br.univel.model.Modelo;

public class ModeloTest {

	@PersistenceContext(type = PersistenceContextType.EXTENDED)
	private EntityManager entityManager;

	@Test
	public void testPersistModelo() {

		boolean flag = false;

		for (int i = 0; i < 10; i++) { 
			
			Marca mc = new Marca();
			mc.setNome("Marca Modelo");
			
			try {
				entityManager.persist(mc);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			Modelo m = new Modelo();
			m.setNome("Modelo " + i);
			m.setMarca(mc);
			
			try {
				entityManager.persist(m);
				flag = true;
			} catch (Exception e) {
				e.printStackTrace();
				flag = false;
			}
		}
		assertEquals(true, flag);
	}

	@Test
	public void testFindModelo() {
		Modelo teste = entityManager.find(Modelo.class, 1);
		assertEquals(true, teste != null);
	}

	@Test
	public void testUpdateModelo() {
		Modelo teste = entityManager.find(Modelo.class, 1);
		
		Marca mc = new Marca();
		mc.setNome("Marca Modelo");
		
		try {
			entityManager.persist(mc);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		teste.setNome("Novo Modelo");
		teste.setMarca(mc);

		entityManager.persist(teste);
		
		Modelo atualizado = entityManager.find(Modelo.class, 1);
		
		assertEquals(teste.getNome(), atualizado.getNome());
		assertEquals(teste.getMarca().getId(), atualizado.getMarca().getId());
	}

	@Test
	public void testRemoveModelo() {
		Modelo teste = entityManager.find(Modelo.class, 1);
		boolean ok = false;
		try {
			entityManager.remove(teste);
			ok = true;
		}catch(Exception e){
			ok = true;
		}
		assertEquals(ok, true);
	}
}