package davidebragagnolo.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "prenotazioni")
@Getter
@Setter
@NoArgsConstructor

public class Prenotazione {
    @Id
    private UUID id;
    @ManyToOne
    @JoinColumn(name = "utente_id")
    private Utente utente;
    @ManyToOne
    @JoinColumn(name = "elemento_catalogo_id")
    private ElementoCatalogo elementoPrenotato;
    private LocalDate dataPrenotazione;

    public Prenotazione(UUID id, Utente utente, ElementoCatalogo elementoPrenotato, LocalDate dataPrenotazione) {
        this.id = id;
        this.utente = utente;
        this.elementoPrenotato = elementoPrenotato;
        this.dataPrenotazione = dataPrenotazione;
    }
}
