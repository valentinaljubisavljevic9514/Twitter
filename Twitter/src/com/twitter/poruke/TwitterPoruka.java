package com.twitter.poruke;

/**
 * Klasa predstavlja Twitter poruku. Svaka od njih sadrzi korisnika i samu poruku.
 * @author ValeVale
 *
 */
public class TwitterPoruka {

	/**
	 * Korisnik poruke se unosi kao String
	 */
	private String korisnik;
	/**
	 * Sama poruka se unosi kao String
	 */
	private String poruka;
	/**
	 * Metoda vraca identitet korisnika
	 * @return korisnik
	 */
	public String getKorisnik() {
		return korisnik;
	}
	/**
	 * Metoda postavlja novu vrednost korisnika
	 * @param korisnik 
	 * * @throws java.lang.RuntimeException ako je uneto ime
	 * <ul> 
	 * <li>null</li>
	 * <li>prazan String</li>
	 * </ul>
	 */
	public void setKorisnik(String korisnik) {
		if (korisnik==null || korisnik == "")
				throw new RuntimeException(
						"Ime korisnika mora biti uneto");
		this.korisnik = korisnik;
	}
	/**
	 * Metoda vraca poruku
	 * @return poruka poruka koju je uneo neko od autora
	 */
	public String getPoruka() {
		return "poruka";
	}
	/**
	 * Metoda postavlja novu vrednost poruke
	 * @param poruka 
	 * * @throws java.lang.RuntimeException ako je uneto ime
	 * <ul> 
	 * <li>null</li>
	 * <li>duzina poruke veca od 140 karaktera</li>
	 * </ul>
	 */
	public void setPoruka(String poruka) {
		if (poruka==null || this.poruka.length()>140)
				throw new RuntimeException(
							"Poruka mora biti uneta i mora imati najvise 140 znakova");
		this.poruka = poruka;
	}
	/**
	 * Metoda toString ispisuje korisnika i poruku koju je on uneo
	 */
	public String toString(){
	return "KORISNIK:"+korisnik+" PORUKA:"+poruka;
	}
	
	}
	
	

