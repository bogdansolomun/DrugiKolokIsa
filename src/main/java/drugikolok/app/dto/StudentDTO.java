package drugikolok.app.dto;

import drugikolok.app.model.FinansijskaKartica;

public class StudentDTO {
	Long id;
	String indeks;
	String ime;
	String prezime;
	String email;
	String lozinka;
	FinansijskaKarticaDTO finansijskaKartica;
	
	
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
	public FinansijskaKarticaDTO getFinansijskaKartica() {
		return finansijskaKartica;
	}
	public void setFinansijskaKartica(FinansijskaKarticaDTO finansijskaKartica) {
		this.finansijskaKartica = finansijskaKartica;
	}
	

}
