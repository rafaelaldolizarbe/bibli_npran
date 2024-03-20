package progweb.biblioteca.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import progweb.biblioteca.dto.escritor.EscritorComLivrosDto;
import progweb.biblioteca.dto.escritor.EscritorCriacaoDto;
import progweb.biblioteca.dto.escritor.mapper.EscritorMapper;
import progweb.biblioteca.entity.Escritor;
import progweb.biblioteca.repository.EscritorRepository;
import progweb.biblioteca.service.EscritorService;

import java.util.List;
@RestController
@RequiredArgsConstructor
@RequestMapping("/escritores")
public class EscritorController {

    private final EscritorService escritorService;

    @GetMapping
    public ResponseEntity<List<EscritorComLivrosDto>> findAll(){
        List<Escritor> all = escritorService.procuraTodos();

        if (all.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        // Dependencia STREAM
        List<EscritorComLivrosDto> escritorDtos = all.stream()
                .map(EscritorMapper::toEscritorComLivroDto)
                .toList();

        return ResponseEntity.ok(escritorDtos);
    }
    @PostMapping
    public ResponseEntity<EscritorCriacaoDto> cadastrarEscritor(@RequestBody @Valid Escritor escritor){
    EscritorCriacaoDto escritorCriacaoDto = EscritorMapper.toEscritorCriacaoDto(escritor);
    this.escritorService.salvar(escritorCriacaoDto);
    return ResponseEntity.ok(escritorCriacaoDto);
    }
}
