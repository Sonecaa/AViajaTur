/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classesDAOpure;

import classesBEAN.Onibus;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author aluno
 */
public class OnibusDAO {

    public OnibusDAO() {
    }

    public void create(Onibus oni) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PU");

        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        em.persist(oni);

        em.getTransaction().commit();

        em.close();
        emf.close();
    }

    public List<Onibus> getAllOnibus() {
        List<Onibus> onibus = new ArrayList<>();

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PU");

        EntityManager em = emf.createEntityManager();

        Query q = em.createQuery("SELECT l FROM Onibus l ");
        onibus = q.getResultList();

        em.close();
        emf.close();

        return onibus;
    }
     public Onibus getSingleOnibus(Integer id) {
        Onibus oni = null;

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PU");

        EntityManager em = emf.createEntityManager();

        Query q = em.createQuery("SELECT o FROM Onibus o WHERE o.idOnibus = :id").setParameter("id", id);
        try {
            oni = (Onibus) q.getSingleResult();
        } catch (Exception e) {
             oni = (Onibus) (Object) q.getSingleResult();
        }

        em.close();
        emf.close();

        return oni;
    }
}
