package rs.fkn;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import rs.fkn.model.Cokolada;
import rs.fkn.model.Kafa;
import rs.fkn.model.Keks;
import rs.fkn.model.Voda;
import rs.fkn.prodavnica.Korisnik;
import rs.fkn.prodavnica.Narudzbina;

public class Prodavnica {

	static List<Kafa> listaKafa = new ArrayList<Kafa>();
	static List<Cokolada> listaCokolade = new ArrayList<Cokolada>();
	static List<Voda> listaVode = new ArrayList<Voda>();
	static List<Keks> listaKeks = new ArrayList<Keks>();


	public static void main(String[] args) {

		pocetnoStanje();

		Korisnik korisnik = Korisnik.kreiranjeKorisnika();

		Narudzbina narudzbina = new Narudzbina(korisnik);

		System.out.print("\nCena kafe po komadu je " 
				+ listaKafa.get(0).getCena() + " din." + "\nUnesite kolicinu kafe koju zelite: ");
		Scanner input = new Scanner(System.in);
		
		int brKafe = input.nextInt();
		double cenaKafe = listaKafa.get(0).getCena();
		while(brKafe > listaKafa.size()) {
			System.out.println("Nemamo tu kolicinu kafe na stanju, preostalo nam je: " 
					+ listaKafa.size() + " komada.");
			System.out.print("Unesite novu kolicinu: ");
			brKafe = input.nextInt();
		}
		
		if(korisnik.getStanje() >= brKafe*cenaKafe) {
			for(int i=0; i<brKafe; i++) {
				Kafa kafa = listaKafa.get(listaKafa.size() - 1);
				narudzbina.dodajProizvod(kafa);
				listaKafa.remove(listaKafa.size() - 1);
			}	
		}else {
			System.out.println("Nemate dovoljno novca za tu kolicinu kafe, trenutno stanje vam je " + korisnik.getStanje() + " din.");
		}
		
		System.out.print("\nCena flase vode je " 
				+ listaVode.get(0).getCena() + " din." + "\nUnesite koliko flasa vode zelite: ");
		int brVode = input.nextInt();
		double cenaVode = listaVode.get(0).getCena();
		
		while(brVode > listaVode.size()) {
			System.out.println("Nemamo tu kolicinu vode na stanju, preostalo nam je: " 
					+ listaVode.size() + " flasa.");
			System.out.print("Unesite novu kolicinu: ");
			brVode = input.nextInt();
		}
		
		if(korisnik.getStanje() >= brVode*cenaVode) {
			for(int i=0; i<brVode; i++) {
				Voda voda = listaVode.get(listaVode.size() - 1);
				narudzbina.dodajProizvod(voda);
				listaVode.remove(listaVode.size() - 1);
			}	
		}else {
			System.out.println("Nemate dovoljno novca za tu kolicinu vode, trenutno stanje na racunu vam je " + korisnik.getStanje() + " din.");
		}
		
		System.out.print("\nCena cokolade po komadu je " 
				+ listaCokolade.get(0).getCena() + " din." + "\nUnesite kolicinu cokolade koju zelite: ");
		
		int brCokolada = input.nextInt();
		double cenaCokolada = listaCokolade.get(0).getCena();
		
		while(brCokolada > listaCokolade.size()) {
			System.out.println("Nemamo tu kolicinu cokolada na stanju, preostalo nam je: " 
					+ listaCokolade.size() + " komada.");
			System.out.print("Unesite novu kolicinu: ");
			brCokolada = input.nextInt();
		}
		
		if(korisnik.getStanje() >= brCokolada*cenaCokolada) {
			for(int i=0; i<brCokolada; i++) {
				Cokolada cokolada = listaCokolade.get(listaCokolade.size() - 1);
				narudzbina.dodajProizvod(cokolada);
				listaCokolade.remove(listaCokolade.size() - 1);
			}	
		}else {
			System.out.println("Nemate dovoljno novca za tu kolicinu cokolada, trenutno stanje vam je " + korisnik.getStanje() + " din.");
		}
		
		System.out.print("\nCena keksa po komadu je " 
				+ listaKeks.get(0).getCena() + " din." + "\nUnesite koju kolicinu keksa zelite: ");
		int brKeks = input.nextInt();
		double cenaKeks = listaKeks.get(0).getCena();
		
		while(brKeks > listaKeks.size()) {
			System.out.println("Nemamo tu kolicinu keksa na stanju, preostalo nam je: " 
					+ listaKeks.size() + " komada.");
			System.out.print("Unesite novu kolicinu: ");
			brVode = input.nextInt();
		}
		
		if(korisnik.getStanje() >= brKeks*cenaKeks) {
			for(int i=0; i<brKeks; i++) {
				Keks keks = listaKeks.get(listaKeks.size() - 1);
				narudzbina.dodajProizvod(keks);
				listaKeks.remove(listaKeks.size() - 1);
			}	
		}else {
			System.out.println("Nemate dovoljno novca za tu kolicinu keksa, trenutno stanje na racunu vam je " + korisnik.getStanje() + " din.");
		}
	
		if(narudzbina.brojProizvoda() != 0) {
			System.out.println("\nNarudzbina: \n" + narudzbina);
		}else {
			System.out.println("Nista niste kupili.");	
		}
		
		System.out.print("Da li zelite da proverite stanje proizvoda u prodavnici? (da/ne) ");
		if(input.next().equals("da")) {
			System.out.println("\nPreostala kolicina robe u prodavnici:\n" + "kafe " + listaKafa.size() + " kom.\n" + "vode " + listaVode.size() + " flasa.\n"
					+ "cokolade " + listaCokolade.size() + " kom.\n" + "keksa " + listaKeks.size() + " kom.\n" + "\nKraj programa!");
		
		}else {
			System.out.println("\nKraj programa!");
		}
				
		input.close();
	}
	

	
	private static void pocetnoStanje() {
		for (int i = 0; i < 20; i++) {
			listaKafa.add(new Kafa());
		}		for (int i = 0; i < 15; i++) {
			listaCokolade.add(new Cokolada());
		}
		for (int i = 0; i < 30; i++) {
			listaVode.add(new Voda());
		}
		for (int i = 0; i < 25; i++) {
			listaKeks.add(new Keks());
		}
	}
}