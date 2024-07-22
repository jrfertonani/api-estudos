package api.resources;

import api.domain.Chamado;
import api.domain.dto.ChamadoDTO;
import api.services.ChamadoService;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

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

   @GetMapping
  public ResponseEntity<List<ChamadoDTO>> findAll(){
        List<ChamadoDTO> list = chamadoService.findAll()
                .stream().map(x -> mapper.map(x, ChamadoDTO.class))
                .collect(Collectors.toList());
        return ResponseEntity.ok().body(list);
    }

   @PostMapping
    public ResponseEntity<ChamadoDTO> create (@Valid @RequestBody ChamadoDTO chamadoDTO){
       URI uri = ServletUriComponentsBuilder
               .fromCurrentRequest()
               .path("/{id}")
               .buildAndExpand(chamadoService.create(chamadoDTO).getId())
               .toUri();
       return ResponseEntity.created(uri).body(chamadoDTO);
   }

   @PutMapping("/{id}")
    public ResponseEntity<ChamadoDTO> update(@PathVariable Integer id,
                                             @Valid @RequestBody ChamadoDTO chamadoDTO){
        Chamado newObj = chamadoService.update(id,chamadoDTO);
       return ResponseEntity.ok().body(mapper.map(chamadoDTO, ChamadoDTO.class));
   }

}
