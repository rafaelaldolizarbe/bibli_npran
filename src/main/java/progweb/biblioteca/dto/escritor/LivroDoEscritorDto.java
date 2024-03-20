package progweb.biblioteca.dto.escritor;

import lombok.Data;

import java.time.LocalDate;
@Data
public class LivroDoEscritorDto {
    private Integer id;
    private String titulo;
    private Double valorMercado;
    private String isbn;
    private LocalDate dataPublicada;
}
