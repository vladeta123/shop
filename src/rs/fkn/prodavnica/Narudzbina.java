package rs.fkn.prodavnica;

import java.util.ArrayList;
import java.util.List;

import rs.fkn.model.Cokolada;
import rs.fkn.model.Kafa;
import rs.fkn.model.Keks;
import rs.fkn.model.Proizvod;
import rs.fkn.model.Voda;

public class Narudzbina {
	private Korisnik korisnik;
	private List<Proizvod> proizvodi;
	private double racun;

	public Narudzbina(Korisnik korisnik) {
		this.korisnik = korisnik;
		proizvodi = new ArrayList<Proizvod>();
		racun = 0.0;
	}
	
	public int brojProizvoda() {
		return proizvodi.size();
	}

	public void dodajProizvod(Proizvod proizvod) {
		this.proizvodi.add(proizvod);
		this.racun += proizvod.getCena();
		double trenutnoStanje = korisnik.getStanje();
		korisnik.setStanje(trenutnoStanje - proizvod.getCena());
		
	}
	
	public String toString() {
		String rezultat = "";
		int brKafe = 0, brVoda = 0;
		int brCokolada = 0, brKeks = 0;
		Kafa kafa = null;
		Voda voda = null;
		Cokolada cokolada = null;
		Keks keks = null;
		
		for(int i = 0; i<proizvodi.size(); i++) {
			if(proizvodi.get(i) instanceof Kafa) {
				brKafe++;
				kafa = (Kafa)proizvodi.get(i);
			}
			if(proizvodi.get(i) instanceof Voda) {
				brVoda++;
				voda = (Voda)proizvodi.get(i);
			}
			if(proizvodi.get(i) instanceof Cokolada) {
				brCokolada++;
				cokolada = (Cokolada)proizvodi.get(i);
			}
			if(proizvodi.get(i) instanceof Keks) {
				brKeks++;
				keks = (Keks)proizvodi.get(i);
			}
		}
		
		rezultat += brKafe != 0 ? (brKafe + " x " + kafa + " din." + " = " + brKafe*kafa.getCena() + " din.\n") : "";
		rezultat += brVoda != 0 ? (brVoda + " x " + voda + " din." + " = " + brVoda*voda.getCena() + " din.\n") : "";
		rezultat += brCokolada != 0 ? (brCokolada + " x " + cokolada + " din." + " = " + brCokolada*cokolada.getCena() + " din.\n") : "";
		rezultat += brKeks != 0 ? (brKeks + " x " + keks + " din." + " = " + brKeks*keks.getCena() + " din.\n") : "";

		rezultat += "Racun: " + racun + " din.";
		return rezultat;
	}
}
