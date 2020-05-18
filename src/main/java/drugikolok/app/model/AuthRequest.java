package drugikolok.app.model;

public class AuthRequest {
	
	private String indeks;
	private String lozinka;
	
	AuthRequest(){
		
	}

	public AuthRequest(String indeks, String lozinka) {
		super();
		this.indeks = indeks;
		this.lozinka = lozinka;
	}

	public String getIndeks() {
		return indeks;
	}

	public void setIndeks(String indeks) {
		this.indeks = indeks;
	}

	public String getLozinka() {
		return lozinka;
	}

	public void setLozinka(String lozinka) {
		this.lozinka = lozinka;
	}
	
	

}
