package drugikolok.app.dto;

import java.time.LocalDateTime;

public class TransakcijaDTO {
	Long id;
	Double iznos;
	LocalDateTime datumValute;
	
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
	
	
}
