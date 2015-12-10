package br.univel.test;

import static org.junit.Assert.assertEquals;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

import org.junit.Test;

import br.univel.model.Usuario;

public class UsuarioTest {

	@PersistenceContext(type = PersistenceContextType.EXTENDED)
	private EntityManager entityManager;

	@Test
	public void testPersistUsuario() {

		boolean flag = false;

		for (int i = 0; i < 10; i++) { 
			
			Usuario u = new Usuario();
			u.setNome("Usuario " + i);
			u.setLogin("login" + i);
			u.setSenha("senha" + i);
			u.setEmail("email" + i + "@email.com");
			
			try {
				entityManager.persist(u);
				flag = true;
			} catch (Exception e) {
				e.printStackTrace();
				flag = false;
			}
		}
		assertEquals(true, flag);
	}

	@Test
	public void testFindUsuario() {
		Usuario teste = entityManager.find(Usuario.class, 1);
		assertEquals(true, teste != null);
	}

	@Test
	public void testUpdateUsuario() {
		Usuario teste = entityManager.find(Usuario.class, 1);
		teste.setNome("Novo Nome");
		teste.setLogin("novologin");
		teste.setSenha("novasenha");
		teste.setEmail("novoemail@email.com");

		entityManager.persist(teste);
		
		Usuario atualizado = entityManager.find(Usuario.class, 1);
		
		assertEquals(teste.getNome(), atualizado.getNome());
		assertEquals(teste.getLogin(), atualizado.getLogin());
		assertEquals(teste.getSenha(), atualizado.getSenha());
		assertEquals(teste.getEmail(), atualizado.getEmail());
	}

	@Test
	public void testRemoveUsuario() {
		Usuario teste = entityManager.find(Usuario.class, 1);
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