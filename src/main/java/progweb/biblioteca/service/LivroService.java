package progweb.biblioteca.service;

import progweb.biblioteca.dto.escritor.LivroDoEscritorDto;
import progweb.biblioteca.dto.livro.LivroDoEscritorResponseDto;
import progweb.biblioteca.entity.Livro;
import progweb.biblioteca.exception.EntidadeNaoEncontradaException;
import progweb.biblioteca.repository.LivroRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class LivroService {

    private final LivroRepository repository;

    public LivroService(LivroRepository livroRepository) {
        this.repository = livroRepository;
    }


    public Livro salvar(Livro livro) {
        Livro livroSalvo = this.repository.save(livro);
        return livroSalvo;
    }

    public List<Livro> listar() {
        List<Livro> livros = this.repository.findAll();
        return livros;
    }
//    public List<LivroDoEscritorResponseDto> livroPorNome(String nome){
//        List<LivroDoEscritorResponseDto> livrosPorEscritor =this.repository.findByEscritorNomeEscritorContainsIgnoreCase(nome);
//        return livrosPorEscritor;
//    }

    public Livro buscarPorId(int id) {
        Livro livro = this.repository.findById(id).orElseThrow(
                () -> new EntidadeNaoEncontradaException("Livro não encontrado")
        );
//        Optional<Livro> livroOpt = this.repository.findById(id);
//
//        if (livroOpt.isEmpty()) {
//            throw new EntidadeNaoEncontradaException("Livro não encontrado");
//        }
//
//        return livroOpt.get();
        return livro;
    }
    public Livro pegarMaisCaro(){
        Optional<Livro> livro=this.repository.findFirstByOrderByValorMercadoDesc();
        return livro.get();
    }

    public Livro atualizarLivro(int id, Livro livroAtualizado) {
        Livro livroaAtualizar = this.buscarPorId(id);

        livroAtualizado.setId(livroaAtualizar.getId());

        return repository.save(livroAtualizado);
    }

    public void deletar(int id) {

        Livro livro = this.buscarPorId(id);

        repository.deletarLivroPorId(id);
    }

//    public void atualizarTituloAutor(int id, String novoTitulo, String novoAutor) {
//        this.buscarPorId(id);
//        this.repository.renomearLivro(novoTitulo, novoAutor, id);
//    }
    public List<Livro> top5Publicacao(LocalDate data){
        return this.repository.findTop5ByDataPublicadaLessThanEqual(data);
    }


    public boolean oIdExiste(int id) {
        Boolean result = this.repository.existsById(id);
        return result;
    }


}

