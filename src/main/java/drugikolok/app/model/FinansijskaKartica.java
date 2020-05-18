package drugikolok.app.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class FinansijskaKartica {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	
	String pozivNaBroj;
	Double stanje;
	
	@OneToMany(mappedBy = "finansijskaKartica")
	List<Transakcija> transakcije;
	
	public FinansijskaKartica() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public FinansijskaKartica(Long id, String pozivNaBroj, Double stanje, List<Transakcija> transakcije) {
		super();
		this.id = id;
		this.pozivNaBroj = pozivNaBroj;
		this.stanje = stanje;
		this.transakcije = transakcije;
	}
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getPozivNaBroj() {
		return pozivNaBroj;
	}
	public void setPozivNaBroj(String pozivNaBroj) {
		this.pozivNaBroj = pozivNaBroj;
	}
	public Double getStanje() {
		return stanje;
	}
	public void setStanje(Double stanje) {
		this.stanje = stanje;
	}
	public List<Transakcija> getTransakcije() {
		return transakcije;
	}
	public void setTransakcije(List<Transakcija> transakcije) {
		this.transakcije = transakcije;
	}
	
	
	

}
