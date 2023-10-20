package davidebragagnolo.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.UUID;

@Entity
    @Table(name = "elementi_catalogo")
    @Inheritance(strategy = InheritanceType.JOINED)
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
}
