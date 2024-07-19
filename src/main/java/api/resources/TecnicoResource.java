package api.resources;

import api.domain.dto.TecnicoDTO;
import api.services.TecnicoService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/tecnicos")
public class TecnicoResource {

    @Autowired
    private ModelMapper mapper;

    @Autowired
    private TecnicoService tecnicoService;

    @GetMapping("/{id}")
    public ResponseEntity<TecnicoDTO> findById(@PathVariable Integer id){
        return ResponseEntity.ok().body(mapper.map(tecnicoService.findById(id), TecnicoDTO.class));
    }

    @GetMapping
    public ResponseEntity<List<TecnicoDTO>> findAll(){
        List<TecnicoDTO> list = tecnicoService.findAll()
                .stream().map(x -> mapper.map(x, TecnicoDTO.class))
                .collect(Collectors.toList());
        return ResponseEntity.ok().body(list);
    }

    @PostMapping
    public ResponseEntity<TecnicoDTO> create(@RequestBody TecnicoDTO tecnicoDTO){
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(tecnicoService.create(tecnicoDTO))
                .toUri();
        return ResponseEntity.created(uri).body(tecnicoDTO);
    }
}
