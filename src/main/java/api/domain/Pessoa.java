package api.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@Data      @Entity
public abstract class Pessoa implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Integer id;
    protected String nome;
    @Column(unique = true)
    protected String cpf;
    @Column(unique = true)
    protected String email;

    @ElementCollection(fetch = FetchType.EAGER)   //  busca altomaticamente a lista
    @CollectionTable(name = "PERFIS")             // nome da tabela
    protected Set<Integer> perfis = new HashSet<Integer>();

    @JsonFormat(pattern = "dd/MM//yyyy")         // formatar o padram DATA
    protected LocalDate datacriacao = LocalDate.now();


    public Pessoa(Integer id, String nome, String cpf, String email) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
    }


}
