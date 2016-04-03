package com.twitter;

import java.util.LinkedList;
import com.twitter.poruke.TwitterPoruka;

/**
 * Klasa Twitter sadrzi metode za unos i pretragu poruke na twitter-u
 * @author ValeVale
 *
 */
public class Twitter {

	/**
	 * Lista poruka na twitter-u
	 */
	private LinkedList<TwitterPoruka> poruke = new LinkedList<TwitterPoruka>();
	/**
	 * Metoda vraca sve twitter poruke
	 * @return poruke sve poruke koje su korisnici unosili
	 */
	public LinkedList<TwitterPoruka> vratiSvePoruke(){
		return poruke;
	}
	/**
	 * Metoda kao parametre dobija korisnika i poruku koju on zeli da unese
	 * a zatim unosi tu poruku na kraj liste poruka 
	 * @param korisnik korisnik koji zeli da unese datu poruku
	 * @param poruka poruka koju porisnik zeli da objavi na twitter-u
	 * 
	 */
	public void unesi(String korisnik, String poruka) {
		//Pravi se nova poruka i puni podacima.
		TwitterPoruka tp = new TwitterPoruka();
		tp.setKorisnik(korisnik);
		tp.setPoruka(poruka);
		
		//Poruka se unosi u listu na kraj
		poruke.addLast(tp);
	}
	/**
	 * Metoda kao paremetre dobija tag na osnovu koga se vrsi pretraga poruka 
	 * i maksimalni broj poruka koje zelimo da nadjemo;
	 * vraca niz za svim porukama koje u sebi sadrze dati tag
	 * @param maxBroj maksimalni broj poruka koje treba uneti u niz
	 * @param tag na osnovu koga se pretrazuju poruke
	 * @return rezultat niz poruka koje sadrze tag
	 * @throws java.lang.RuntimeException ako je uneti tag
	 * <ul> 
	 * <li>null</li>
	 * <li>duzina poruke veca od 140 karaktera</li>
	 * </ul>
	 */
	public TwitterPoruka[] vratiPoruke(int maxBroj, String tag) {
		if (tag==null || tag == "")
			throw new RuntimeException("Morate uneti tag");
		
		//Ako je maxBroj <=0, vraca maxBroj se postavlja na 100 poruka
		if (maxBroj<=0)
			maxBroj = 100;
		
		//Pomocna promenljiva koja predstavlja brojac upisanih poruka
		int brojac = 0;
		
		//Pomocni niz koja predstavlja rezultat pretrage tj. sadrzace
		//sve poruke koje u sebi imaju zadati tag
		TwitterPoruka[] rezultat = new TwitterPoruka[maxBroj];
		
		//Pretrazuju se poruke i traze se one koje sadrze tag.
		//Ako se nadje neka takva, i ako nije prekoracen maxBroj
		//ona se upisuje u niz. Ako je prekoracen maxBroj,pretraga
		//se prekida.
		for (int i = 0; i < poruke.size(); i++)
			if (poruke.get(i).getPoruka().indexOf(tag)!= -1)
				if (brojac < maxBroj){
					rezultat[brojac]=poruke.get(i);
					brojac++;
				}
				else break;
		return rezultat;
	}
}



