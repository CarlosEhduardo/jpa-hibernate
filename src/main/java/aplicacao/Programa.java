package aplicacao;

import dominio.Pessoa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Programa {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-jpa");
        EntityManager em = emf.createEntityManager();

/*        Pessoa p1 = new Pessoa(null, "Carlos da Silva", "carlos@gmail.com");
        Pessoa p2 = new Pessoa(null, "Joaquim Torres", "joaquim@gmail.com");
        Pessoa p3 = new Pessoa(null, "Ana Maria", "ana@gmail.com");

        em.getTransaction().begin();
        em.persist(p1);
        em.persist(p2);
        em.persist(p3);
        em.getTransaction().commit();*/

        /*Pessoa p = em.find(Pessoa.class, 2);
        em.close();
        emf.close();
        System.out.println(p);*/


        /*Pessoa p = em.find(Pessoa.class, 2);
        em.getTransaction().begin();
        em.remove(p);
        em.getTransaction().commit();

        em.close();
        emf.close();*/

        Pessoa p = new Pessoa(null, "José Rodrigues", "jose@gmail.com");
        em.getTransaction().begin();
        em.persist(p);


        em.remove(p);
        em.getTransaction().commit();

        em.close();
        emf.close();

        System.out.println("Transação concluída");

//        System.out.println(p1);
//        System.out.println(p2);
//        System.out.println(p3);
    }
}
