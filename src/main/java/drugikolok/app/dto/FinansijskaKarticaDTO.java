package drugikolok.app.dto;

import java.util.List;

import drugikolok.app.model.Transakcija;

public class FinansijskaKarticaDTO {
	
	Long id;
	String pozivNaBroj;
	Double stanje;
	List<TransakcijaDTO> transakcije;
	
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
	public List<TransakcijaDTO> getTransakcije() {
		return transakcije;
	}
	public void setTransakcije(List<TransakcijaDTO> transakcije) {
		this.transakcije = transakcije;
	}
	
	

}
