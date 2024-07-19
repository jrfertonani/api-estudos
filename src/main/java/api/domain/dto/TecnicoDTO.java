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
import java.util.HashSet;
import java.util.Set;

@Getter     @Setter
@AllArgsConstructor
@NoArgsConstructor
@Valid
public class TecnicoDTO implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    protected Integer id;
    @NotNull(message = "O campo NOME é requerido!")
    protected String nome;
    @NotNull(message = "O campo CPF é requerido!")
    protected String cpf;
    @NotNull(message = "O campo EMAIL é requerido!")
    protected String email;
    protected Set<Integer> perfis = new HashSet<Integer>();

    @JsonFormat(pattern = "dd/MM//yyyy")         // formatar o padram DATA
    protected LocalDate datacriacao = LocalDate.now();


}
