/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classesBEAN;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.eclipse.persistence.jpa.jpql.parser.DateTime;

/**
 *
 * @author Marcelo
 */
@Entity
public class Venda implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idVenda;
    @ManyToOne
    @JoinColumn(name = "idCliente")
    private Cliente fkCliente;
    @ManyToOne
    @JoinColumn(name = "idPassagem")
    private Passagem fkPassagem;
    @Temporal(TemporalType.TIMESTAMP)
    private java.util.Date dataEhoraVenda;

    public Venda() {
    }
    
    
    public Venda(Integer idVenda, Cliente fkCliente, Passagem fkPassagem, java.util.Date dataEhoraVenda) {
        this.idVenda = idVenda;
        this.fkCliente = fkCliente;
        this.fkPassagem = fkPassagem;
        this.dataEhoraVenda = dataEhoraVenda;
    }
    
    
    
    public Cliente getFkCliente() {
        return fkCliente;
    }

    public void setFkCliente(Cliente fkCliente) {
        this.fkCliente = fkCliente;
    }

    public Passagem getFkPassagem() {
        return fkPassagem;
    }

    public void setFkPassagem(Passagem fkPassagem) {
        this.fkPassagem = fkPassagem;
    }

    public java.util.Date getDataEhoraVenda() {
        return dataEhoraVenda;
    }

    public void setDataEhoraVenda(java.util.Date dataEhoraVenda) {
        this.dataEhoraVenda = dataEhoraVenda;
    }

    public Integer getIdVenda() {
        return idVenda;
    }

    public void setIdVenda(Integer idVenda) {
        this.idVenda = idVenda;
    }

}
