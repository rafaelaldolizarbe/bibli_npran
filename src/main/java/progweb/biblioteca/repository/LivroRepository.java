package progweb.biblioteca.repository;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import progweb.biblioteca.dto.escritor.LivroDoEscritorDto;
import progweb.biblioteca.dto.livro.LivroDoEscritorResponseDto;
import progweb.biblioteca.entity.Livro;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface LivroRepository extends JpaRepository<Livro,Integer> {

//    List<LivroDoEscritorResponseDto> findByEscritorNomeEscritorContainsIgnoreCase(String nome);

    Optional<Livro> findFirstByOrderByValorMercadoDesc();

    List<Livro> findTop5ByDataPublicadaLessThanEqual(LocalDate periodo);

//    @Transactional
//    @Query("UPDATE Livro f SET f.titulo = :titulo, f.autor=:autor  WHERE f.id = :id")
//    Integer renomearLivro(String titulo, String autor, Integer id);

    @Modifying
    @Transactional
    @Query("DELETE FROM Livro f WHERE f.id = :id")
    void deletarLivroPorId(Integer id);

//    List<Livro> findByEscritorGeneroLiterarioContainsIgnoreCase(String nome);

//    @Query("SELECT l FROM Livro l WHERE l.escritor.nomeEscritor = :nome") // named paremeter
//    List<Livro> buscarPorNome(String nome);
}
