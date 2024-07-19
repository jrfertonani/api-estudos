package api.repositories;

import api.domain.Cliente;
import org.hibernate.type.descriptor.converter.spi.JpaAttributeConverter;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaAttributeConverter<Cliente, Integer> {
}
