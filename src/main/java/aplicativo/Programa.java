package aplicativo;

import dominio.Pessoa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Programa {
    public static void main(String[] args) {
        Pessoa p1 = new Pessoa(null, "carlos da silva", "carlos@gmail.com");
        Pessoa p2 = new Pessoa(null, "joaquin torres", "joaquin@gmail.com");
        Pessoa p3 = new Pessoa(null, "ana maria", "ana@gamil.com");

       EntityManagerFactory emf = Persistence.createEntityManagerFactory("aprendendo-jpa");
       EntityManager em = emf.createEntityManager();
       em.getTransaction().begin();
       em.persist(p1);
       em.persist(p2);
       em.persist(p3);
       em.getTransaction().commit();
       System.out.println("Salvo!");

        Pessoa p = em.find(Pessoa.class, 2);
        System.out.println(p);
        em.close();
        emf.close();
    }
}
