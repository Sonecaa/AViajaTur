/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classesDAOpure;

import classesBEAN.Cliente;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author aluno
 */
public class ClienteDAO {

    public ClienteDAO() {
    }
    
    public void create(Cliente cli){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PU");

        EntityManager em = emf.createEntityManager();
        
        em.getTransaction().begin();
        
        em.persist(cli);
        
        em.getTransaction().commit();
         
        em.close();
        emf.close();
    }
    
}
