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
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author Marcelo
 */
@Entity
public class Onibus implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idOnibus;
    @ManyToOne
    @JoinColumn(name = "idLinha")
    private Linha fkLinha;    
    @OneToMany(mappedBy = "fkOnibus", targetEntity = Passagem.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Passagem> passagens;
    private int numPoltronas;

    public Onibus() {
    }
    
    
    
    public Onibus(Integer idOnibus, Linha fkLinha, int numPoltronas) {
        this.idOnibus = idOnibus;
        this.fkLinha = fkLinha;
        this.numPoltronas = numPoltronas;
    }
    
    
    
    public List<Passagem> getPassagens() {
        return passagens;
    }

    public void setPassagens(List<Passagem> passagens) {
        this.passagens = passagens;
    }
    
     public Linha getFkLinha() {
        return fkLinha;
    }

    public void setFkLinha(Linha fkLinha) {
        this.fkLinha = fkLinha;
    }
    
    public int getNumPoltronas() {
        return numPoltronas;
    }

    public void setNumPoltronas(int numPoltronas) {
        this.numPoltronas = numPoltronas;
    }

    public Integer getIdOnibus() {
        return idOnibus;
    }

    public void setIdOnibus(Integer idOnibus) {
        this.idOnibus = idOnibus;
    }

}
