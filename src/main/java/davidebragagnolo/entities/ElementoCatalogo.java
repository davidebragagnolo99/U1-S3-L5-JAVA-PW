package davidebragagnolo.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.UUID;

@Entity
    @Table(name = "elementi_catalogo")
    @Inheritance(strategy = InheritanceType.SINGLE_TABLE)
    @NoArgsConstructor
    @Getter
    @Setter

public class ElementoCatalogo {
        @Id
        protected UUID id;
        protected UUID codiceIsbn;
        protected String titolo;
        protected Integer annoPubblicazione;
        protected Integer numeroPagine;

    public ElementoCatalogo(UUID id, UUID codiceIsbn, String titolo, Integer annoPubblicazione, Integer numeroPagine) {
        this.id = id;
        this.codiceIsbn = codiceIsbn;
        this.titolo = titolo;
        this.annoPubblicazione = annoPubblicazione;
        this.numeroPagine = numeroPagine;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getCodiceIsbn() {
        return codiceIsbn;
    }

    public void setCodiceIsbn(UUID codiceIsbn) {
        this.codiceIsbn = codiceIsbn;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public Integer getAnnoPubblicazione() {
        return annoPubblicazione;
    }

    public void setAnnoPubblicazione(Integer annoPubblicazione) {
        this.annoPubblicazione = annoPubblicazione;
    }

    public Integer getNumeroPagine() {
        return numeroPagine;
    }

    public void setNumeroPagine(Integer numeroPagine) {
        this.numeroPagine = numeroPagine;
    }
}
