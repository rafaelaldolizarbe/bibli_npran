package progweb.biblioteca.dto.escritor.mapper;

import progweb.biblioteca.dto.escritor.EscritorComLivrosDto;
import progweb.biblioteca.dto.escritor.EscritorCriacaoDto;
import progweb.biblioteca.dto.escritor.LivroDoEscritorDto;
import progweb.biblioteca.entity.Escritor;
import progweb.biblioteca.entity.Livro;

import java.util.List;

public class EscritorMapper {
    public static EscritorComLivrosDto toEscritorComLivroDto(Escritor escritorEntidade) {
        if (escritorEntidade == null) {

            return null;
        }

        EscritorComLivrosDto escritorDto = new EscritorComLivrosDto();
        escritorDto.setId(escritorEntidade.getId());
        escritorDto.setNomeEscritor(escritorEntidade.getNome());
        escritorDto.setGeneroLiterario(escritorEntidade.getGeneroLiterario());

//        if (Objects.nonNull(escritorEntidade.getLivros())) {
        if(!escritorEntidade.getLivros().isEmpty()){
            List<Livro> livros = escritorEntidade.getLivros();

            List<LivroDoEscritorDto> listalivros = livros.stream()
                    .map(EscritorMapper::toLivrodoEscritorDto)
                    .toList();

            escritorDto.setLivros(listalivros);
        }
        return escritorDto;
    }
    public static Escritor deDtoParaEscritor(EscritorCriacaoDto escritorCriacaoDto){
        if(escritorCriacaoDto==null){
            return null;
        }
        Escritor escritorParaSalvar = new Escritor();
        escritorParaSalvar.setNome(escritorCriacaoDto.getNomeEscritor());
        escritorParaSalvar.setGeneroLiterario(escritorCriacaoDto.getGeneroLiterario());
        return escritorParaSalvar;

    }

    public static LivroDoEscritorDto toLivrodoEscritorDto(Livro livroEntidade) {
        if (livroEntidade == null) {
            return null;
        }
        LivroDoEscritorDto livroEscritorDto = new LivroDoEscritorDto();
        livroEscritorDto.setId(livroEntidade.getId());
        livroEscritorDto.setTitulo(livroEntidade.getTitulo());
        livroEscritorDto.setValorMercado(livroEntidade.getValorMercado());
        livroEscritorDto.setIsbn(livroEntidade.getIsbn());
        livroEscritorDto.setDataPublicada(livroEntidade.getDataPublicada());
        return livroEscritorDto;
    }
    public static EscritorCriacaoDto toEscritorCriacaoDto(Escritor escritorEntidade){
        if (escritorEntidade== null){
            return null;
        }
        EscritorCriacaoDto escritorCriacaoDto= new EscritorCriacaoDto();
        escritorCriacaoDto.setNomeEscritor(escritorEntidade.getNome());
        escritorCriacaoDto.setGeneroLiterario(escritorEntidade.getGeneroLiterario());
        return escritorCriacaoDto;
    }
}
