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
import javax.persistence.OneToMany;

/**
 *
 * @author Marcelo
 */
@Entity
public class Cliente implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idCliente;
    private String nome;
    private String senha;
    private boolean permissao;
//    @OneToMany(mappedBy = "fkCliente", targetEntity = Venda.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//    private List<Venda> vendas;

    public Cliente() {
    }
    
    public Cliente(Integer idCliente, String nome, String senha, boolean permissao) {
        this.idCliente = idCliente;
        this.nome = nome;
        this.senha = senha;
        this.permissao = permissao;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
       
  
    
//    public List<Venda> getVendas() {
//        return vendas;
//    }
//
//    public void setVendas(List<Venda> vendas) {
//        this.vendas = vendas;
//    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public boolean isPermissao() {
        return permissao;
    }

    public void setPermissao(boolean permissao) {
        this.permissao = permissao;
    }
    
    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }
    
}
