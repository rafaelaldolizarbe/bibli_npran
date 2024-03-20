package progweb.biblioteca.service;

import org.springframework.stereotype.Service;
import progweb.biblioteca.dto.escritor.EscritorCriacaoDto;
import progweb.biblioteca.dto.escritor.mapper.EscritorMapper;
import progweb.biblioteca.entity.Escritor;
import progweb.biblioteca.repository.EscritorRepository;

import java.util.List;

@Service
public class EscritorService {
    private final EscritorRepository escritorRepository;

    public List<Escritor> procuraTodos(){
        List<Escritor> escritores = this.escritorRepository.findAll();
        return escritores;
    }

    public EscritorService(EscritorRepository escritorRepository) {
        this.escritorRepository = escritorRepository;
    }


    public Escritor salvar(EscritorCriacaoDto escritorCriacaoDto){
        Escritor escritorParaSalvar = EscritorMapper.deDtoParaEscritor(escritorCriacaoDto);
        this.escritorRepository.save(escritorParaSalvar);
        return escritorParaSalvar;
    }
}
