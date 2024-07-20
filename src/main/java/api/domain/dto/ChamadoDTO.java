package api.domain.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.Valid;
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
    @JsonFormat(pattern = "dd/MM//yyyy")         // formatar o padrao DATA
    private LocalDate dataAbertura = LocalDate.now();
    @JsonFormat(pattern = "dd/MM//yyyy")         // formatar o padrao DATA
    private LocalDate dataFechamento;
    private Integer prioridade;
    private Integer status;
    private String titulo;
    private String observacoes;
    private Integer tecnico;
    private Integer cliente;
    private String  nomeTecnico;
    private String  nomeCliente;

}
