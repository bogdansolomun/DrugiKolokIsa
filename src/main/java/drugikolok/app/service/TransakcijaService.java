package drugikolok.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import drugikolok.app.model.Transakcija;
import drugikolok.app.repository.TransakcijaRepository;

@Service
public class TransakcijaService {
	@Autowired
	TransakcijaRepository repo;
	
	public Iterable<Transakcija> dobaviSve(){
		return repo.findAll();
	}
	
	public Transakcija dobaviPoId(Long id) {
		return repo.findById(id).orElse(null);
	}
	
	public void save(Transakcija obj) {
		repo.save(obj);
	}
	
	public void delete(Long id) {
		repo.deleteById(id);
	}

}
