package com.twitter.poruke;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TwitterPorukaTest extends TwitterPoruka{

	private TwitterPoruka poruka;

	@Before
	public void setUp() throws Exception {
		poruka = new TwitterPoruka();
	}

	@After
	public void tearDown() throws Exception {
		poruka = null;
	}

	@Test
	public void testSetKorisnikSveOkej() {
		String korisnik = "Aleksa";
		
		poruka.setKorisnik(korisnik);
		
		assertEquals(korisnik, poruka.getKorisnik());
	}

	@Test (expected = java.lang.RuntimeException.class)
	public void testSetKorisnikNull() {
		
		poruka.setKorisnik(null);
	}
	
	@Test (expected = java.lang.RuntimeException.class)
	public void testSetKorisnikPrazanString() {
		
		poruka.setKorisnik("");
	}
	
	@Test
	public void testSetPorukaSveOkej() {
		
		String p = "poruka";
		
		poruka.setPoruka(p);
		
		assertEquals(p, poruka.getPoruka());
	}
	
	@Test (expected = java.lang.RuntimeException.class)
	public void testSetPorukaNull() {
	
		poruka.setPoruka(null);
	}
	
	@Test (expected = java.lang.RuntimeException.class)
	public void testSetPorukaDuzinaPorukeVecaOdDozvoljene() {
	
		poruka.setPoruka("hahahahahahhhahahahahahahahahahahahhhahaahahahahahahahahhaha"
				+ "hahahahhhahah"
				+ "hahahahhahaha"
				+ "ahahahahahahaha"
				+ "hahahhahahhaha"
				+ "hahahaha"
				+ "hahahahahahh"
				+ "ahahahahahahahahahahhahahahhaahahhahahaha");
	}

	@Test
	public void testToStringSveOkej() {
		String k = "Aleksandar";
		String p = "Poruka na twitteru";
		
		String povratnaVrednost = "KORISNIK:"+k+" PORUKA:"+p;
		
		poruka.setKorisnik(k);
		poruka.setPoruka(p);
		
		assertEquals(povratnaVrednost, poruka.toString());
	}

}
