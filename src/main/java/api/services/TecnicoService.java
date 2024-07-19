package api.services;

import api.domain.Pessoa;
import api.domain.Tecnico;
import api.domain.dto.TecnicoDTO;
import api.repositories.PessoaRepository;
import api.repositories.TecnicoRepository;
import api.services.exceptions.DataIntegrityViolationException;
import api.services.exceptions.ObjectNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TecnicoService {

    @Autowired
    private ModelMapper mapper;

    @Autowired
    private PessoaRepository pessoaRepository;

    @Autowired
    private TecnicoRepository tecnicoRepository;

    public Tecnico findById(Integer id) {
        Optional<Tecnico> obj = tecnicoRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }

    public List<Tecnico> findAll() {
        return tecnicoRepository.findAll();
    }

    public Tecnico create(TecnicoDTO tecnicoDTO) {
        validaPorCpfEEmail(tecnicoDTO);
        return tecnicoRepository.save(mapper.map(tecnicoDTO, Tecnico.class));
    }

    private void validaPorCpfEEmail(TecnicoDTO DTO) {
        Optional<Pessoa> obj = pessoaRepository.findByCpf(DTO.getCpf());
        if (obj.isPresent() && obj.get().getId() != DTO.getId()) {
            throw new DataIntegrityViolationException("CPF já cadastrado ");
        }
        obj = pessoaRepository.findByEmail(DTO.getEmail());
        if (obj.isPresent() && obj.get().getId() != DTO.getId()) {
            throw new DataIntegrityViolationException("E-Mail já cadastrado ");
        }
    }

    public Tecnico update(Integer id, TecnicoDTO tecnicoDTO) {
        tecnicoDTO.setId(id);
        findById(id);
        validaPorCpfEEmail(tecnicoDTO);
        Tecnico entity = mapper.map(tecnicoDTO, Tecnico.class);
        entity.setId(id);
        return tecnicoRepository.save(entity);
    }
}
