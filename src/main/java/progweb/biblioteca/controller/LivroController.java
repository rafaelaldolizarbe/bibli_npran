package progweb.biblioteca.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import progweb.biblioteca.dto.escritor.LivroDoEscritorDto;
import progweb.biblioteca.dto.livro.EscritorComLivrosResponseDto;
import progweb.biblioteca.dto.livro.LivroDoEscritorResponseDto;
import progweb.biblioteca.entity.Escritor;
import progweb.biblioteca.entity.Livro;
import progweb.biblioteca.repository.LivroRepository;
import progweb.biblioteca.service.LivroService;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@RestController
@RequiredArgsConstructor
@RequestMapping("/livros")
public class LivroController {

    private final LivroService service;

    @GetMapping
    public ResponseEntity<List<LivroDoEscritorResponseDto>> findAll() {
        List<Livro> livros = service.listar();

        if (livros.isEmpty()) {
            ResponseEntity.noContent().build();
        }
        List<LivroDoEscritorResponseDto> listaDto = new ArrayList<>();
        for (Livro livro : livros) {
            LivroDoEscritorResponseDto livroDoEscritorResponseDto = new LivroDoEscritorResponseDto();
            livroDoEscritorResponseDto.setId(livro.getId());
            livroDoEscritorResponseDto.setTitulo(livro.getTitulo());
            livroDoEscritorResponseDto.setIsbn(livro.getIsbn());
            livroDoEscritorResponseDto.setDataPublicada(livro.getDataPublicada());
            if (Objects.nonNull(livro.getEscritor())){
                Escritor escritor=livro.getEscritor();//Na resposta Json, este objeto irá retornar um dos registros
                EscritorComLivrosResponseDto escritorDto= new EscritorComLivrosResponseDto();
                escritorDto.setId(escritor.getId());
                escritorDto.setNomeEscritor(escritor.getNome());
                escritorDto.setGeneroLiterario(escritor.getGeneroLiterario());
                livroDoEscritorResponseDto.setEscritor(escritorDto);
            }
            listaDto.add(livroDoEscritorResponseDto);
        }
        return ResponseEntity.ok(listaDto);
    }
//    @GetMapping("/escritores")
//    public ResponseEntity<List<LivroDoEscritorResponseDto>> findByEscritorNome(@RequestParam String nome){
//
//        List<LivroDoEscritorResponseDto> all = service.livroPorNome(nome);
//
//        if (all.isEmpty()){
//            return ResponseEntity.noContent().build();
//        }
//
//        return ResponseEntity.ok(all);
//    }
//    @PostMapping()
//    public ResponseEntity<LivroDoEscritorResponseDto> criar(@Valid @RequestBody Livro livro);




//    @GetMapping("/escritores/genero")
//    public ResponseEntity<List<Livro>> findByGeneroLiterario(@RequestParam String genero){
//
//        List<Livro> all = repository.findByEscritorGeneroLiterarioContainsIgnoreCase(genero);
//
//        if (all.isEmpty()){
//            return ResponseEntity.noContent().build();
//        }
//
//        return ResponseEntity.ok(all);
//    }
}
