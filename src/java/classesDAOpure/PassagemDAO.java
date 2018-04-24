
package classesDAOpure;

import classesBEAN.Passagem;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class PassagemDAO {

    public PassagemDAO() {
        
    }
     public void create(Passagem pass) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PU");

        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        em.persist(pass);

        em.getTransaction().commit();

        em.close();
        emf.close();
    }

    public List<Passagem> getAllPassagens() {
        List<Passagem> pass = new ArrayList<>();

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PU");

        EntityManager em = emf.createEntityManager();

        Query q = em.createQuery("SELECT p FROM Passagem p ");
        pass = q.getResultList();

        em.close();
        emf.close();

        return pass;
    }

    public Passagem getSinglePassagem(Integer id) {
        Passagem pass = null;

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PU");

        EntityManager em = emf.createEntityManager();

        Query q = em.createQuery("SELECT l FROM Passagem l WHERE l.idPassagem = :id").setParameter("id", id);
        try {
            pass = (Passagem) q.getSingleResult();
        } catch (Exception e) {
             pass = (Passagem) (Object) q.getSingleResult();
        }

        em.close();
        emf.close();

        return pass;
    }
    
    public List<Passagem> getPassagemPorOnibus(Integer idOnibus) {
        List<Passagem> pass = new ArrayList<>();

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PU");

        EntityManager em = emf.createEntityManager();

        Query q = em.createQuery("SELECT l FROM Passagem l WHERE l.fkOnibus.idOnibus = :id").setParameter("id", idOnibus);
        
        pass = q.getResultList();


        em.close();
        emf.close();

        return pass;
    }
}
