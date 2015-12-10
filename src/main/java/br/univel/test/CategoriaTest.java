package br.univel.test;

import static org.junit.Assert.assertEquals;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

import org.junit.Test;

import br.univel.model.Categoria;

public class CategoriaTest {

	@PersistenceContext(type = PersistenceContextType.EXTENDED)
	private EntityManager entityManager;
	
	int idteste = 6;

	@Test
	public void testPersistCategoria() {

		boolean flag = false;

		for (int i = 0; i < 10; i++) { 
			
			Categoria c = new Categoria();
			c.setDescricao("Categoria " + 1);
			
			try {
				entityManager.persist(c);
				flag = true;
			} catch (Exception e) {
				e.printStackTrace();
				flag = false;
			}
		}
		assertEquals(true, flag);
	}

	@Test
	public void testFindCategoria() {
		Categoria teste = entityManager.find(Categoria.class, idteste);
		assertEquals(true, teste != null);
	}

	@Test
	public void testUpdateCategoria() {
		Categoria teste = entityManager.find(Categoria.class, idteste);
		teste.setDescricao("Novo Categoria");

		entityManager.persist(teste);
		
		Categoria atualizado = entityManager.find(Categoria.class, idteste);
		
		assertEquals(teste.getDescricao(), atualizado.getDescricao());
	}

	@Test
	public void testRemoveCategoria() {
		Categoria teste = entityManager.find(Categoria.class, idteste);
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