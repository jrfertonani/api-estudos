package api.resources;

import api.services.LivroService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/livros")
public class LivroResource {

    @Autowired
    private ModelMapper mapper;

    @Autowired
    private LivroService service;

    @PostMapping
    private ResponseEntity<livroDTO> create(@RequestBody livroDTO DTO ){
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(service.create(DTO).getId())
                .toUri();
        return ResponseEntity.created(uri).body(DTO);
    }

    @GetMapping
    private ResponseEntity<List<livroDTO>> findALl(){
        return ResponseEntity.ok().body(
                service.findAll()
                        .stream()
                        .map(x -> mapper.map(x,livroDTO.class))
                        .collect(Collectors.toList())
        );
    }

    @GetMapping("/{id}")
    private ResponseEntity<livroDTO> findById(@PathVariable Integer id){
        return ResponseEntity.ok().body(mapper.map(service.findById(id), livroDTO.class));
    }

    @PutMapping("/{id}")
    private ResponseEntity<livroDTO> update(@PathVariable Integer id,
                                            @RequestBody livroDTO DTO){
        return ResponseEntity.ok().body(mapper.map(service.update(DTO), livroDTO.class));
    }

    @DeleteMapping("/{id}")
    private ResponseEntity<livroDTO> delete (@PathVariable Integer id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}
