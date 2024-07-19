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
@Data      @Entity
public class Cliente extends Pessoa{

    @JsonIgnore   // para evitar a serealização, chamar todos os chamados de uma vez
    @OneToMany(mappedBy = "cliente")
    private List<Chamado> chamados = new ArrayList<>();

}
