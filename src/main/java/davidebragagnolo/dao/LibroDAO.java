package davidebragagnolo.dao;

import davidebragagnolo.entities.Libro;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.UUID;

public class LibroDAO {
    private EntityManagerFactory entityManagerFactory;

    public LibroDAO(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }

    public void create(Libro libro) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(libro);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public void save(Libro libro) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(libro);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public Libro getById(UUID uuid) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Libro ele = entityManager.find(Libro.class, uuid);
        entityManager.close();
        return ele;
    }

    public void delete(UUID uuid) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Libro libro = entityManager.find(Libro.class, uuid);
        if (libro != null) {
            entityManager.remove(libro);
        }
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public void refresh(Libro libro) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        libro = entityManager.merge(libro);
        entityManager.refresh(libro);
        entityManager.close();
    }

    public List<Libro> findAll() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        TypedQuery<Libro> query = entityManager.createQuery("SELECT l FROM Libro l", Libro.class);
        List<Libro> libri = query.getResultList();
        entityManager.close();
        return libri;
    }
}
