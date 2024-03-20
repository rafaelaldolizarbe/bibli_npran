package progweb.biblioteca.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import progweb.biblioteca.entity.Escritor;

public interface EscritorRepository extends JpaRepository<Escritor, Integer> {

}
