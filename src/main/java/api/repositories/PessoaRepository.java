package api.repositories;

import api.domain.Pessoa;
import org.hibernate.type.descriptor.converter.spi.JpaAttributeConverter;
import org.springframework.stereotype.Repository;

@Repository
public interface PessoaRepository extends JpaAttributeConverter<Pessoa, Integer> {
}
