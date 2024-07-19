package api.repositories;

import api.domain.Tecnico;
import org.hibernate.type.descriptor.converter.spi.JpaAttributeConverter;
import org.springframework.stereotype.Repository;

@Repository
public interface TecnicoRepository extends JpaAttributeConverter<Tecnico, Integer> {
}
