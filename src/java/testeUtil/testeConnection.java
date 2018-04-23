
package testeUtil;


import classesBEAN.Cliente;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author aluno
 */
public class testeConnection {
    
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PU");

        EntityManager em = emf.createEntityManager();
        
        em.getTransaction().begin();
        
        Cliente c1 = new Cliente(0 , "marcelo","marcelo", true);
        
         em.persist(c1);
        
        em.getTransaction().commit();
         
        em.close();
        emf.close();
        
        
//        Marca m1 = new Marca(0, "FIAT", "Itália", 3);
//        Marca m2 = new Marca(0, "CITROEN", "Franca", 4);
//        Marca m3 = new Marca(0, "FORD", "EUA", 9);
//        Marca m4 = new Marca(0, "VW", "Alemanha", 1);
//        m1.setModeloList( new ArrayList<>() );
//        m1.getModeloList().add(new Modelo(0, "Sienna") );        
//        m1.getModeloList().add(new Modelo(0, "Freemont"));
//        m1.getModeloList().add(new Modelo(0, "Mobi"));
//        m1.getModeloList().add(new Modelo(0, "Uno"));
//        for (Modelo modelo : m1.getModeloList()) {
//            modelo.setMarca(m1);
//        }
//        
//        em.persist(m1);
//        em.persist(m2);
//        em.persist(m3);
//        em.persist(m4);
//        
//        em.getTransaction().commit();
//        
        
//        Usuario u1 = new Usuario(1, "Zezin", "ze@ze", "ze", "123", new Date(), true);
//        Usuario u2 = new Usuario(1, "Pedrin", "pe@pe", "pe", "123", new Date(), true);
//        
//        em.getTransaction().begin();
//        em.persist(u1);
//        em.persist(u2);
//        em.getTransaction().commit();

//        Usuario us = em.find(Usuario.class, 2);
//        
//        System.out.println("==>"+us.getNome());
//        
//        us.setEmail("bla@bla.bla");
//        
//        em.getTransaction().begin();
//        em.persist(us);
//        //em.remove(us);
//        em.getTransaction().commit();
        
//        Query q = em.createQuery("select count(u) from Usuario u where "
//                + "u.ehAdministrador = true");
//
//        Long qtde = (Long) q.getSingleResult();
//        System.out.println("Quantidade: "+qtde);
        
//        List<String> lista = q.getResultList();
//        for (String usuario : lista) {
//            System.out.println("===>"+usuario);
//        }
//        List<Usuario> lista = q.getResultList();
//        for (Usuario usuario : lista) {
//            System.out.println("===>"+usuario.getNome());
//        }
        
    }
    
}

