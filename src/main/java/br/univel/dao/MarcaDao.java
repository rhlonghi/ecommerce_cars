package br.univel.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import br.univel.model.Marca;

/**
 *  DAO for Marca
 */
@Stateless
public class MarcaDao
{
   @PersistenceContext(unitName = "ecommerce_cars-persistence-unit")
   private EntityManager em;

   public void create(Marca entity)
   {
      em.persist(entity);
   }

   public void deleteById(Long id)
   {
      Marca entity = em.find(Marca.class, id);
      if (entity != null)
      {
         em.remove(entity);
      }
   }

   public Marca findById(Long id)
   {
      return em.find(Marca.class, id);
   }

   public Marca update(Marca entity)
   {
      return em.merge(entity);
   }

   public List<Marca> listAll(Integer startPosition, Integer maxResult)
   {
      TypedQuery<Marca> findAllQuery = em.createQuery("SELECT DISTINCT m FROM Marca m ORDER BY m.id", Marca.class);
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
