package progweb.biblioteca.dto.livro;

import lombok.Data;

@Data
public class EscritorComLivrosResponseDto {
    private Integer id;
    private String nomeEscritor;
    private String generoLiterario;
}
