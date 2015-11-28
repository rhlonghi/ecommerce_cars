package br.univel.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import br.univel.model.Carro;

/**
 *  DAO for Carro
 */
@Stateless
public class CarroDao
{
   @PersistenceContext(unitName = "ecommerce_cars-persistence-unit")
   private EntityManager em;

   public void create(Carro entity)
   {
      em.persist(entity);
   }

   public void deleteById(Long id)
   {
      Carro entity = em.find(Carro.class, id);
      if (entity != null)
      {
         em.remove(entity);
      }
   }

   public Carro findById(Long id)
   {
      return em.find(Carro.class, id);
   }

   public Carro update(Carro entity)
   {
      return em.merge(entity);
   }

   public List<Carro> listAll(Integer startPosition, Integer maxResult)
   {
      TypedQuery<Carro> findAllQuery = em.createQuery("SELECT DISTINCT c FROM Carro c LEFT JOIN FETCH c.categoria ORDER BY c.id", Carro.class);
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
