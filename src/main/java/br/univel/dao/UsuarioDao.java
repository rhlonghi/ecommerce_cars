package br.univel.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import br.univel.model.Usuario;

/**
 *  DAO for Usuario
 */
@Stateless
public class UsuarioDao
{
   @PersistenceContext(unitName = "ecommerce_cars-persistence-unit")
   private EntityManager em;

   public void create(Usuario entity)
   {
      em.persist(entity);
   }

   public void deleteById(Long id)
   {
      Usuario entity = em.find(Usuario.class, id);
      if (entity != null)
      {
         em.remove(entity);
      }
   }

   public Usuario findById(Long id)
   {
      return em.find(Usuario.class, id);
   }

   public Usuario update(Usuario entity)
   {
      return em.merge(entity);
   }

   public List<Usuario> listAll(Integer startPosition, Integer maxResult)
   {
      TypedQuery<Usuario> findAllQuery = em.createQuery("SELECT DISTINCT u FROM Usuario u ORDER BY u.id", Usuario.class);
      if (startPosition != null)
      {
         findAllQuery.setFirstResult(startPosition);
      }
      if (maxResult != null)
      {
         findAllQuery.setMaxResults(maxResult);
      }
      return findAllQuery.getResultList();
   }
}
