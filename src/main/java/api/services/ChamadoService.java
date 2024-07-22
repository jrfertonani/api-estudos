package api.services;

import api.domain.Chamado;
import api.domain.Cliente;
import api.domain.Enums.Prioridade;
import api.domain.Enums.Status;
import api.domain.Tecnico;
import api.domain.dto.ChamadoDTO;
import api.repositories.ChamadoRepository;
import api.services.exceptions.ObjectNotFoundException;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class ChamadoService {

    @Autowired
    private ModelMapper mapper;

    @Autowired
    private ChamadoRepository chamadoRepository;

    @Autowired
    public ClienteService clienteService;
    @Autowired
    public TecnicoService tecnicoService;

    public Chamado findById(@PathVariable Integer id){
        Optional<Chamado> obj = chamadoRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado " +id));
    }

    public List<Chamado> findAll() {
        return chamadoRepository.findAll();
    }

    public Chamado create(@Valid ChamadoDTO chamadoDTO) {
        return chamadoRepository.save(newChamado(chamadoDTO));    }


    private Chamado newChamado(ChamadoDTO obj) {
        Tecnico tecnico = tecnicoService.findById(obj.getTecnico());
        Cliente cliente = clienteService.findById(obj.getCliente());

        Chamado chamado = new Chamado();
        if(obj.getId() != null) {
            chamado.setId(obj.getId());
        }

        if(obj.getStatus().equals(2)) { //obj.getStatus()
            chamado.setDataFechamento(LocalDate.now());
        }

        chamado.setTecnico(tecnico);
        chamado.setCliente(cliente);
        chamado.setPrioridade(Prioridade.toEnum(obj.getPrioridade()));
        chamado.setStatus(Status.toEnum(obj.getStatus()));
        chamado.setTitulo(obj.getTitulo());
        chamado.setObservacoes(obj.getObservacoes());
        return chamado;
    }


    public Chamado update(Integer id, ChamadoDTO chamadoDTO) {
        chamadoDTO.setId(id);
        findById(id);
        Chamado entity = mapper.map(chamadoDTO, Chamado.class);
        return chamadoRepository.save(mapper.map(entity, Chamado.class));
    }
}


