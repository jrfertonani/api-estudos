package api.domain;

import api.domain.Enums.Prioridade;
import api.domain.Enums.Status;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data      @Entity
public class Chamado implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @JsonFormat(pattern = "dd/MM//yyyy")         // formatar o padram DATA
    private LocalDate dataAbertura = LocalDate.now();
    @JsonFormat(pattern = "dd/MM//yyyy")         // formatar o padram DATA
    private LocalDate dataFechamento;

    private Prioridade prioridade;
    private Status status;
    private String titulo;
    private String observacoes;

    @ManyToOne//relacionamento entre classes  - e em tecnico tera uma lista de chamados OneToMany(mapperdyBy = "tecnico")
    @JoinColumn(name = "tecnico_id")
    private Tecnico tecnico;

    @ManyToOne//relacionamento entre classes  - e em tecnico tera uma lista de chamados OneToMany(mapperdyBy = "cliente")
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

}
