package classesDAOpure;

import classesBEAN.Cliente;
import classesBEAN.Linha;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class LinhaDAO {

    public LinhaDAO() {
    }

    public void create(Linha lin) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PU");

        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        em.persist(lin);

        em.getTransaction().commit();

        em.close();
        emf.close();
    }

    public List<Linha> getAllLinhas() {
        List<Linha> linhas = new ArrayList<>();

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PU");

        EntityManager em = emf.createEntityManager();

        Query q = em.createQuery("SELECT l FROM Linha l ");
        linhas = q.getResultList();

        em.close();
        emf.close();

        return linhas;
    }

    public Linha getSingleLinha(Integer id) {
        Linha linha = null;

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PU");

        EntityManager em = emf.createEntityManager();

        Query q = em.createQuery("SELECT l FROM Linha l WHERE l.idLinha = :id").setParameter("id", id);
        try {
            linha = (Linha) q.getSingleResult();
        } catch (Exception e) {
             linha = (Linha) (Object) q.getSingleResult();
        }

        em.close();
        emf.close();

        return linha;
    }
}
