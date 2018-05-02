
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
    
    public int GetVagasDisponiveis(int idPassagem){
        int VagasDisponiveis = 0;
        int totalVagasOni = 0;
        int totalNumVendidasPass = 0;
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PU");
        EntityManager em = emf.createEntityManager();
        
        Query q = em.createQuery("SELECT l.fkOnibus.numPoltronas FROM Passagem l WHERE l.idPassagem = :id").setParameter("id", idPassagem);
        List<Integer> listaDeInteiros = q.getResultList();
        totalVagasOni = listaDeInteiros.get(0);
        
        Query q2 = em.createQuery("SELECT v FROM Venda v WHERE v.fkPassagem.idPassagem = :id").setParameter("id", idPassagem);
        totalNumVendidasPass = q2.getResultList().size();
        
        VagasDisponiveis = totalVagasOni - totalNumVendidasPass;
        
        em.close();
        emf.close();
        
        return VagasDisponiveis;
    }
    
    public Double GetLucroPorPassagem(int idPassagem){
        Double TotalLucro = 0D;

        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PU");
        EntityManager em = emf.createEntityManager();
        
        Query q = em.createQuery("SELECT v.fkPassagem.valor FROM Venda v WHERE v.fkPassagem.idPassagem = :id").setParameter("id", idPassagem);
        List<Double> listaDeInteiros = q.getResultList();
        for (int i = 0; i < listaDeInteiros.size(); i++) {
            TotalLucro = TotalLucro + listaDeInteiros.get(i);
        }
        
        
        
        em.close();
        emf.close();
        
        return TotalLucro;
    }
    
    
}
