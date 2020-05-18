package drugikolok.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import drugikolok.app.model.FinansijskaKartica;
import drugikolok.app.repository.FinansijskaKarticaRepository;


@Service
public class FinansijskaKarticaService {
	
	@Autowired
	FinansijskaKarticaRepository repo;
	
	public Iterable<FinansijskaKartica> dobaviSve(){
		return repo.findAll();
	}
	
	public FinansijskaKartica dobaviPoId(Long id) {
		return repo.findById(id).orElse(null);
	}
	
	public void save(FinansijskaKartica obj) {
		repo.save(obj);
	}
	
	public void delete(Long id) {
		repo.deleteById(id);
	}

}
