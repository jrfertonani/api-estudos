package api.domain.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Valid
public class ChamadoDTO implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private Integer id;
    @JsonFormat(pattern = "dd/MM/yyyy")         // formatar o padrao DATA
    private LocalDate dataAbertura = LocalDate.now();
    @JsonFormat(pattern = "dd/MM/yyyy")         // formatar o padrao DATA
    private LocalDate dataFechamento;
    @NotNull(message = "O campo prioridade é requerido")
    private Integer prioridade;
    @NotNull(message = "O campo status é requerido")
    private Integer status;
    @NotNull(message = "O campo titulo é requerido")
    private String titulo;
    @NotNull(message = "O campo observacoes é requerido")
    private String observacoes;
    @NotNull(message = "O campo tecnico é requerido")
    private Integer tecnico;
    @NotNull(message = "O campo Cliente é requerido")
    private Integer cliente;
    private String  nomeTecnico;
    private String  nomeCliente;



}
