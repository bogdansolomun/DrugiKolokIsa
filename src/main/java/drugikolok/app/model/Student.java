package drugikolok.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	@Column(unique = true, nullable = false)
	String indeks;
	String ime;
	String prezime;
	@Column(unique = true)
	String email;
	@Column(nullable = false)
	String lozinka;
	@OneToOne
	@JoinColumn(name = "finansijska_kartica_id", nullable = true)
	FinansijskaKartica finansijskaKartica;
	
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Student(Long id, String indeks, String ime, String prezime, String email, String lozinka,
			FinansijskaKartica finansijskaKartica) {
		super();
		this.id = id;
		this.indeks = indeks;
		this.ime = ime;
		this.prezime = prezime;
		this.email = email;
		this.lozinka = lozinka;
		this.finansijskaKartica = finansijskaKartica;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getIndeks() {
		return indeks;
	}

	public void setIndeks(String indeks) {
		this.indeks = indeks;
	}

	public String getIme() {
		return ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public String getPrezime() {
		return prezime;
	}

	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLozinka() {
		return lozinka;
	}

	public void setLozinka(String lozinka) {
		this.lozinka = lozinka;
	}

	public FinansijskaKartica getFinansijskaKartica() {
		return finansijskaKartica;
	}

	public void setFinansijskaKartica(FinansijskaKartica finansijskaKartica) {
		this.finansijskaKartica = finansijskaKartica;
	}
	
	
	

}
