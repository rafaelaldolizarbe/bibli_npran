package progweb.biblioteca.dto.livro;


import lombok.Data;

import java.time.LocalDate;
@Data
public class LivroDoEscritorResponseDto {
    private Integer id;
    private String titulo;
    private Double valorMercado;
    private String isbn;
    private LocalDate dataPublicada;
    private EscritorComLivrosResponseDto escritor;
}
