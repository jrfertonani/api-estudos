package api.domain.Enums;

import lombok.Getter;

@Getter
public enum Prioridade {
    // aqui são os enums
    BAIXA(0,"aberto"),
    MEDIA(1,"andemento"),
    ALTA(2,"encerrado");

    //aqui as instancias
    private final Integer codigo;
    private final String descricao;

    //aqui construtor
    Prioridade(Integer codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    //aqui um codigo para verificar se existe ou não de enum
    //se existir retorna ele se não retorna uma exceção (não necessario)
    public static Prioridade toEnum(Integer cod){
        if( cod == null){
            return null;
        }
        for(Prioridade x : Prioridade.values()){
            if(cod.equals(x.getCodigo())){
                return x;
            }
        }
        throw new IllegalArgumentException("Prioridade inválido: " + cod);
    }

}
