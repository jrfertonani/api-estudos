package api.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter     @Setter
@AllArgsConstructor
@NoArgsConstructor
public class userDTO {

    private Integer id;
    private String name;
    private String email;

   // @JsonIgnore - para ignorar retornos para o usuario
}
