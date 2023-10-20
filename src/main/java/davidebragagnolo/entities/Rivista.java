package davidebragagnolo.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.util.UUID;

@Entity
@NoArgsConstructor
@Getter
@Setter
@DiscriminatorValue("riviste")
public class Rivista extends ElementoCatalogo {
    @Enumerated(EnumType.STRING)
    private Periodicita periodicita;

    public Rivista(UUID id, UUID codiceIsbn, String titolo, Integer annoPubblicazione, Integer numeroPagine, Periodicita periodicita) {
        super(id, codiceIsbn, titolo, annoPubblicazione, numeroPagine);
        this.periodicita = periodicita;
    }

    @Override
    public String toString() {
        return "Rivista{" +
                "periodicita=" + periodicita +
                ", id=" + id +
                ", codiceIsbn=" + codiceIsbn +
                ", titolo='" + titolo + '\'' +
                ", annoPubblicazione=" + annoPubblicazione +
                ", numeroPagine=" + numeroPagine +
                '}';
    }
}
