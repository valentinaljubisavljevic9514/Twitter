package com.twitter;

import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.twitter.poruke.TwitterPoruka;

public class TwitterTest {

	private Twitter twitter;
	
	@Before
	public void setUp() throws Exception {
		twitter = new Twitter();
	}

	@After
	public void tearDown() throws Exception {
		twitter = null;
	}

	@Test
	public void testVratiSvePoruke() {
		TwitterPoruka tp1 = new TwitterPoruka();
		TwitterPoruka tp2 = new TwitterPoruka();
		
		twitter.unesi("k1", "p1");
		twitter.unesi("k2", "p2");
		
		tp1.setKorisnik("k1");
		tp1.setPoruka("p1");
		tp2.setKorisnik("k2");
		tp2.setPoruka("p2");
		
		assertEquals(tp1, twitter.vratiSvePoruke().get(0));
		assertEquals(tp2, twitter.vratiSvePoruke().get(1));
	}

	@Test
	public void testUnesiSveOkej() {
		TwitterPoruka tp = new TwitterPoruka();
	
		LinkedList<TwitterPoruka> listaPoruka = new LinkedList<TwitterPoruka>();
		
		twitter.unesi("k1", "p1");
		
		tp.setKorisnik("k1");
		tp.setPoruka("p1");
		
		listaPoruka.add(tp);
		
		assertEquals(listaPoruka, twitter.vratiSvePoruke());
		
	}

	@Test (expected = java.lang.RuntimeException.class)
	public void testUnesiNull() {
		
		twitter.unesi("k1", null);
		twitter.unesi(null, "p2");
		
	}
	
	@Test (expected = java.lang.RuntimeException.class)
	public void testUnesiPrazanString() {
		
		twitter.unesi("k1", "");
		twitter.unesi("", "p2");
		
	}
	
	@Test
	public void testVratiPorukeSveOkej() {
		twitter.unesi("Aleksa", "Lep dan danas");
		twitter.unesi("Milica", "Lep je Pariz");
		twitter.unesi("Marko", "Hej, sta radite?");
		
		TwitterPoruka tp1 = new TwitterPoruka();
		TwitterPoruka tp2 = new TwitterPoruka();
		
		tp1.setKorisnik("Aleksa");
		tp1.setPoruka("Lep dan danas");
		tp2.setKorisnik("Milica");
		tp2.setPoruka("Lep je Pariz");
		
		TwitterPoruka[] porukeSaTagom = new TwitterPoruka[2];
		
		porukeSaTagom[0] = tp1;
		porukeSaTagom[1] = tp2;
		
		
		assertArrayEquals(porukeSaTagom, twitter.vratiPoruke(2, "Lep"));
		
	}


	@Test (expected = java.lang.RuntimeException.class)
	public void testVratiPorukeNull() {
		twitter.vratiPoruke(1, null);
	}
	
	@Test (expected = java.lang.RuntimeException.class)
	public void testVratiPorukePrazanString() {
		twitter.vratiPoruke(1, "");
	}
	
}
