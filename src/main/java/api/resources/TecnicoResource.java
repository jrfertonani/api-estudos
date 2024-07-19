package api.resources;

import api.domain.dto.TecnicoDTO;
import api.services.TecnicoService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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



}
