package api.repositories;

import api.domain.Chamado;
import org.hibernate.type.descriptor.converter.spi.JpaAttributeConverter;
import org.springframework.stereotype.Repository;

@Repository
public interface ChamadoRepository extends JpaAttributeConverter<Chamado, Integer> {
}
