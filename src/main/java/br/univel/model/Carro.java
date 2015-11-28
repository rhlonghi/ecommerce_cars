package br.univel.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Version;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "carro")
@XmlRootElement
public class Carro implements Serializable
{

   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   @Column(name = "id", updatable = false, nullable = false)
   private Long id;
   @Version
   @Column(name = "version")
   private int version;

   @Column(name = "descricao")
   private String descricao;

   @Column(name = "ano")
   private Integer ano;

   @Column(name = "km")
   private Double km;

   @Column(name = "cor")
   private String cor;

   @Column(name = "nportas")
   private Integer nportas;

   @Column(name = "combustivel")
   private String combustivel;

   @Column(name = "cambio")
   private String cambio;

   @ManyToOne(fetch = FetchType.LAZY)
   private Categoria categoria;

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
      if (!(obj instanceof Carro))
      {
         return false;
      }
      Carro other = (Carro) obj;
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

   public String getDescricao()
   {
      return descricao;
   }

   public void setDescricao(String descricao)
   {
      this.descricao = descricao;
   }

   public Integer getAno()
   {
      return ano;
   }

   public void setAno(Integer ano)
   {
      this.ano = ano;
   }

   public Double getKm()
   {
      return km;
   }

   public void setKm(Double km)
   {
      this.km = km;
   }

   public String getCor()
   {
      return cor;
   }

   public void setCor(String cor)
   {
      this.cor = cor;
   }

   public Integer getNportas()
   {
      return nportas;
   }

   public void setNportas(Integer nportas)
   {
      this.nportas = nportas;
   }

   public String getCombustivel()
   {
      return combustivel;
   }

   public void setCombustivel(String combustivel)
   {
      this.combustivel = combustivel;
   }

   public String getCambio()
   {
      return cambio;
   }

   public void setCambio(String cambio)
   {
      this.cambio = cambio;
   }

   @Override
   public String toString()
   {
      String result = getClass().getSimpleName() + " ";
      if (descricao != null && !descricao.trim().isEmpty())
         result += "descricao: " + descricao;
      if (ano != null)
         result += ", ano: " + ano;
      if (km != null)
         result += ", km: " + km;
      if (cor != null && !cor.trim().isEmpty())
         result += ", cor: " + cor;
      if (nportas != null)
         result += ", nportas: " + nportas;
      if (combustivel != null && !combustivel.trim().isEmpty())
         result += ", combustivel: " + combustivel;
      if (cambio != null && !cambio.trim().isEmpty())
         result += ", cambio: " + cambio;
      return result;
   }

   public Categoria getCategoria()
   {
      return this.categoria;
   }

   public void setCategoria(final Categoria categoria)
   {
      this.categoria = categoria;
   }
}