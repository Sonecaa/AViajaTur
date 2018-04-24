
package classesDAOpure;

import classesBEAN.Cliente;
import classesBEAN.Venda;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;


public class VendaDAO {

    public VendaDAO() {
    }
    
    public void create(Venda venda){
          EntityManagerFactory emf = Persistence.createEntityManagerFactory("PU");

        EntityManager em = emf.createEntityManager();
        
        em.getTransaction().begin();
        
        em.persist(venda);
        
        em.getTransaction().commit();
         
        em.close();
        emf.close();
    }
    
    public List<Venda> getVendasPorCliente(Cliente cliente) {
        List<Venda> vendas = new ArrayList<>();

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PU");

        EntityManager em = emf.createEntityManager();

        Query q = em.createQuery("SELECT v FROM Venda v WHERE v.fkCliente.idCliente = :id").setParameter("id", cliente.getIdCliente());
        
        vendas = q.getResultList();


        em.close();
        emf.close();

        return vendas;
    }
}
