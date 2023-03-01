package rs.fkn.model;

public class Proizvod {
	private String nazivProizvoda;
	private double cena;

	Proizvod(String nazivProizvoda, double cena) {
		this.nazivProizvoda = nazivProizvoda;
		this.cena = cena;
	}
	
	public double getCena() {
		return this.cena;
	}
	
	public String toString() {
		return nazivProizvoda +  " sa cenom " + cena;
	}
}