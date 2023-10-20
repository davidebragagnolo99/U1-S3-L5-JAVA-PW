package davidebragagnolo.catalogo;

import davidebragagnolo.dao.ElementoCatalogoDAO;
import davidebragagnolo.dao.PrestitoDAO;
import davidebragagnolo.dao.UtenteDAO;
import davidebragagnolo.entities.*;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
import java.util.logging.Logger;

@Slf4j
public class Application {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("catalogo_bibliografico");
        EntityManager entityManager = emf.createEntityManager();

        ElementoCatalogoDAO elementoDao = new ElementoCatalogoDAO(entityManager);
        PrestitoDAO prestitoDao = new PrestitoDAO(entityManager);
        UtenteDAO utenteDao = new UtenteDAO(entityManager);
        Logger log = Logger.getLogger();

        // Crea un nuovo libro
        Libro libro1 = new Libro(UUID.randomUUID(), UUID.randomUUID(), "L'ultima preghiera", 1954, 1178, "Tolkien",
                "Fantasy");
        log.info(libro1.toString());
        elementoDao.save(libro1);

        // Crea una nuova rivista
        Rivista rivista = new Rivista(UUID.randomUUID(), UUID.randomUUID(), "National Geographic", 2022, 100,
                Periodicita.MENSILE);
        elementoDao.save(rivista);

        // Crea un nuovo utente
        Utente utente = new Utente( "Mario", "Rossi", LocalDate.of(1990, 1, 1), "12345");
        log.info(utente.toString());
        utenteDao.save(utente);

        // Crea un nuovo prestito
        Prestito prestito = new Prestito(utente, libro1, LocalDate.now(),
                LocalDate.now().plusDays(30), null);
        log.info(prestito.toString());
        prestitoDao.save(prestito);

        // Cerca elementi del catalogo per ISBN
        ElementoCatalogo elementoTrovato = elementoDao.cercaPerIsbn(libro1.getCodiceIsbn());
        log.info("Elemento trovato: " + elementoTrovato.getTitolo());

        // Cerca elementi del catalogo per anno di pubblicazione
        List<ElementoCatalogo> elementiAnno = elementoDao.cercaPerAnnoPubblicazione(2022);
        log.info("Elementi trovati per anno di pubblicazione: " + elementiAnno.size());

        // Cerca libri per autore
        List<Libro> libriAutore = elementoDao.cercaPerAutore("J.R.R. Tolkien");
        log.info("Libri trovati per autore: " + libriAutore.size());

        // Cerca elementi del catalogo per titolo
        List<ElementoCatalogo> elementiTitolo = elementoDao.cercaPerTitolo("National Geographic");
        log.info(elementiTitolo.toString());

        entityManager.close();
        emf.close();
    }
}