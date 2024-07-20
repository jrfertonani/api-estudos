package api.resources;

import api.domain.Chamado;
import api.domain.dto.ChamadoDTO;
import api.services.ChamadoService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/chamados")
public class ChamadoResource {

    @Autowired
    private ModelMapper mapper;

    @Autowired
    private ChamadoService chamadoService;

    @GetMapping("/{id}")
   public ResponseEntity<ChamadoDTO> findById(@PathVariable Integer id){
        Chamado entity = chamadoService.findById(id);
        return ResponseEntity.ok().body(mapper.map(entity, ChamadoDTO.class));
    }

}
