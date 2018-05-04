package classesDAOpure;

import classesBEAN.Cliente;
import classesBEAN.Venda;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

public class VendaDAO {

    public VendaDAO() {
    }

    public void create(Venda venda) {
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

    public List<Venda> getAllVendas() {
        List<Venda> vendas = new ArrayList<>();

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PU");

        EntityManager em = emf.createEntityManager();

        Query q = em.createQuery("SELECT v FROM Venda v");

        vendas = q.getResultList();

        em.close();
        emf.close();

        return vendas;
    }

    public Double GetLucroByMes(int mes, int ano) {
        Double lucroMensal = 0D;

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PU");

        EntityManager em = emf.createEntityManager();
        Date start = new Date();
        start.setDate(01);
        start.setMonth(mes);
        start.setYear(ano);
        Date end  = new Date();
        end.setDate(31);
        end.setMonth(mes);
        end.setYear(ano);
      
        Query q = em.createQuery("SELECT v.fkPassagem.valor FROM Venda v WHERE v.dataEhoraVenda BETWEEN :start AND :end");
        q.setParameter("start", start);
        q.setParameter("end", end);
        List<Double> listaDeDoubles = q.getResultList();
        
        for (int i = 0; i < q.getResultList().size(); i++) {
           lucroMensal = lucroMensal + listaDeDoubles.get(i);
        }
        
        em.close();
        emf.close();

        return lucroMensal;
    }
}
