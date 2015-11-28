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

@Entity
@Table(name = "item")
public class Item implements Serializable
{

   @Id
   @GeneratedValue(strategy = GenerationType.SEQUENCE)
   @Column(name = "id", updatable = false, nullable = false)
   private Long id;
   @Version
   @Column(name = "version")
   private int version;

   @Column(name = "idCarro")
   private Integer idCarro;

   @Column(name = "descricaoCarro")
   private String descricaoCarro;

   @Column(name = "valorCarro")
   private Double valorCarro;

   @Column(name = "quantidade")
   private Integer quantidade;

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
      if (!(obj instanceof Item))
      {
         return false;
      }
      Item other = (Item) obj;
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

   public Integer getIdCarro()
   {
      return idCarro;
   }

   public void setIdCarro(Integer idCarro)
   {
      this.idCarro = idCarro;
   }

   public String getDescricaoCarro()
   {
      return descricaoCarro;
   }

   public void setDescricaoCarro(String descricaoCarro)
   {
      this.descricaoCarro = descricaoCarro;
   }

   public Double getValorCarro()
   {
      return valorCarro;
   }

   public void setValorCarro(Double valorCarro)
   {
      this.valorCarro = valorCarro;
   }

   public Integer getQuantidade()
   {
      return quantidade;
   }

   public void setQuantidade(Integer quantidade)
   {
      this.quantidade = quantidade;
   }

   @Override
   public String toString()
   {
      String result = getClass().getSimpleName() + " ";
      if (idCarro != null)
         result += "idCarro: " + idCarro;
      if (descricaoCarro != null && !descricaoCarro.trim().isEmpty())
         result += ", descricaoCarro: " + descricaoCarro;
      if (valorCarro != null)
         result += ", valorCarro: " + valorCarro;
      if (quantidade != null)
         result += ", quantidade: " + quantidade;
      return result;
   }
}