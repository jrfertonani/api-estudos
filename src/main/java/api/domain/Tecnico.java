package api.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Tecnico extends Pessoa {

    @JsonIgnore   // para evitar a serealização, chamar todos os chamados deste tecnico de uma vez
    @OneToMany(mappedBy = "tecnico")
    private List<Chamado> chamados = new ArrayList<>();




}
