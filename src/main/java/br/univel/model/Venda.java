package br.univel.model;

import javax.persistence.Entity;
import java.io.Serializable;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import javax.persistence.Version;
import java.lang.Override;
import java.sql.Date;
import br.univel.model.Usuario;
import javax.persistence.ManyToOne;
import javax.persistence.FetchType;
import br.univel.model.Item;
import java.util.Set;
import java.util.HashSet;
import javax.persistence.ManyToMany;

@Entity
@Table(name = "venda")
public class Venda implements Serializable
{

   @Id
   @GeneratedValue(strategy = GenerationType.SEQUENCE)
   @Column(name = "id", updatable = false, nullable = false)
   private Long id;
   @Version
   @Column(name = "version")
   private int version;

   @Column(name = "data")
   private Date data;

   @Column(name = "total")
   private Double total;

   @ManyToOne(fetch = FetchType.LAZY)
   private Usuario usuario;

   @ManyToMany
   private Set<Item> itens = new HashSet<Item>();

   public Long getId()
   {
      return this.id;
   }

   public void setId(final Long id)
   {
      this.id = id;
   }

   public int getVersion()
   {
      return this.version;
   }

   public void setVersion(final int version)
   {
      this.version = version;
   }

   @Override
   public boolean equals(Object obj)
   {
      if (this == obj)
      {
         return true;
      }
      if (!(obj instanceof Venda))
      {
         return false;
      }
      Venda other = (Venda) obj;
      if (id != null)
      {
         if (!id.equals(other.id))
         {
            return false;
         }
      }
      return true;
   }

   @Override
   public int hashCode()
   {
      final int prime = 31;
      int result = 1;
      result = prime * result + ((id == null) ? 0 : id.hashCode());
      return result;
   }

   public Date getData()
   {
      return data;
   }

   public void setData(Date data)
   {
      this.data = data;
   }

   public Double getTotal()
   {
      return total;
   }

   public void setTotal(Double total)
   {
      this.total = total;
   }

   @Override
   public String toString()
   {
      String result = getClass().getSimpleName() + " ";
      if (total != null)
         result += "total: " + total;
      return result;
   }

   public Usuario getUsuario()
   {
      return this.usuario;
   }

   public void setUsuario(final Usuario usuario)
   {
      this.usuario = usuario;
   }

   public Set<Item> getItens()
   {
      return this.itens;
   }

   public void setItens(final Set<Item> itens)
   {
      this.itens = itens;
   }
}