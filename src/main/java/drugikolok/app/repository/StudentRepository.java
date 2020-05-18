package drugikolok.app.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import drugikolok.app.model.Student;

@Repository
public interface StudentRepository extends CrudRepository<Student, Long> {

	@Query("SELECT s FROM Student as s WHERE s.indeks = :indeks")
	public Student dobaviPoIndeksu(@PathVariable("indeks")String indeks);
}
