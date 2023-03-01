package rs.fkn.prodavnica;

import java.util.Scanner;

public class Korisnik {

	private String ime;
	private String prezime;
	private double stanje;

	Korisnik() {}

	public double getStanje() {
		return this.stanje;
	}
	
	public void setStanje(double stanje) {
		this.stanje = stanje;
	}
	
	Korisnik(String ime, String prezime, double stanje) {
		this.ime = ime;
		this.prezime = prezime;
		this.stanje = stanje;
	}

	public static Korisnik kreiranjeKorisnika() {
		System.out.print("Unesite vase ime: ");
		Scanner input = new Scanner(System.in);
		String ime = input.next();
		
		while(!ime.matches("[a-zA-Z]+")) {
			System.out.println("KORISTITE SAMO SLOVA ZA ISPIS IMENA!!!");
			System.out.print("Unesite vase ime: ");
			ime = input.next();
		}
		
		System.out.print("Unesite vase prezime: ");
		String prezime = input.next();
		while(!prezime.matches("[a-zA-Z]+")) {
			System.out.println("KORISTITE SAMO SLOVA ZA ISPIS PREZIMENA!!!");
			System.out.print("Unesite vase prezime: ");
			prezime = input.next();
		}
		System.out.print("Unesite vase stanje na racunu u din.: ");
		double stanje = input.nextDouble();
		if(stanje <= 0) {
			System.out.println("Nemate dovoljno novca na racunu.\nKraj programa!");
			System.exit(0);
			}
		return new Korisnik(ime, prezime, stanje);

	}
}