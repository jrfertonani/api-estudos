package api.services;

import api.domain.Pessoa;
import api.domain.Cliente;
import api.domain.dto.ClienteDTO;
import api.repositories.PessoaRepository;
import api.repositories.ClienteRepository;
import api.services.exceptions.DataIntegrityViolationException;
import api.services.exceptions.ObjectNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ModelMapper mapper;

    @Autowired
    private PessoaRepository pessoaRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    public Cliente findById(Integer id) {
        Optional<Cliente> obj = clienteRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }

    public List<Cliente> findAll() {
        return clienteRepository.findAll();
    }

    public Cliente create(ClienteDTO clienteDTO) {
        validaPorCpfEEmail(clienteDTO);
        return clienteRepository.save(mapper.map(clienteDTO, Cliente.class));
    }

    private void validaPorCpfEEmail(ClienteDTO DTO) {
        Optional<Pessoa> obj = pessoaRepository.findByCpf(DTO.getCpf());
        if (obj.isPresent() && obj.get().getId() != DTO.getId()) {
            throw new DataIntegrityViolationException("CPF já cadastrado ");
        }
        obj = pessoaRepository.findByEmail(DTO.getEmail());
        if (obj.isPresent() && obj.get().getId() != DTO.getId()) {
            throw new DataIntegrityViolationException("E-Mail já cadastrado ");
        }
    }

    public Cliente update(Integer id, ClienteDTO clienteDTO) {
        clienteDTO.setId(id);
        findById(id);
        validaPorCpfEEmail(clienteDTO);
        Cliente entity = mapper.map(clienteDTO, Cliente.class);
        entity.setId(id);
        return clienteRepository.save(entity);
    }

    public void delete(Integer id) {
        findById(id);
        clienteRepository.deleteById(id);
    }
}
