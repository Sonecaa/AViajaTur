/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classesBEAN;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.eclipse.persistence.jpa.jpql.parser.DateTime;

/**
 *
 * @author Marcelo
 */
@Entity
@Table(name="Passagem")
public class Passagem implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idPassagem;
    @ManyToOne
    @JoinColumn(name = "idOnibus")
    private Onibus fkOnibus;
    @Temporal(TemporalType.TIMESTAMP)
    private java.util.Date dataEhora;
    private Double valor;
//    @OneToMany(mappedBy = "fkPassagem", targetEntity = Venda.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//    private List<Venda> vendas;

    public Passagem() {
    }

        
    public Passagem(Integer idPassagem, Onibus fkOnibus, java.util.Date dataEhora, Double valor) {
        this.idPassagem = idPassagem;
        this.fkOnibus = fkOnibus;
        this.dataEhora = dataEhora;
        this.valor = valor;
    }
    
    
//    public List<Venda> getVendas() {
//        return vendas;
//    }
//
//    public void setVendas(List<Venda> vendas) {
//        this.vendas = vendas;
//    }


    public Onibus getFkOnibus() {
        return fkOnibus;
    }

    public void setFkOnibus(Onibus fkOnibus) {
        this.fkOnibus = fkOnibus;
    }

    public java.util.Date getDataEhora() {
        return dataEhora;
    }

    public void setDataEhora(java.util.Date dataEhora) {
        this.dataEhora = dataEhora;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }
    
    public Integer getIdPassagem() {
        return idPassagem;
    }

    public void setIdPassagem(Integer idPassagem) {
        this.idPassagem = idPassagem;
    }
    
}
