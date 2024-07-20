package api.domain.Enums;

import lombok.Getter;

@Getter
public enum Perfil {
    // aqui são os enums
    ADMIN(0,"ADMIN"),
    CLIENTE(1,"CLIENTE"),
    TECNICO(2,"TECNICO");

    //aqui as instancias
    private final Integer codigo;
    private final String descricao;

    //aqui construtor
    Perfil(Integer codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    //aqui um codigo para verificar se existe ou não de enum
    //se existir retorna ele se não retorna uma exceção (não necessario)
    public static Perfil toEnum(Integer cod){
        if( cod == null){
            return null;
        }
        for(Perfil x : Perfil.values()){
            if(cod.equals(x.getCodigo())){
                return x;
            }
        }
        throw new IllegalArgumentException("Perfil inválido: " + cod);
    }

}
