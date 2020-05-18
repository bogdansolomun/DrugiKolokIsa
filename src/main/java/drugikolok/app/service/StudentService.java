package drugikolok.app.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import drugikolok.app.model.Student;
import drugikolok.app.repository.StudentRepository;

@Service
public class StudentService implements UserDetailsService {
	
	@Autowired
	StudentRepository repo;
	
	public Iterable<Student> dobaviSve(){
		return repo.findAll();
	}
	
	public Student dobaviPoId(Long id) {
		return repo.findById(id).orElse(null);
	}
	
	public void save(Student obj) {
		repo.save(obj);
	}
	
	public void delete(Long id) {
		repo.deleteById(id);
	}
	
	@Override
	public UserDetails loadUserByUsername(String indeks) throws UsernameNotFoundException  {
		Student korisnik = repo.dobaviPoIndeksu(indeks);
		
		return new User(korisnik.getIndeks(), korisnik.getLozinka(), new ArrayList<>());
	}
	
	
	
	

}
