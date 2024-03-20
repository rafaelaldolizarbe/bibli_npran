package progweb.biblioteca.dto.escritor;

import lombok.Data;

import java.util.List;
@Data
public class EscritorComLivrosDto {
    private Integer id;
    private String nomeEscritor;
    private String generoLiterario;
    private List<LivroDoEscritorDto> livros;
}
