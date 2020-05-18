package drugikolok.app.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import drugikolok.app.model.Transakcija;

@Repository
public interface TransakcijaRepository extends CrudRepository<Transakcija, Long> {

}
