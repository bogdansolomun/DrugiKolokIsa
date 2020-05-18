package drugikolok.app.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Transakcija {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	Double iznos;
	LocalDateTime datumValute;
	
	@ManyToOne
	FinansijskaKartica finansijskaKartica;
	
	public Transakcija() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Transakcija(Long id, Double iznos, LocalDateTime datumValute, FinansijskaKartica finansijskaKartica) {
		super();
		this.id = id;
		this.iznos = iznos;
		this.datumValute = datumValute;
		this.finansijskaKartica = finansijskaKartica;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getIznos() {
		return iznos;
	}

	public void setIznos(Double iznos) {
		this.iznos = iznos;
	}

	public LocalDateTime getDatumValute() {
		return datumValute;
	}

	public void setDatumValute(LocalDateTime datumValute) {
		this.datumValute = datumValute;
	}

	public FinansijskaKartica getFinansijskaKartica() {
		return finansijskaKartica;
	}

	public void setFinansijskaKartica(FinansijskaKartica finansijskaKartica) {
		this.finansijskaKartica = finansijskaKartica;
	}
	
	

}
