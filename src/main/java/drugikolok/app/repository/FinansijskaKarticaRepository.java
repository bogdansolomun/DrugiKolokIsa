package drugikolok.app.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import drugikolok.app.model.FinansijskaKartica;

@Repository
public interface FinansijskaKarticaRepository extends CrudRepository<FinansijskaKartica, Long> {

}
