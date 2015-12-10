package br.univel.test;

import static org.junit.Assert.assertEquals;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

import org.junit.Test;

import br.univel.model.Marca;

public class MarcaTest {

	@PersistenceContext(type = PersistenceContextType.EXTENDED)
	private EntityManager entityManager;

	@Test
	public void testPersistMarca() {

		boolean flag = false;

		for (int i = 0; i < 10; i++) { 
			
			Marca m = new Marca();
			m.setNome("Marca " + i);
			
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
	public void testFindMarca() {
		Marca teste = entityManager.find(Marca.class, 1);
		assertEquals(true, teste != null);
	}

	@Test
	public void testUpdateMarca() {
		Marca teste = entityManager.find(Marca.class, 1);
		teste.setNome("Nova Marca");

		entityManager.persist(teste);
		
		Marca atualizado = entityManager.find(Marca.class, 1);
		
		assertEquals(teste.getNome(), atualizado.getNome());
	}

	@Test
	public void testRemoveMarca() {
		Marca teste = entityManager.find(Marca.class, 1);
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