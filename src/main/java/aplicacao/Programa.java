package aplicacao;

import dominio.Pessoa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Programa {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-jpa");
        EntityManager em = emf.createEntityManager();

        /*
         * Use apenas uma transação por vez para melhor visualização
         *
         * Transação específica para inserir no banco de dados
         */

        Pessoa p1 = new Pessoa(null, "Carlos da Silva", "carlos@gmail.com");
        Pessoa p2 = new Pessoa(null, "Joaquim Torres", "joaquim@gmail.com");
        Pessoa p3 = new Pessoa(null, "Ana Maria", "ana@gmail.com");

        System.out.println(p1);
        System.out.println(p2);
        System.out.println(p3);

        em.getTransaction().begin();
        em.persist(p1);
        em.persist(p2);
        em.persist(p3);
        em.getTransaction().commit();

        /*
         * Transação específica para consultar por id no banco de dados
         */

        Pessoa p4 = em.find(Pessoa.class, 2);
        em.close();
        emf.close();
        System.out.println(p4);


        /*
         * Transação específica para deletar no banco de dados por objeto monitorado recuperado
         */

        Pessoa p = em.find(Pessoa.class, 2);
        em.getTransaction().begin();
        em.remove(p);
        em.getTransaction().commit();

        em.close();
        emf.close();

        /*
         * Transação específica para deletar no banco de dados por objeto monitorado inserido
         */

        Pessoa p5 = new Pessoa(null, "José Rodrigues", "jose@gmail.com");
        em.getTransaction().begin();
        em.persist(p5);


        em.remove(p5);
        em.getTransaction().commit();

        em.close();
        emf.close();

        System.out.println("Transação concluída");
    }
}
